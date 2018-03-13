package jp.metroengines.metrocheckin.activity;

import android.os.Bundle;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import jp.metroengines.metrocheckin.R;

public class InsActivity extends BaseActivity {

    @BindView(R.id.bt_modoru)
    Button btModoru;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ins);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.bt_modoru)
    public void onViewClicked() {
        finish();
    }
}
