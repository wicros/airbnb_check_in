package jp.metroengines.metrocheckin;

import android.support.multidex.MultiDexApplication;

import com.amazonaws.mobile.auth.core.IdentityManager;
import com.amazonaws.mobile.config.AWSConfiguration;

/**
 * Created by mac on 2018/2/6.
 */

public class MyApplication extends MultiDexApplication {

    private static final String LOG_TAG = MyApplication.class.getSimpleName();
    @Override
    public void onCreate() {
        super.onCreate();
        initializeApplication();

    }

    private void initializeApplication() {

        AWSConfiguration awsConfiguration = new AWSConfiguration(getApplicationContext());

        // If IdentityManager is not created, create it
        if (IdentityManager.getDefaultIdentityManager() == null) {
            IdentityManager identityManager =
                    new IdentityManager(getApplicationContext(), awsConfiguration);
            IdentityManager.setDefaultIdentityManager(identityManager);
        }
    }

}
