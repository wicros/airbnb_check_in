package jp.metroengines.metrocheckin.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import jp.metroengines.metrocheckin.R;
import jp.metroengines.metrocheckin.bean.ReservationBean;
import jp.metroengines.metrocheckin.utils.SPUtils;

public class FailureActivity extends BaseActivity {


    @BindView(R.id.bt_phone)
    Button btPhone;
    @BindView(R.id.tv_title)
    TextView tvTitle;

    private int mode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_failure);
        ButterKnife.bind(this);
        mode = getIntent().getIntExtra(SPUtils.MODE, 0);
        switch (mode) {
            case 0:
                btPhone.setText(R.string.phone_title);
                tvTitle.setText(R.string.failure_title_0);
                break;
            case 1:
                btPhone.setText(R.string.face_title);
                tvTitle.setText(R.string.failure_title_1);
                break;
            case 2:
                btPhone.setText(R.string.phone_title);
                tvTitle.setText(R.string.failure_title_2);
                break;
            case 3:
                btPhone.setText(R.string.confirm);
                String reservation = (String) SPUtils.get(this, SPUtils.CURRENT_RESERVATION, "{}");
                ReservationBean reservationBean = gson.fromJson(reservation, ReservationBean.class);
                Object owner_phone = reservationBean.getOwner_phone();
                if(owner_phone == null){
                    owner_phone = "111111111";
                }
                tvTitle.setText(this.getString(R.string.failure_title_3)+owner_phone);
                break;
        }
    }


    @OnClick({R.id.bt_phone})
    public void onViewClicked(View view) {
        switch (mode) {
            case 0:
                Intent intent0 = new Intent(FailureActivity.this, VideoCallActivity.class);
                intent0.putExtra(SPUtils.MODE,1);
                startActivity(intent0);
                break;
            case 1:
                Intent intent1 = new Intent(FailureActivity.this, FaceCompareActivity.class);
                intent1.putExtra(SPUtils.MODE,2);
                startActivity(intent1);
                break;
            case 2:
                Intent intent2 = new Intent(FailureActivity.this, VideoCallActivity.class);
                intent2.putExtra(SPUtils.MODE,3);
                startActivity(intent2);
                break;
            case 3:
                back_to_main();
                break;
        }
        FailureActivity.this.finish();
    }
}
