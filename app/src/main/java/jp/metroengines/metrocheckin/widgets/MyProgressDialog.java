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

    public void change_text(CharSequence text) {
        tvPrg.setText(text);
    }

    public void change_text(int r_id) {
        tvPrg.setText( context.getString(r_id));
    }

    public void show(CharSequence text) {
        tvPrg.setText(text);
        prg.setVisibility(View.VISIBLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
        super.show();
    }


    public void dismiss_dialog(){
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
        dismiss();
    }

    public void result(CharSequence text){
        tvPrg.setText(text);
        prg.setVisibility(View.GONE);

        new Handler().postDelayed(new Runnable(){
            public void run() {
                dismiss_dialog();
            }
        }, 1000);

    }

    public void result(int r_id){
        tvPrg.setText( context.getString(r_id));
        prg.setVisibility(View.GONE);
        new Handler().postDelayed(new Runnable(){
            public void run() {
                dismiss_dialog();
            }
        }, 1000);
    }
}
