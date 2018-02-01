package jp.metroengines.metrocheckin.activity;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.ImageFormat;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureRequest;
import android.media.Image;
import android.media.ImageReader;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.Button;
import android.widget.Toast;

import com.yanzhenjie.nohttp.RequestMethod;
import com.yanzhenjie.nohttp.rest.Response;
import com.yanzhenjie.nohttp.rest.StringRequest;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import jp.metroengines.metrocheckin.R;
import jp.metroengines.metrocheckin.bean.DetectFaceBean;
import jp.metroengines.metrocheckin.bean.MPDBean;
import jp.metroengines.metrocheckin.bean.ReservationBean;
import jp.metroengines.metrocheckin.helper.FaceHelper;
import jp.metroengines.metrocheckin.utils.CommonUtils;
import jp.metroengines.metrocheckin.utils.HttpUtils;
import jp.metroengines.metrocheckin.utils.SPUtils;


public class PassportActivity extends BaseActivity {

    @BindView(R.id.surface_view)
    SurfaceView mSurfaceView;

    SurfaceHolder mSurfaceHolder;

    private static final SparseIntArray ORIENTATIONS = new SparseIntArray();

    ///为了使照片竖直显示
    static {
        ORIENTATIONS.append(Surface.ROTATION_0, 90);
        ORIENTATIONS.append(Surface.ROTATION_90, 0);
        ORIENTATIONS.append(Surface.ROTATION_180, 270);
        ORIENTATIONS.append(Surface.ROTATION_270, 180);
    }

    @BindView(R.id.bt_shoot)
    Button btShoot;

