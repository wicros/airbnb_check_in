package jp.metroengines.metrocheckin.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.Guideline;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.yanzhenjie.nohttp.NoHttp;
import com.yanzhenjie.nohttp.rest.Response;
import com.yanzhenjie.nohttp.rest.StringRequest;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import jp.metroengines.metrocheckin.R;
import jp.metroengines.metrocheckin.bean.KeyCodeBean;
import jp.metroengines.metrocheckin.bean.ReservationBean;
import jp.metroengines.metrocheckin.utils.CommonUtils;
import jp.metroengines.metrocheckin.utils.HttpUtils;
import jp.metroengines.metrocheckin.utils.SPUtils;

public class SuccessActivity extends BaseActivity {

    @BindView(R.id.tv_keycode)
    TextView tvKeycode;
    @BindView(R.id.bt_confirm)
    Button btConfirm;
    @BindView(R.id.tv_box)
    TextView tvBox;
    @BindView(R.id.tv_slot)
    TextView tvSlot;
    @BindView(R.id.bt_ins)
    Button btIns;
    @BindView(R.id.guideline12)
    Guideline guideline12;
    @BindView(R.id.textView2)
    TextView textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);
        NoHttp.initialize(this);
        ButterKnife.bind(this);
        getKeyCode();
    }

    private void getKeyCode() {
        String reservation = (String) SPUtils.get(this, SPUtils.CURRENT_RESERVATION, "{}");
        ReservationBean reservationBean = gson.fromJson(reservation, ReservationBean.class);
        String key;
        if (reservationBean.getListing().getKeystation_key_id() != null) {
            key = reservationBean.getListing().getKeystation_key_id().toString();
        } else {
            key = "233";
        }
        StringRequest request = new StringRequest(CommonUtils.GET_KEY_URL + key);
        request.addHeader("Authorization", CommonUtils.KEY_TOKEN);
        CommonUtils.log(request.getHeaders().toString());
        HttpUtils httpUtils = new HttpUtils(this, gson);
        httpUtils.send_quiet(request, new HttpUtils.HttpRunnable() {
            @Override
            public void run(Response<String> response) {
                KeyCodeBean keyCodeBean = gson.fromJson(response.get(), KeyCodeBean.class);
                if (keyCodeBean != null && keyCodeBean.getRoom_key().getPassword() != null) {
                    if (keyCodeBean.getRoom_key().getState() == 1) {
                        tvKeycode.setText(keyCodeBean.getRoom_key().getPassword());
                    } else {
                        tvKeycode.setText(R.string.key_out);
                    }
                    tvBox.setText(keyCodeBean.getKey_station().getName() + " | " + keyCodeBean.getKey_box().getName());
                    tvSlot.setText(SuccessActivity.this.getString(R.string.slot_number) + keyCodeBean.getRoom_key().getSlot_number());
                } else {
                    CommonUtils.log("error:" + response.responseCode());
                }
            }

            @Override
            public void onerror() {

            }
        });
    }


    @OnClick({R.id.bt_confirm, R.id.bt_ins})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_confirm:
                startActivity(new Intent(SuccessActivity.this, LastActivity.class));
                break;
            case R.id.bt_ins:
                startActivity(new Intent(SuccessActivity.this, InsActivity.class));
                break;
        }
    }
}
