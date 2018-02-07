package jp.metroengines.metrocheckin.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import jp.metroengines.metrocheckin.R;

public class BeforeVideoActivity extends BaseActivity {

    @BindView(R.id.bt_call)
    Button btCall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_before_video);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.bt_call)
    public void onViewClicked() {
        startActivity(new Intent(BeforeVideoActivity.this,VideoCallActivity.class));
        finish();
    }
}
