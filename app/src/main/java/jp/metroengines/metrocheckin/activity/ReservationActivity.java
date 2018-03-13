package jp.metroengines.metrocheckin.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;

import com.yanzhenjie.nohttp.NoHttp;
import com.yanzhenjie.nohttp.rest.Response;
import com.yanzhenjie.nohttp.rest.StringRequest;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import jp.metroengines.metrocheckin.R;
import jp.metroengines.metrocheckin.bean.MPDBean;
import jp.metroengines.metrocheckin.bean.ReservationBean;
import jp.metroengines.metrocheckin.helper.AWSS3Helper;
import jp.metroengines.metrocheckin.utils.CommonUtils;
import jp.metroengines.metrocheckin.utils.HttpUtils;
import jp.metroengines.metrocheckin.utils.SPUtils;
import jp.metroengines.metrocheckin.widgets.MyProgressDialog;

public class ReservationActivity extends BaseActivity {

    @BindView(R.id.et_reservation)
    EditText etReservation;
    @BindView(R.id.bt_confirm)
    Button btConfirm;
    MyProgressDialog myProgressDialog;

    private HttpUtils httpUtils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation);
        ButterKnife.bind(this);
        setBackButton(this);
        NoHttp.initialize(this);
        httpUtils = new HttpUtils(this,gson);
        myProgressDialog = httpUtils.get_dialog();
    }

    @OnClick(R.id.bt_confirm)
    public void onViewClicked() {
        String reservation_num = etReservation.getText().toString();
        //String reservation_num = "HM5FJP9PCF";//HMMNXAKXNT
        if(TextUtils.isEmpty(reservation_num)){
            CommonUtils.toast(this,this.getString(R.string.reservation_input));
            return;
        }

        StringRequest request = new StringRequest(CommonUtils.RESERVATION_URL + reservation_num);
        request.addHeader("auth-token",CommonUtils.MPDTOKEN);

        httpUtils.send(request, new HttpUtils.HttpRunnable() {
            @Override
            public void run(Response<String> response) {
                MPDBean mPDBean = gson.fromJson(response.get(), MPDBean.class);
                if(mPDBean != null && !TextUtils.isEmpty(mPDBean.getMessage())){
                    myProgressDialog.result(mPDBean.getMessage());
                }else{
                    SPUtils.put(ReservationActivity.this, SPUtils.CURRENT_RESERVATION, response.get());
                    get_s3_info();
                }
            }

            @Override
            public void onerror() {

            }
        });
    }

    private void get_s3_info() {
        String reservation = (String) SPUtils.get(this, SPUtils.CURRENT_RESERVATION, "{}");
        ReservationBean reservationBean = gson.fromJson(reservation, ReservationBean.class);
        final String file_name = "guest_info_" + reservationBean.getId();
        final AWSS3Helper awss3Helper = new AWSS3Helper(ReservationActivity.this, gson);
        new Thread(new Runnable() {
            @Override
            public void run() {
                final String result = awss3Helper.get_file(file_name);
                (ReservationActivity.this).runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if(TextUtils.isEmpty(result)){
                            startActivity(new Intent(ReservationActivity.this, GuestNumActivity.class));
                        }else{
                            SPUtils.put(ReservationActivity.this, SPUtils.GUEST_INFO, result);
                            startActivity(new Intent(ReservationActivity.this, PassportActivity.class));
                        }
                        myProgressDialog.dismiss_dialog();
                        finish();
                    }
                });
            }
        }).start();
    }
}
