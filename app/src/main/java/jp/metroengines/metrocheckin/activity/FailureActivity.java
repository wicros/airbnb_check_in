package jp.metroengines.metrocheckin.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import jp.metroengines.metrocheckin.R;

public class FailureActivity extends BaseActivity {


    @BindView(R.id.bt_phone)
    Button btPhone;
    @BindView(R.id.bt_face)
    Button btFace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_failure);
        ButterKnife.bind(this);
    }


    @OnClick({R.id.bt_phone, R.id.bt_face})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_phone:
                startActivity(new Intent(FailureActivity.this,VideoCallActivity.class));
                break;
            case R.id.bt_face:
                startActivity(new Intent(FailureActivity.this,FaceCompareActivity.class));
                break;
        }
        FailureActivity.this.finish();
    }
}
