package jp.metroengines.metrocheckin.activity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.Guideline;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import jp.metroengines.metrocheckin.R;
import jp.metroengines.metrocheckin.utils.CommonUtils;
import jp.metroengines.metrocheckin.utils.SPUtils;

public class MainActivity extends BaseActivity {

    @BindView(R.id.bt_ja)
    Button btJa;
    @BindView(R.id.bt_en)
    Button btEn;
    @BindView(R.id.bt_zh)
    Button btZh;
    @BindView(R.id.bt_setting)
    ImageButton btSetting;
    @BindView(R.id.guideline)
    Guideline guideline;
    @BindView(R.id.guideline2)
    Guideline guideline2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }


    @OnClick({R.id.bt_ja, R.id.bt_en, R.id.bt_zh, R.id.bt_setting})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_ja:
                change_local("ja");
                break;
            case R.id.bt_zh:
                change_local("zh");
                break;
            case R.id.bt_en:
                change_local("en");
                break;
            case R.id.bt_setting:
                go_to_setting();
                break;
        }
    }

    private void change_local(String local) {
        SPUtils.put(this, SPUtils.LOCAL, local);
        startActivity(new Intent(this, ReservationActivity.class));
        //startActivity(new Intent(this, VideoCallActivity.class));
        //startActivity(new Intent(this, SuccessActivity.class));
    }

    private void go_to_setting(){
          View view = View.inflate(MainActivity.this, R.layout.setting_dialog, null);
          final Dialog dialog = new Dialog(MainActivity.this);
          dialog.setContentView(view);
          final EditText edittext = view.findViewById(R.id.et_set_pass);
          view.findViewById(R.id.bt_confirm).setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  Editable text = edittext.getText();
                  if(!TextUtils.isEmpty(text) && TextUtils.equals("metro1234",text)){
                      startActivity(new Intent(MainActivity.this, SettingActivity.class));
                  }else {
                      CommonUtils.toast(MainActivity.this, "wrong password");
                  }
                  dialog.dismiss();
              }
          });
        dialog.show();
    }

}
