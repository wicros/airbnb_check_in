package jp.metroengines.metrocheckin.widgets;


import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.TextView;

import jp.metroengines.metrocheckin.R;

/**
 * Created by mac on 2018/1/24.
 */

public class MyProgressDialog extends android.app.Dialog {

    TextView tvPrg;
    ProgressBar prg;
    Context context;

    public MyProgressDialog(Context context) {
        super(context);
        this.context = context;
        View view = View.inflate(context, R.layout.progress_dialog, null);
        setContentView(view);
        tvPrg = view.findViewById(R.id.tv_prg);
        prg = view.findViewById(R.id.prg);
    }

    public void show(CharSequence text) {
        tvPrg.setText(text);
        prg.setVisibility(View.VISIBLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
        super.show();
    }

    public void result(CharSequence text){
        tvPrg.setText(text);
        prg.setVisibility(View.GONE);
        new Handler().postDelayed(new Runnable(){
            public void run() {
                getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
                dismiss();
            }
        }, 1000);
    }
}
