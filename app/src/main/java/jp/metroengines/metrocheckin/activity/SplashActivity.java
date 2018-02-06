package jp.metroengines.metrocheckin.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.amazonaws.mobile.auth.core.IdentityManager;
import com.amazonaws.mobile.auth.core.StartupAuthResult;
import com.amazonaws.mobile.auth.core.StartupAuthResultHandler;
import com.amazonaws.mobile.config.AWSConfiguration;

import jp.metroengines.metrocheckin.R;

public class SplashActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Context appContext = getApplicationContext();
        AWSConfiguration awsConfig = new AWSConfiguration(appContext);
        IdentityManager identityManager = new IdentityManager(appContext, awsConfig);
        IdentityManager.setDefaultIdentityManager(identityManager);
        identityManager.doStartupAuth(this, new StartupAuthResultHandler() {
            @Override
            public void onComplete(StartupAuthResult startupAuthResult) {

            }
        });

        // Go to the main activity
        final Intent intent = new Intent(this, MainActivity.class)
                .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        this.startActivity(intent);
        this.finish();

    }
}
