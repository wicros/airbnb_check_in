package jp.metroengines.metrocheckin.helper;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.amazonaws.mobile.auth.core.IdentityManager;
import com.amazonaws.services.rekognition.AmazonRekognitionClient;
import com.amazonaws.services.rekognition.model.CompareFacesRequest;
import com.amazonaws.services.rekognition.model.CompareFacesResult;
import com.amazonaws.services.rekognition.model.DetectFacesRequest;
import com.amazonaws.services.rekognition.model.DetectFacesResult;
import com.amazonaws.services.rekognition.model.Image;
import com.google.gson.Gson;

import java.io.File;
import java.nio.ByteBuffer;

import jp.metroengines.metrocheckin.R;
import jp.metroengines.metrocheckin.utils.CommonUtils;
import jp.metroengines.metrocheckin.utils.SPUtils;
import jp.metroengines.metrocheckin.widgets.MyProgressDialog;

/**
 * Created by mac on 2018/1/25.
 */

public class AWSFaceHelper {

    private Context context;
    private Handler handler;
    private MyProgressDialog myProgressDialog;
    private final int FAILURE = 0;
    private final int SUCCESS = 1;
    private final int ERROR = 2;
    private FaceRunnable runnable;

    public AWSFaceHelper(Context context, Gson gson){
        this.context = context;
        handler  = new MyHandler();
        myProgressDialog = new MyProgressDialog(context);
    }

    public interface FaceRunnable{
        void success();
        void failuer();
        void error();
    }

    // 定义一个内部类继承自Handler，并且覆盖handleMessage方法用于处理子线程传过来的消息
    class MyHandler extends Handler{
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case SUCCESS:
                    myProgressDialog.result(context.getString(R.string.success));
                    runnable.success();
                    break;
                case FAILURE:
                    myProgressDialog.result(context.getString(R.string.authentication_failed));
                    runnable.failuer();
                    break;
                case ERROR:
                    myProgressDialog.result(context.getString(R.string.net_error)+":"+msg.getData().getString("error"));
                    runnable.error();
                    break;
                default:
                    break;
            }
        }
    }

    public MyProgressDialog get_dialog(){
        return myProgressDialog;
    }

    public void detect_face(FaceRunnable runnable, final ByteBuffer buffer){
        myProgressDialog.show(context.getString(R.string.wait));
        this.runnable = runnable;
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    AmazonRekognitionClient amazonRekognitionClient = new AmazonRekognitionClient(IdentityManager.getDefaultIdentityManager().getCredentialsProvider());
                    DetectFacesResult detectFacesResult = amazonRekognitionClient.detectFaces(new DetectFacesRequest().withImage(new Image().withBytes(buffer)));
                    CommonUtils.log("response:"+detectFacesResult);
                    if(detectFacesResult.getFaceDetails().size() == 1 && detectFacesResult.getFaceDetails().get(0).getConfidence() > 50){
                        handler.sendEmptyMessage(SUCCESS);
                    }else{
                        handler.sendEmptyMessage(FAILURE);
                    }
                }catch (Exception e){
                    Message msg = new Message();
                    msg.what = ERROR;
                    Bundle bundle = new Bundle();
                    CommonUtils.log("response:"+e.getMessage());
                    bundle.putString("error",e.getMessage());  //往Bundle中存放数据
                    msg.setData(bundle);//mes利用Bundle传递数据
                    handler.sendMessage(msg);
                }
            }
        }).start();
    }

    public void compare_face(FaceRunnable runnable, final ByteBuffer buffer_1){
        myProgressDialog.show(context.getString(R.string.wait));
        this.runnable = runnable;
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String file_name = (String) SPUtils.get(context, SPUtils.PASSPORT_FACE_TOKEN, "");
                    File file = new File(context.getFilesDir().toString(), file_name);
                    byte[] bytes = CommonUtils.fileToBytes(file);
                    ByteBuffer buffer_2 = ByteBuffer.wrap(bytes);
                    AmazonRekognitionClient amazonRekognitionClient = new AmazonRekognitionClient(IdentityManager.getDefaultIdentityManager().getCredentialsProvider());
                    CompareFacesRequest compareFacesRequest = new CompareFacesRequest().withSourceImage(new Image().withBytes(buffer_1)).withTargetImage(new Image().withBytes(buffer_2)).withSimilarityThreshold(70F);
                    CompareFacesResult compareFacesResult = amazonRekognitionClient.compareFaces(compareFacesRequest);
                    CommonUtils.log("response:"+compareFacesResult);
                    if(compareFacesResult.getUnmatchedFaces().size() > 0){
                        handler.sendEmptyMessage(FAILURE);
                    }else{
                        handler.sendEmptyMessage(SUCCESS);
                    }
                }catch (Exception e){
                    Message msg = new Message();
                    msg.what = ERROR;
                    Bundle bundle = new Bundle();
                    CommonUtils.log("response:"+e.getMessage());
                    bundle.putString("error",e.getMessage());  //往Bundle中存放数据
                    msg.setData(bundle);//mes利用Bundle传递数据
                    handler.sendMessage(msg);
                }
            }
        }).start();
    }

}
