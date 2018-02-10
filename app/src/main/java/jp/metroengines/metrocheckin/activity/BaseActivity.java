package jp.metroengines.metrocheckin.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;

import com.amazonaws.mobile.auth.core.IdentityManager;
import com.google.gson.Gson;

import java.io.File;
import java.util.Locale;

import jp.metroengines.metrocheckin.R;
import jp.metroengines.metrocheckin.utils.CountTimer;
import jp.metroengines.metrocheckin.utils.SPUtils;

public abstract class BaseActivity extends AppCompatActivity {

    protected Gson gson = new Gson();

    private CountTimer countTimer;

    private IdentityManager identityManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initLocaleLanguage();
        //setContentView(R.layout.activity_main);
        set_time_counter(3 * 60 * 1000);
    }

    private void initLocaleLanguage() {
        Resources resources = getResources();
        Configuration configuration = resources.getConfiguration();
        String local = (String) SPUtils.get(this, SPUtils.LOCAL, "en");
        if("ja".equals(local)){
            configuration.locale = Locale.JAPANESE;
        }else if("zh".equals(local)){
            configuration.locale = Locale.CHINESE;
        }else{
            configuration.locale = Locale.ENGLISH;
        }
        resources.updateConfiguration(configuration, resources.getDisplayMetrics());//更新配置
    }

    protected void setBackButton(final Activity activity){
        activity.findViewById(R.id.bt_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.finish();
            }
        });
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        switch (ev.getAction()){
            case MotionEvent.ACTION_UP:
                countTimer.start();
                break;
            default:
                countTimer.cancel();
                break;
        }
        return super.dispatchTouchEvent(ev);
    }

    public void set_time_counter(long millisInFuture){
        if(countTimer != null){
            countTimer.cancel();
            countTimer = null;
        }
        countTimer = new CountTimer(millisInFuture,1000,BaseActivity.this);
    }

    private void timeStart(){
        new Handler(getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                countTimer.start();
            }
        });
    }

    @Override
    protected void onResume() {
        timeStart();
        super.onResume();
    }

    @Override
    protected void onPause() {
        countTimer.cancel();
        super.onPause();
    }

    public void back_to_main(){
        String file_name = (String) SPUtils.get(this, SPUtils.PASSPORT_FACE_TOKEN, "");
        File file = new File(this.getFilesDir().toString(), file_name);
        if(file.exists()){
            file.delete();
        }
        final Intent intent = new Intent(this, MainActivity.class)
                .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        this.startActivity(intent);
    }
}