    private CameraManager mCameraManager;//摄像头管理器
    private Handler childHandler, mainHandler;
    private String  mCameraID = "" + CameraCharacteristics.LENS_FACING_BACK;;//摄像头Id 0 为后  1 为前
    private ImageReader mImageReader;
    private CameraCaptureSession mCameraCaptureSession;
    private CameraDevice mCameraDevice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passport);
        ButterKnife.bind(this);
        initSurfaceView();
    }

    private void initSurfaceView() {
        mSurfaceHolder = mSurfaceView.getHolder();
        mSurfaceHolder.setKeepScreenOn(true);
        // mSurfaceView添加回调
        mSurfaceHolder.addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder holder) { //SurfaceView创建
                // 初始化Camera
                initCamera2();
            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) { //SurfaceView销毁
                // 释放Camera资源
                if (null != mCameraDevice) {
                    mCameraDevice.close();
                    mCameraDevice = null;
                }
            }
        });
    }

    /**
     * 初始化Camera2
     */
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void initCamera2() {
        if (null != mCameraDevice) {
            mCameraDevice.close();
            mCameraDevice = null;
        }
        HandlerThread handlerThread = new HandlerThread("Camera2");
        handlerThread.start();
        childHandler = new Handler(handlerThread.getLooper());
        mainHandler = new Handler(getMainLooper());
        mImageReader = ImageReader.newInstance(1080, 1920, ImageFormat.JPEG, 1);
        mImageReader.setOnImageAvailableListener(new ImageReader.OnImageAvailableListener() { //可以在这里处理拍照得到的临时照片 例如，写入本地
            @Override
            public void onImageAvailable(ImageReader reader) {
                // 拿到拍照照片数据
                Image image = reader.acquireNextImage();
                ByteBuffer buffer = image.getPlanes()[0].getBuffer();
                byte[] bytes = new byte[buffer.remaining()];
                buffer.get(bytes);
//              Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
                send_passport_to_mpd(bytes);

            }
        }, mainHandler);
        //获取摄像头管理
        mCameraManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);
        try {
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                return;
            }
            //打开摄像头
            mCameraManager.openCamera(mCameraID, stateCallback, mainHandler);
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }
    }

    /**
     * 摄像头创建监听
     */
    private CameraDevice.StateCallback stateCallback = new CameraDevice.StateCallback() {
        @Override
        public void onOpened(CameraDevice camera) {//打开摄像头
                mCameraDevice = camera;
                //开启预览
                takePreview();
        }

        @Override
        public void onDisconnected(CameraDevice camera) {//关闭摄像头
            if (null != mCameraDevice) {
                mCameraDevice.close();
                mCameraDevice = null;
            }
        }

        @Override
        public void onError(CameraDevice camera, int error) {//发生错误
            Toast.makeText(PassportActivity.this, "摄像头开启失败", Toast.LENGTH_SHORT).show();
        }
    };

    /**
     * 开始预览
     */
    private void takePreview() {
        try {
            // 创建预览需要的CaptureRequest.Builder
            final CaptureRequest.Builder previewRequestBuilder = mCameraDevice.createCaptureRequest(CameraDevice.TEMPLATE_PREVIEW);
            // 将SurfaceView的surface作为CaptureRequest.Builder的目标
            previewRequestBuilder.addTarget(mSurfaceHolder.getSurface());
            // 创建CameraCaptureSession，该对象负责管理处理预览请求和拍照请求
            mCameraDevice.createCaptureSession(Arrays.asList(mSurfaceHolder.getSurface(), mImageReader.getSurface()), new CameraCaptureSession.StateCallback() // ③
            {
                @Override
                public void onConfigured(CameraCaptureSession cameraCaptureSession) {
                    if (null == mCameraDevice) return;
                    // 当摄像头已经准备好时，开始显示预览
                    mCameraCaptureSession = cameraCaptureSession;
                    try {
                        // 自动对焦
                        previewRequestBuilder.set(CaptureRequest.CONTROL_AF_MODE, CaptureRequest.CONTROL_AF_MODE_CONTINUOUS_PICTURE);
                        // 打开闪光灯
                        previewRequestBuilder.set(CaptureRequest.CONTROL_AE_MODE, CaptureRequest.CONTROL_AE_MODE_ON_AUTO_FLASH);
                        // 显示预览
                        CaptureRequest previewRequest = previewRequestBuilder.build();
                        mCameraCaptureSession.setRepeatingRequest(previewRequest, null, childHandler);
                    } catch (CameraAccessException e) {
                        e.printStackTrace();
                    }
                }

                @Override
                public void onConfigureFailed(CameraCaptureSession cameraCaptureSession) {
                    Toast.makeText(PassportActivity.this, "配置失败", Toast.LENGTH_SHORT).show();
                }
            }, childHandler);
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }
    }


    /**
     * 拍照
     */
    private void takePicture() {
        if (mCameraDevice == null) return;
        // 创建拍照需要的CaptureRequest.Builder
        final CaptureRequest.Builder captureRequestBuilder;
        try {
            captureRequestBuilder = mCameraDevice.createCaptureRequest(CameraDevice.TEMPLATE_STILL_CAPTURE);
            // 将imageReader的surface作为CaptureRequest.Builder的目标
            captureRequestBuilder.addTarget(mImageReader.getSurface());
            // 自动对焦
            captureRequestBuilder.set(CaptureRequest.CONTROL_AF_MODE, CaptureRequest.CONTROL_AF_MODE_CONTINUOUS_PICTURE);
            // 自动曝光
            captureRequestBuilder.set(CaptureRequest.CONTROL_AE_MODE, CaptureRequest.CONTROL_AE_MODE_ON_AUTO_FLASH);
            // 获取手机方向
            int rotation = getWindowManager().getDefaultDisplay().getRotation();
            // 根据设备方向计算设置照片的方向
            captureRequestBuilder.set(CaptureRequest.JPEG_ORIENTATION, ORIENTATIONS.get(rotation));
            //拍照
            CaptureRequest mCaptureRequest = captureRequestBuilder.build();
            mCameraCaptureSession.capture(mCaptureRequest, null, childHandler);
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }
    }

    @OnClick(R.id.bt_shoot)
    public void onViewClicked() {
        takePicture();
    }

    private void send_passport_to_mpd(final byte[] bytes){
        final FaceHelper faceHelper = new FaceHelper(PassportActivity.this,gson);
        faceHelper.detect_face(bytes, new HttpUtils.HttpRunnable() {
            @Override
            public void run(Response<String> response) {
                DetectFaceBean detectFaceBean = gson.fromJson(response.get(), DetectFaceBean.class);
                HttpUtils http_utils = faceHelper.get_http_utils();
                if(detectFaceBean == null || detectFaceBean.getFaces() == null || detectFaceBean.getFaces().size() != 1){
                    http_utils.get_dialog().result(R.string.authentication_failed);
                    initCamera2();
                }else{
                    try {
                        http_utils.get_dialog().result(R.string.success);
                        upload_passport(bytes,detectFaceBean);
                    } catch (Exception e) {
                        e.printStackTrace();
                        http_utils.get_dialog().result(e.toString());
                    }
                }
            }
        });
    }

    private void upload_passport(byte[] bytes, final DetectFaceBean detectFaceBean) throws IOException {
        String reservation = (String) SPUtils.get(PassportActivity.this,SPUtils.CURRENT_RESERVATION,"{}");
        ReservationBean reservationBean = gson.fromJson(reservation, ReservationBean.class);
        String passport_url = CommonUtils.passport_url(reservationBean.getUser_id(),reservationBean.getAccount_id(), reservationBean.getListing().getId(), reservationBean.getId());
        StringRequest request = new StringRequest(passport_url, RequestMethod.POST);
        request.addHeader("auth-token",CommonUtils.MPDTOKEN);
        final File file = new File(PassportActivity.this.getFilesDir().toString(),"passport_img_"+reservationBean.getId()+".jpg");
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
        bos.write(bytes);
        bos.flush();
        bos.close();
        request.add("photo",file);
        final HttpUtils http_utils = new HttpUtils(PassportActivity.this,gson);
        http_utils.send(request, new HttpUtils.HttpRunnable() {
            @Override
            public void run(Response<String> response) {
                MPDBean mPDBean = gson.fromJson(response.get(), MPDBean.class);
                if(mPDBean != null && !TextUtils.isEmpty(mPDBean.getMessage())){
                    http_utils.get_dialog().result(mPDBean.getMessage());
                    initCamera2();
                }else{
                    http_utils.get_dialog().result(R.string.success);
                    String mode = (String) SPUtils.get(PassportActivity.this, SPUtils.MODE, SPUtils.MODE_Phone);
                    SPUtils.put(PassportActivity.this,SPUtils.PASSPORT_FACE_TOKEN,detectFaceBean.getFaces().get(0).getFace_token());
                    if(file.exists()){
                        file.delete();
                    }
                    if(TextUtils.equals(mode,SPUtils.MODE_Phone)){
                        startActivity(new Intent(PassportActivity.this, VideoCallActivity.class));
                    }else{
                        startActivity(new Intent(PassportActivity.this, FaceCompareActivity.class));
                    }
                }
            }
        });
    }

    @Override
    protected void onPause() {
        if (null != mCameraDevice) {
            mCameraDevice.close();
            mCameraDevice = null;
        }
        super.onPause();
    }
}

