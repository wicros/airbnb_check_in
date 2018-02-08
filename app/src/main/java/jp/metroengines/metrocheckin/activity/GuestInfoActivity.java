package jp.metroengines.metrocheckin.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlacePicker;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import jp.metroengines.metrocheckin.R;
import jp.metroengines.metrocheckin.utils.CommonUtils;
import jp.metroengines.metrocheckin.utils.SPUtils;

public class GuestInfoActivity extends BaseActivity {

    @BindView(R.id.tv_num)
    TextView tvNum;
    @BindView(R.id.bt_confirm)
    Button btConfirm;
    @BindView(R.id.spinner)
    Spinner spinner;
    @BindView(R.id.et_address)
    EditText etAddress;

    private int max_num;
    private int current_num = 1;
    private  int PLACE_PICKER_REQUEST = 1;
    private  ArrayAdapter<CharSequence> adapter;
    private List<CharSequence> mItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest_info);
        ButterKnife.bind(this);
        max_num = (int) SPUtils.get(this, SPUtils.GUEST_NUM,0);
        btConfirm.setClickable(false);
        set_num_text();
        init_et_address();
        init_spinner();
    }

    private void init_et_address() {
        etAddress.setCursorVisible(false);
        etAddress.setFocusable(false);
        //etAddress.setFocusableInTouchMode(false);
        etAddress.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                btConfirm.setClickable(!TextUtils.isEmpty(charSequence));
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    private void init_spinner() {
        mItems = new ArrayList<CharSequence>();
        mItems.add("select..");
        adapter = new ArrayAdapter<CharSequence>(this, android.R.layout.simple_spinner_item, mItems);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(i > 0){
                    etAddress.setText(mItems.get(i));
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });
    }

    @OnClick({R.id.bt_confirm, R.id.et_address})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_confirm:
                if(current_num < max_num){
                    refresh();
                }else {
                    startActivity(new Intent(GuestInfoActivity.this,PassportActivity.class));
                    finish();
                }
                break;
            case R.id.et_address:
                PlacePicker.IntentBuilder builder2 = new PlacePicker.IntentBuilder();
                try {
                    startActivityForResult(builder2.build(GuestInfoActivity.this), PLACE_PICKER_REQUEST);
                } catch (GooglePlayServicesRepairableException e) {
                    e.printStackTrace();
                    CommonUtils.log("error:"+e.getMessage());
                } catch (GooglePlayServicesNotAvailableException e) {
                    e.printStackTrace();
                    CommonUtils.log("error:"+e.getMessage());
                }
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == PLACE_PICKER_REQUEST && resultCode == Activity.RESULT_OK) {
            Place place = PlacePicker.getPlace(this,data);
            etAddress.setText(place.getAddress());
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    private void set_num_text(){
        if(current_num == 1){
            tvNum.setText(""+current_num+" (Representative)/"+max_num);
        }else{
            tvNum.setText(""+current_num+"/"+max_num);
        }
    }

    private void refresh(){
        CommonUtils.toast(GuestInfoActivity.this,"sucesss");
        current_num++;
        set_num_text();
        CharSequence address = etAddress.getText();
        if(!mItems.contains(address)){
            mItems.add(address);
            adapter.notifyDataSetChanged();
        }
        etAddress.setText("");
    }

}
