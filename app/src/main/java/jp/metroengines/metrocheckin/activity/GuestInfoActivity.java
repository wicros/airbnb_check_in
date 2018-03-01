package jp.metroengines.metrocheckin.activity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.places.Places;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.yanzhenjie.nohttp.rest.Response;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import jp.metroengines.metrocheckin.R;
import jp.metroengines.metrocheckin.bean.PlaceInfoBean;
import jp.metroengines.metrocheckin.bean.ReservationBean;
import jp.metroengines.metrocheckin.helper.AWSS3Helper;
import jp.metroengines.metrocheckin.helper.MapHelper;
import jp.metroengines.metrocheckin.utils.CommonUtils;
import jp.metroengines.metrocheckin.utils.HttpUtils;
import jp.metroengines.metrocheckin.utils.PhoneCodeUtil;
import jp.metroengines.metrocheckin.utils.SPUtils;

public class GuestInfoActivity extends BaseActivity implements GoogleApiClient.OnConnectionFailedListener, OnMapReadyCallback {


    @BindView(R.id.mapView)
    MapView mMapView;
    @BindView(R.id.tv_num)
    TextView tvNum;
    @BindView(R.id.bt_confirm)
    Button btConfirm;
    @BindView(R.id.et_address)
    EditText etAddress;
    @BindView(R.id.et_name)
    EditText etName;
    @BindView(R.id.et_job)
    EditText etJob;
    @BindView(R.id.et_tel)
    EditText etTel;
    @BindView(R.id.sp_code)
    Spinner spCode;
    @BindView(R.id.et_birth)
    EditText etBirth;

