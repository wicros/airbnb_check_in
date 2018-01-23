package jp.metroengines.metrocheckin.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.Guideline;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import jp.metroengines.metrocheckin.R;

public class ChosePlantActivity extends BaseActivity {

    @BindView(R.id.guideline3)
    Guideline guideline3;
    @BindView(R.id.bt_key_station)
    Button btKeyStation;
    @BindView(R.id.bt_other)
    Button btOther;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chose_plant);
        ButterKnife.bind(this);
        setBackButton(this);
    }

    @OnClick({R.id.bt_key_station, R.id.bt_other})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_key_station:
                break;
            case R.id.bt_other:
                break;
        }
        startActivity(new Intent(this, ReservationActivity.class));
    }
}
