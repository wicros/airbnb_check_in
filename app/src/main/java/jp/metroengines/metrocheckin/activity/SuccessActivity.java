package jp.metroengines.metrocheckin.activity;

import android.content.Intent;
import android.os.Bundle;
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
import jp.metroengines.metrocheckin.utils.CommonUtils;
import jp.metroengines.metrocheckin.utils.HttpUtils;

public class SuccessActivity extends BaseActivity {

    @BindView(R.id.tv_keycode)
    TextView tvKeycode;
    @BindView(R.id.bt_confirm)
    Button btConfirm;
    @BindView(R.id.tv_box)
    TextView tvBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);
        NoHttp.initialize(this);
        ButterKnife.bind(this);
        getKeyCode();
    }

    private void getKeyCode() {
        StringRequest request = new StringRequest(CommonUtils.GET_KEY_URL + "231");
        request.addHeader("Authorization", CommonUtils.KEY_TOKEN);
        CommonUtils.log(request.getHeaders().toString());
        HttpUtils httpUtils = new HttpUtils(this, gson);
        httpUtils.send_quiet(request, new HttpUtils.HttpRunnable() {
            @Override
            public void run(Response<String> response) {
                KeyCodeBean keyCodeBean = gson.fromJson(response.get(), KeyCodeBean.class);
                if (keyCodeBean != null && keyCodeBean.getRoom_key().getPassword() != null) {
                    tvKeycode.setText(keyCodeBean.getRoom_key().getPassword());
                    tvBox.setText(keyCodeBean.getKey_station().getName()+" | "+keyCodeBean.getKey_box().getName());
                } else {
                    CommonUtils.log("error:" + response.responseCode());
                }
            }
        });
    }

    @OnClick(R.id.bt_confirm)
    public void onViewClicked() {
        startActivity(new Intent(SuccessActivity.this, LastActivity.class));
    }
}
