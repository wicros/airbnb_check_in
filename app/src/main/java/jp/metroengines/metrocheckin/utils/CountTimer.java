package jp.metroengines.metrocheckin.utils;

import android.os.CountDownTimer;

import jp.metroengines.metrocheckin.activity.BaseActivity;

/**
 * Created by mac on 2018/2/7.
 */

public class CountTimer extends CountDownTimer {

    private BaseActivity context;

    /**
     * 参数 millisInFuture       倒计时总时间（如60S，120s等）
     * 参数 countDownInterval    渐变时间（每次倒计1s）
     */
    public CountTimer(long millisInFuture, long countDownInterval,BaseActivity context) {
        super(millisInFuture, countDownInterval);
        this.context=context;
    }

    // 计时完毕时触发
    @Override
    public void onFinish() {
        context.back_to_main();
    }
    // 计时过程显示
    @Override
    public void onTick(long millisUntilFinished) {
    }

}

