package jp.metroengines.metrocheckin.activity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
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
import jp.metroengines.metrocheckin.bean.MPDBean;
import jp.metroengines.metrocheckin.bean.ReservationBean;
import jp.metroengines.metrocheckin.utils.CommonUtils;
import jp.metroengines.metrocheckin.widgets.MyProgressDialog;

public class ReservationActivity extends BaseActivity {

    @BindView(R.id.et_reservation)
    EditText etReservation;
    @BindView(R.id.bt_confirm)
    Button btConfirm;
    MyProgressDialog myProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation);
        ButterKnife.bind(this);
        setBackButton(this);
        NoHttp.initialize(this);
        myProgressDialog = new MyProgressDialog(this);
    }

    @OnClick(R.id.bt_confirm)
    public void onViewClicked() {
        Editable reservation_num = etReservation.getText();
        if(TextUtils.isEmpty(reservation_num)){
            CommonUtils.toast(this,this.getString(R.string.reservation_input));
            return;
        }
        StringRequest request = new StringRequest(CommonUtils.RESERVATION_URL + reservation_num);
        request.addHeader("auth-token",CommonUtils.MPDTOKEN);

        myProgressDialog.show(this.getString(R.string.wait));
        AsyncRequestExecutor.INSTANCE.execute(0, request, new SimpleResponseListener<String>() {
            @Override
            public void onSucceed(int what, Response<String> response) {
                MPDBean mPDBean = gson.fromJson(response.get(), MPDBean.class);
                    if (TextUtils.isEmpty(mPDBean.getMessage())){
                        ReservationBean reservationBean = gson.fromJson(response.get(), ReservationBean.class);
                    }else{
                        myProgressDialog.result(mPDBean.getMessage());
                    }
            }
            @Override
            public void onFailed(int what, Response<String> response) {
                myProgressDialog.result(ReservationActivity.this.getString(R.string.net_error));
            }
        });
    }
}
