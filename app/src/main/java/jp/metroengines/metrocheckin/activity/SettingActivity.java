package jp.metroengines.metrocheckin.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
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
    @BindView(R.id.rd_face)
    RadioButton rdFace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        ButterKnife.bind(this);
        if(TextUtils.equals((CharSequence) SPUtils.get(this,SPUtils.MODE,SPUtils.MODE_Phone),SPUtils.MODE_Face)){
            rdFace.setChecked(true);
        }
    }

    @OnClick(R.id.bt_save)
    public void onViewClicked() {
        String mode = rdPhone.isChecked() ? SPUtils.MODE_Phone : SPUtils.MODE_Face;
        SPUtils.put(SettingActivity.this, SPUtils.MODE, mode);
        finish();
    }
}
