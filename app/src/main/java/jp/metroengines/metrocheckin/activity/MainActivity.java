package jp.metroengines.metrocheckin.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import jp.metroengines.metrocheckin.R;
import jp.metroengines.metrocheckin.utils.SPUtils;

public class MainActivity extends BaseActivity {

    @BindView(R.id.bt_ja)
    Button btJa;
    @BindView(R.id.bt_en)
    Button btEn;
    @BindView(R.id.bt_zh)
    Button btZh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }


    @OnClick({R.id.bt_ja, R.id.bt_en, R.id.bt_zh})
    public void onViewClicked(View view) {
        String local;
        switch (view.getId()) {
            case R.id.bt_ja:
                local = "ja";
                break;
            case R.id.bt_zh:
                local = "zh";
                break;
            default:
                local = "en";
                break;
        }
        SPUtils.put(this, "local", local);

        startActivity(new Intent(this, ChosePlantActivity.class));
    }
}
