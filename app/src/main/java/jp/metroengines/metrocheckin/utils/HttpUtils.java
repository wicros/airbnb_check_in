package jp.metroengines.metrocheckin.utils;

import android.content.Context;

import com.google.gson.Gson;
import com.yanzhenjie.nohttp.NoHttp;
import com.yanzhenjie.nohttp.rest.AsyncRequestExecutor;
import com.yanzhenjie.nohttp.rest.Request;
import com.yanzhenjie.nohttp.rest.Response;
import com.yanzhenjie.nohttp.rest.SimpleResponseListener;

import jp.metroengines.metrocheckin.R;
import jp.metroengines.metrocheckin.widgets.MyProgressDialog;

/**
 * Created by mac on 2018/1/26.
 */

public class HttpUtils {

    private Context context;
    private MyProgressDialog myProgressDialog;
    private Gson gson;

    public interface HttpRunnable {
        void run(Response<String> response);
    }

    public HttpUtils(Context context){
        this.context = context;
        NoHttp.initialize(context);
        myProgressDialog = new MyProgressDialog(context);
        gson = new Gson();
    }

    public void send(Request request, final HttpRunnable runnable){
        CommonUtils.log("url:"+request.url());
        myProgressDialog.show(context.getString(R.string.wait));
        AsyncRequestExecutor.INSTANCE.execute(0, request, new SimpleResponseListener<String>() {
            @Override
            public void onSucceed(int what, Response<String> response) {
               CommonUtils.log("response:"+response);
               if(response.responseCode() == 200 || response.responseCode() == 304){
                   runnable.run(response);
               }else{
                   myProgressDialog.result(context.getString(R.string.net_error)+":"+response.responseCode());
               }
            }
            @Override
            public void onFailed(int what, Response<String> response) {
                myProgressDialog.result_error();
            }
        });
    }

    public void send_quiet(Request request, final HttpRunnable runnable){
        CommonUtils.log("url:"+request.url());
        AsyncRequestExecutor.INSTANCE.execute(0, request, new SimpleResponseListener<String>() {
            @Override
            public void onSucceed(int what, Response<String> response) {
                CommonUtils.log("response:"+response);
                if(response.responseCode() == 200 || response.responseCode() == 304){
                    runnable.run(response);
                }else{
                    CommonUtils.toast(context,context.getString(R.string.net_error)+":"+response.responseCode());
                }
            }
            @Override
            public void onFailed(int what, Response<String> response) {
                CommonUtils.toast(context,context.getString(R.string.net_error)+":"+response.responseCode());
            }
        });
    }

    public MyProgressDialog get_dialog(){
        return  myProgressDialog;
    }

    public Gson get_gson(){
        return gson;
    }

}
