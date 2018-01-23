package jp.metroengines.metrocheckin.activity;

import android.app.Activity;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.Locale;

import jp.metroengines.metrocheckin.R;
import jp.metroengines.metrocheckin.utils.SPUtils;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initLocaleLanguage();
//        setContentView(R.layout.activity_main);
    }

    private void initLocaleLanguage() {
        Resources resources = getResources();
        Configuration configuration = resources.getConfiguration();
        String local = (String) SPUtils.get(this, "local", "en");
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

}
