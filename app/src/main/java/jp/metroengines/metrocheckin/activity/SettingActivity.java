package jp.metroengines.metrocheckin.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.RadioButton;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import jp.metroengines.metrocheckin.R;
import jp.metroengines.metrocheckin.utils.SPUtils;

public class SettingActivity extends AppCompatActivity {

    @BindView(R.id.bt_save)
    Button btSave;
    @BindView(R.id.rd_phone)
    RadioButton rdPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.bt_save)
    public void onViewClicked() {
        String mode = rdPhone.isChecked() ? "phone" : "face";
        SPUtils.put(SettingActivity.this, "mode", mode);
        finish();
    }
}
