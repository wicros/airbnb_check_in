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
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import jp.metroengines.metrocheckin.R;
import jp.metroengines.metrocheckin.bean.GuestInfoBean;
import jp.metroengines.metrocheckin.bean.ReservationBean;
import jp.metroengines.metrocheckin.helper.AWSFaceHelper;
import jp.metroengines.metrocheckin.helper.AWSS3Helper;
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
    @BindView(R.id.bt_change)
    Button btChange;
    @BindView(R.id.tv_num)
    TextView tvNum;

    private CameraManager mCameraManager;//摄像头管理器
    private Handler childHandler, mainHandler;
    private String mCameraID = "" + CameraCharacteristics.LENS_FACING_BACK;
    ;//摄像头Id 0 为后  1 为前
    private ImageReader mImageReader;
    private CameraCaptureSession mCameraCaptureSession;
    private CameraDevice mCameraDevice;

    private List<GuestInfoBean.InfoListBean> info_list;
    private int current_num = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passport);
        ButterKnife.bind(this);
        info_list = gson.fromJson((String) SPUtils.get(this, SPUtils.GUEST_INFO, "{}"), GuestInfoBean.class).getInfo_list();
        set_num_text();
        initSurfaceView();
    }

    private void set_num_text() {
        tvNum.setText(info_list.get(current_num).getName()+this.getString(R.string.de_passport));
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
                final Image image = reader.acquireNextImage();
                ByteBuffer buffer = image.getPlanes()[0].getBuffer();
                new AWSFaceHelper(PassportActivity.this, gson).detect_face(new AWSFaceHelper.FaceRunnable() {
                    @Override
                    public void success() {
                        ByteBuffer buffer_2 = image.getPlanes()[0].getBuffer();
                        final byte[] bytes = new byte[buffer_2.remaining()];
                        buffer_2.get(bytes);
                        final AWSS3Helper awss3Helper = new AWSS3Helper(PassportActivity.this, gson);
                        awss3Helper.get_dialog().show(PassportActivity.this.getString(R.string.wait));
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                upload_passport(bytes, awss3Helper);
                            }
                        }).start();
                    }

                    @Override
                    public void failuer() {
                        initCamera2();
                    }

                    @Override
                    public void error() {
                        initCamera2();
                    }
                }, buffer);

//              Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);

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

    private void upload_passport(final byte[] bytes, final AWSS3Helper awss3Helper) {
        String reservation = (String) SPUtils.get(this, SPUtils.CURRENT_RESERVATION, "{}");
        ReservationBean reservationBean = gson.fromJson(reservation, ReservationBean.class);
        final String format = ".jpg";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        final String file_name = "passport_img_" + reservationBean.getId() + "_" + current_num + "_" + simpleDateFormat.format(new Date(System.currentTimeMillis()));
        final File file = new File(this.getFilesDir().toString(), file_name + format);
        try {
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
            bos.write(bytes);
            bos.flush();
            bos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        awss3Helper.upload_file(file_name, format, new AWSS3Helper.S3Runnable() {
            @Override
            public void success() {
                awss3Helper.get_dialog().result(R.string.success);

                if (current_num == 0) {
                    SPUtils.put(PassportActivity.this, SPUtils.PASSPORT_FACE_TOKEN, file_name + format);
                } else {
                    if (file.exists()) {
                        file.delete();
                    }
                }

                if (current_num < info_list.size()) {
                    initCamera2();
                    current_num++;
                    set_num_text();
                } else {
                    String mode = (String) SPUtils.get(PassportActivity.this, SPUtils.MODE, SPUtils.MODE_Phone);
                    if (TextUtils.equals(mode, SPUtils.MODE_Phone)) {
                        Intent intent = new Intent(PassportActivity.this, BeforeVideoActivity.class);
                        intent.putExtra(SPUtils.MODE,1);
                        startActivity(intent);
                    } else {
                        Intent intent = new Intent(PassportActivity.this, FaceCompareActivity.class);
                        intent.putExtra(SPUtils.MODE,0);
                        startActivity(intent);
                    }
                    awss3Helper.get_dialog().dismiss_dialog();
                    finish();
                }
            }

            @Override
            public void error() {
                initCamera2();
            }
        });

    }


//    private void upload_passport(final byte[] bytes) {
//        String reservation = (String) SPUtils.get(PassportActivity.this, SPUtils.CURRENT_RESERVATION, "{}");
//        ReservationBean reservationBean = gson.fromJson(reservation, ReservationBean.class);
//        String passport_url = CommonUtils.passport_url(reservationBean.getUser_id(), reservationBean.getAccount_id(), reservationBean.getListing().getId(), reservationBean.getId());
//        StringRequest request = new StringRequest(passport_url, RequestMethod.POST);
//        request.addHeader("auth-token", CommonUtils.MPDTOKEN);
//        final String file_name = "passport_img_" + reservationBean.getId() + "_"+ current_num + ".jpg";
//        final File file = new File(PassportActivity.this.getFilesDir().toString(), file_name);
//        try {
//            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
//            bos.write(bytes);
//            bos.flush();
//            bos.close();
//            request.add("photo", file);
//
//            final HttpUtils http_utils = new HttpUtils(PassportActivity.this, gson);
//            http_utils.send(request, new HttpUtils.HttpRunnable() {
//                @Override
//                public void run(Response<String> response) {
//                    MPDBean mPDBean = gson.fromJson(response.get(), MPDBean.class);
//                    if (mPDBean != null && !TextUtils.isEmpty(mPDBean.getMessage())) {
//                        http_utils.get_dialog().result(mPDBean.getMessage());
//                        initCamera2();
//                    } else {
//                        http_utils.get_dialog().result(R.string.success);
//
//                        if(current_num == 1){
//                            SPUtils.put(PassportActivity.this, SPUtils.PASSPORT_FACE_TOKEN, file_name);
//                        }else {
//                            if(file.exists()){
//                                file.delete();
//                            }
//                        }
//
//                        if(current_num < max_num){
//                            initCamera2();
//                            current_num++;
//                            set_num_text();
//                        }else {
//                            String mode = (String) SPUtils.get(PassportActivity.this, SPUtils.MODE, SPUtils.MODE_Phone);
//                            if (TextUtils.equals(mode, SPUtils.MODE_Phone)) {
//                                startActivity(new Intent(PassportActivity.this, BeforeVideoActivity.class));
//                            } else {
//                                startActivity(new Intent(PassportActivity.this, FaceCompareActivity.class));
//                            }
//                            http_utils.get_dialog().dismiss_dialog();
//                            finish();
//                        }
//
//                    }
//                }
//            });
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    @Override
    protected void onPause() {
        if (null != mCameraDevice) {
            mCameraDevice.close();
            mCameraDevice = null;
        }
        super.onPause();
    }

    @OnClick({R.id.bt_shoot, R.id.bt_change})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_shoot:
                takePicture();
                break;
            case R.id.bt_change:
                mCameraID = TextUtils.equals(mCameraID, "1") ? "0" : "1";
                initCamera2();
                break;
        }
    }

    @OnClick(R.id.tv_num)
    public void onViewClicked() {
    }
}

