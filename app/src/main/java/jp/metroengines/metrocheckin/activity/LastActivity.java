package jp.metroengines.metrocheckin.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import jp.metroengines.metrocheckin.R;

public class LastActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last);
        new Handler().postDelayed(new Runnable(){
            public void run() {
                startActivity(new Intent(LastActivity.this, MainActivity.class));
            }
        }, 1000 * 60);
    }
}
