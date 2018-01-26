package jp.metroengines.metrocheckin.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import jp.metroengines.metrocheckin.R;

public class SuccessActivity extends AppCompatActivity {

    @BindView(R.id.tv_keycode)
    TextView tvKeycode;
    @BindView(R.id.bt_confirm)
    Button btConfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.bt_confirm)
    public void onViewClicked() {
        startActivity(new Intent(SuccessActivity.this,LastActivity.class));
    }
}
