package jp.metroengines.metrocheckin.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import jp.metroengines.metrocheckin.R;
import jp.metroengines.metrocheckin.utils.SPUtils;

public class GuestNumActivity extends AppCompatActivity {

    @BindView(R.id.num_spinner)
    Spinner numSpinner;
    @BindView(R.id.bt_confirm)
    Button btConfirm;

    private List<Integer> mItems;
    private int confirm_pos = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest_num);
        ButterKnife.bind(this);

        mItems = new ArrayList<Integer>();
        for (int i = 1; i <= 25; i++) {
            mItems.add(i);
        }
        ArrayAdapter<Integer> adapter = new ArrayAdapter<Integer>(this, android.R.layout.simple_spinner_item, mItems);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        numSpinner.setAdapter(adapter);
        numSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                confirm_pos = i;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });

    }

    @OnClick(R.id.bt_confirm)
    public void onViewClicked() {
        SPUtils.put(GuestNumActivity.this,SPUtils.GUEST_NUM,mItems.get(confirm_pos));
        startActivity(new Intent(GuestNumActivity.this,GuestInfoActivity.class));
    }

}
