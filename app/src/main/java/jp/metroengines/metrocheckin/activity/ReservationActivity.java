package jp.metroengines.metrocheckin.activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.yanzhenjie.nohttp.NoHttp;
import com.yanzhenjie.nohttp.rest.AsyncRequestExecutor;
import com.yanzhenjie.nohttp.rest.Response;
import com.yanzhenjie.nohttp.rest.SimpleResponseListener;
import com.yanzhenjie.nohttp.rest.StringRequest;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import jp.metroengines.metrocheckin.R;

public class ReservationActivity extends BaseActivity {

    @BindView(R.id.et_reservation)
    EditText etReservation;
    @BindView(R.id.bt_confirm)
    Button btConfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation);
        ButterKnife.bind(this);
        setBackButton(this);
        NoHttp.initialize(this);
    }

    @OnClick(R.id.bt_confirm)
    public void onViewClicked() {
        StringRequest request = new StringRequest("http://api.nohttp.net");
        AsyncRequestExecutor.INSTANCE.execute(0, request, new SimpleResponseListener<String>() {
            @Override
            public void onSucceed(int what, Response<String> response) {
                // 请求成功。
            }

            @Override
            public void onFailed(int what, Response<String> response) {
                // 请求失败。
            }
        });
    }
}
