package jp.metroengines.metrocheckin.helper;

import android.text.TextUtils;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.hosopy.actioncable.ActionCable;
import com.hosopy.actioncable.ActionCableException;
import com.hosopy.actioncable.Channel;
import com.hosopy.actioncable.Consumer;
import com.hosopy.actioncable.Subscription;

import java.net.URI;
import java.net.URISyntaxException;

import jp.metroengines.metrocheckin.bean.ActionCableBean;
import jp.metroengines.metrocheckin.bean.ReservationBean;
import jp.metroengines.metrocheckin.utils.CommonUtils;

/**
 * Created by mac on 2018/1/30.
 */

public class ActionbleHelper {

    private static String step;
    private final static String INIT_CALL = "init_call";

    private static ActionbleHelper mInstance;
    private static final String URL = "wss://staging.metroengines.jp/cable?auth-token=" + CommonUtils.MPDTOKEN;
    Gson _gson;

    public ActionbleHelper() {
    }

    public static ActionbleHelper getInstance() {
        if (mInstance == null) {
            synchronized (ActionbleHelper.class) {
                if (mInstance == null) {
                    mInstance = new ActionbleHelper();
                }
            }
        }
        return mInstance;
    }

    public void init(final ReservationBean reservationBean, Gson gson) {
        _gson = gson;
        step = INIT_CALL;
        // 1. Setup
        URI uri = null;
        try {
            uri = new URI(URL);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        Consumer.Options options = new Consumer.Options();
        options.reconnection = true;
        options.reconnectionMaxAttempts = 60;
        CommonUtils.log("actioncable-url:"+uri);
        Consumer consumer = ActionCable.createConsumer(uri,options);
        // 2. Create subscription
        Channel appearanceChannel = new Channel("ReservationsChannel");
        CommonUtils.log("actioncable-reservation_id:"+reservationBean.getId());
        appearanceChannel.addParam("reservation_id",reservationBean.getId());

        final Subscription subscription = consumer.getSubscriptions().create(appearanceChannel);

        subscription
                .onConnected(new Subscription.ConnectedCallback() {
                    @Override
                    public void call() {
                        // Called when the subscription has been successfully completed
                        CommonUtils.log("actioncable:Connected");
                        if(TextUtils.equals(step,INIT_CALL)){
                            JsonObject params = new JsonObject();
                            params.addProperty("call_id", reservationBean.getId());
                            subscription.perform(INIT_CALL, params);
                        }
                    }
                }).onRejected(new Subscription.RejectedCallback() {
                    @Override
                    public void call() {
                        // Called when the subscription is rejected by the server
                        CommonUtils.log("actioncable:Rejected");
                    }
                }).onReceived(new Subscription.ReceivedCallback() {
                    @Override
                    public void call(JsonElement data) {
                    // Called when the subscription receives data from the server
                        CommonUtils.log("actioncable:get:"+data);
                        if(TextUtils.equals(step,INIT_CALL)){
                            ActionCableBean actionCableBean = _gson.fromJson(data, ActionCableBean.class);
                            if(TextUtils.equals(actionCableBean.getEvent(),"call_indication_received")){

                            }
                        }
                    }
                }).onDisconnected(new Subscription.DisconnectedCallback() {
                    @Override
                    public void call() {
                        // Called when the subscription has been closed
                        CommonUtils.log("actioncable:Disconnected");
                    }
                }).onFailed(new Subscription.FailedCallback() {
                    @Override
                    public void call(ActionCableException e) {
                        // Called when the subscription encounters any error
                        CommonUtils.log("actioncable:error:"+e.getMessage());
                    }
                });

        // 3. Establish connection
        consumer.connect();
    }
}
