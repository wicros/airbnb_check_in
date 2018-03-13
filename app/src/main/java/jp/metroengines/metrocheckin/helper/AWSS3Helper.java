package jp.metroengines.metrocheckin.helper;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.mobile.auth.core.IdentityManager;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.google.gson.Gson;

import java.io.File;

import jp.metroengines.metrocheckin.R;
import jp.metroengines.metrocheckin.utils.CommonUtils;
import jp.metroengines.metrocheckin.widgets.MyProgressDialog;

/**
 * Created by mac on 2018/2/9.
 */

public class AWSS3Helper {

    private Context context;
    private Handler handler;
    private MyProgressDialog myProgressDialog;
    private final int FAILURE = 0;
    private final int SUCCESS = 1;
    private final int ERROR = 2;
    private AWSS3Helper.S3Runnable runnable;
    private final String BUCKET_NAME = "metro-keystation-user-info";

    public AWSS3Helper(Context context, Gson gson) {
        this.context = context;
        handler = new AWSS3Helper.MyHandler();
        myProgressDialog = new MyProgressDialog(context);
    }

    public interface S3Runnable {
        void success();

        void error();
    }

    // 定义一个内部类继承自Handler，并且覆盖handleMessage方法用于处理子线程传过来的消息
    class MyHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case SUCCESS:
                    myProgressDialog.result(context.getString(R.string.success));
                    runnable.success();
                    break;
                case ERROR:
                    myProgressDialog.result(context.getString(R.string.net_error) + ":" + msg.getData().getString("error"));
                    runnable.error();
                    break;
                default:
                    break;
            }
        }
    }

    public MyProgressDialog get_dialog() {
        return myProgressDialog;
    }

    public String get_file(String file_name){
        String result;
        try {
            AmazonS3 s3client = new AmazonS3Client(IdentityManager.getDefaultIdentityManager().getCredentialsProvider());
            result = s3client.getObjectAsString(BUCKET_NAME,file_name);
        }catch (Exception e){
            result=null;
        }
        return result;
    }

    public void upload_file(String file_name, String format, S3Runnable runnable) {
        this.runnable = runnable;
        AmazonS3 s3client = new AmazonS3Client(IdentityManager.getDefaultIdentityManager().getCredentialsProvider());
        try {
            File file = new File(context.getFilesDir().toString(), file_name + format);
            s3client.putObject(new PutObjectRequest(BUCKET_NAME, file_name, file));
            handler.sendEmptyMessage(SUCCESS);
        } catch (AmazonServiceException ase) {
            Message msg = new Message();
            msg.what = ERROR;
            Bundle bundle = new Bundle();
            bundle.putString("error", ase.getMessage());
            msg.setData(bundle);
            handler.sendMessage(msg);

            CommonUtils.log("Error Message:    " + ase.getMessage());
            CommonUtils.log("HTTP Status Code: " + ase.getStatusCode());
            CommonUtils.log("AWS Error Code:   " + ase.getErrorCode());
            CommonUtils.log("Error Type:       " + ase.getErrorType());
            CommonUtils.log("Request ID:       " + ase.getRequestId());
        } catch (AmazonClientException ace) {
            Message msg = new Message();
            msg.what = ERROR;
            Bundle bundle = new Bundle();
            bundle.putString("error", ace.getMessage());
            msg.setData(bundle);
            handler.sendMessage(msg);

            CommonUtils.log("Caught an AmazonClientException, which " +
                    "means the client encountered " +
                    "an internal error while trying to " +
                    "communicate with S3, " +
                    "such as not being able to access the network.");
            CommonUtils.log("Error Message: " + ace.getMessage());
        }
    }
}