    private int max_num;
    private int current_num = 1;
    private int tel_code = 81;
    private ArrayAdapter<CharSequence> adapter;
    private List<Map> info_list = new ArrayList();
    private GoogleApiClient mGoogleApiClient;
    private GoogleMap map;
    private Marker marker;
    private Timer time;
    private TimerTask timerTask;
    private DatePickerDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest_info);
        ButterKnife.bind(this);
        init_google_client();
        max_num = (int) SPUtils.get(this, SPUtils.GUEST_NUM, 0);
        set_num_text();
        init_et_address();
        init_spinner();
        init_date_picker();
        mMapView.onCreate(savedInstanceState);
        mMapView.getMapAsync(this);
    }

    private void init_date_picker() {
        etBirth.setCursorVisible(false);
        etBirth.setFocusable(false);
        etBirth.setFocusableInTouchMode(false);
        DatePickerDialog.OnDateSetListener listener=new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker arg0, int year, int month, int day) {
                etBirth.setText(year+"-"+(++month)+"-"+day);
            }
        };
        dialog=new DatePickerDialog(GuestInfoActivity.this, 0,listener,2000,0,1);
    }

    private void init_spinner() {
        PhoneCodeUtil phoneCodeUtil = new PhoneCodeUtil(gson);
        final List<Integer> code_list = phoneCodeUtil.get_code_list();
        ArrayAdapter<Integer> adapter = new ArrayAdapter<Integer>(this, R.layout.info_simple_spinner_item, phoneCodeUtil.get_spinner_list());
        adapter.setDropDownViewResource(R.layout.info_simple_spinner_drop_item);
        spCode.setAdapter(adapter);
        spCode.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                tel_code = code_list.get(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    private void init_google_client() {
        mGoogleApiClient = new GoogleApiClient
                .Builder(this)
                .addApi(Places.GEO_DATA_API)
                .addApi(Places.PLACE_DETECTION_API)
                .enableAutoManage(this, this)
                .build();
    }

    private void init_et_address() {
        etAddress.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (time != null) {
                    time.cancel();
                    time = null;
                    timerTask = null;
                }
                if (!TextUtils.isEmpty(charSequence)) {
                    time = new Timer();
                    timerTask = new TimerTask() {
                        public void run() {
                            new MapHelper(GuestInfoActivity.this, gson, mGoogleApiClient).getLatLng(etAddress.getText().toString(), new HttpUtils.HttpRunnable() {
                                @Override
                                public void run(Response<String> response) {
                                    PlaceInfoBean placeInfoBean = gson.fromJson(response.get(), PlaceInfoBean.class);
                                    PlaceInfoBean.ResultsBean resultsBean = placeInfoBean.getResults().get(0);
                                    if (resultsBean != null) {
                                        PlaceInfoBean.ResultsBean.GeometryBean.LocationBean location = resultsBean.getGeometry().getLocation();
                                        LatLng latlng = new LatLng(location.getLat(), location.getLng());
                                        map.moveCamera(CameraUpdateFactory.newLatLngZoom(latlng, 13));
                                        marker.setPosition(latlng);
                                    }
                                }

                                @Override
                                public void onerror() {

                                }
                            });
                        }
                    };
                    time.schedule(timerTask, 1000);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }


    @OnClick({R.id.bt_confirm,R.id.et_birth})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_confirm:
                refresh();
                break;
            case R.id.et_birth:
                dialog.show();
                break;
        }
    }

    private void upload_file(final AWSS3Helper awss3Helper) {
        String reservation = (String) SPUtils.get(this, SPUtils.CURRENT_RESERVATION, "{}");
        ReservationBean reservationBean = gson.fromJson(reservation, ReservationBean.class);
        String format = ".txt";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        String file_name = "guest_info_" + reservationBean.getId() + "_" + simpleDateFormat.format(new Date(System.currentTimeMillis()));
        final File file = new File(this.getFilesDir().toString(), file_name + format);
        try {
            OutputStreamWriter or = new OutputStreamWriter(new FileOutputStream(file));
            BufferedWriter bw = new BufferedWriter(or);
            Map map = new HashMap();
            map.put("info_list", info_list);
            String json = gson.toJson(map);
            CommonUtils.log("guest_json:" + json);
            bw.write(json);
            SPUtils.put(GuestInfoActivity.this, SPUtils.GUEST_INFO, json);
            bw.flush();
            bw.close();
            or.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        awss3Helper.upload_file(file_name, format, new AWSS3Helper.S3Runnable() {
            @Override
            public void success() {
                if (file.exists()) {
                    file.delete();
                }
                startActivity(new Intent(GuestInfoActivity.this, PassportActivity.class));
                awss3Helper.get_dialog().dismiss();
            }

            @Override
            public void error() {
            }
        });

    }

    private void set_num_text() {
        tvNum.setText("" + current_num + "/" + max_num);
    }

    private void refresh() {
        if (TextUtils.isEmpty(etAddress.getText()) || TextUtils.isEmpty(etJob.getText()) || TextUtils.isEmpty(etName.getText()) || TextUtils.isEmpty(etTel.getText()) || TextUtils.isEmpty(etBirth.getText())) {
            CommonUtils.toast(GuestInfoActivity.this, GuestInfoActivity.this.getString(R.string.cannot_null));
        } else {
            Map info = new HashMap();
            info.put("name", etName.getText().toString());
            etName.setText("");
            info.put("profession", etJob.getText().toString());
            etJob.setText("");
            info.put("tel", "" + tel_code + "-" + etTel.getText().toString());
            etTel.setText("");
            info.put("birth_date", etBirth.getText().toString());
            etBirth.setText("");
            info.put("address", etAddress.getText().toString());
            info_list.add(info);
            if (current_num < max_num) {
                current_num++;
                set_num_text();
                CommonUtils.toast(GuestInfoActivity.this, GuestInfoActivity.this.getString(R.string.success));
            } else {
                final AWSS3Helper awss3Helper = new AWSS3Helper(GuestInfoActivity.this, gson);
                awss3Helper.get_dialog().show(GuestInfoActivity.this.getString(R.string.wait));
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        upload_file(awss3Helper);
                    }
                }).start();
            }
        }
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;
        LatLng sydney = new LatLng(-33.867, 151.206);
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, 13));
        marker = map.addMarker(new MarkerOptions().position(sydney));
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mMapView.onSaveInstanceState(outState);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mMapView.onResume();
    }

    @Override
    protected void onStart() {
        super.onStart();
        mMapView.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mMapView.onStop();
    }


    @Override
    protected void onPause() {
        mMapView.onPause();
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        mMapView.onDestroy();
        super.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mMapView.onLowMemory();
    }

}
