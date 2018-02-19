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
    private final static String CALL_INDICATION_RECEIVED = "call_indication_received";
    private final static String CALL_REJECTED_BY_HOST = "call_rejected_by_host";

    private static ActionbleHelper mInstance;
    private static String URL = CommonUtils.ACTIONURL;

    private Gson _gson;
    private Consumer consumer;
    private ActionRunnable runnable;

    public interface ActionRunnable {
        void run(boolean guest_verified);

        void onerror();
    }

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

    public void init(final ReservationBean reservationBean, Gson gson, final ActionRunnable runnable) {
        _gson = gson;
        this.runnable = runnable;
        step = INIT_CALL;
        // 1. Setup
        URI uri = null;
        URL = URL + "&user-id="+reservationBean.getUser_id();
        //URL = URL + "&user-id=2fbe27ce-956e-41cb-9ad2-1c8328a8fb16";
        try {
            uri = new URI(URL);
        } catch (URISyntaxException e) {
            CommonUtils.log("error:"+e.getMessage());
        }

        Consumer.Options options = new Consumer.Options();
        options.reconnection = true;
        options.reconnectionMaxAttempts = 60;
        CommonUtils.log("actioncable-url:"+uri);
        consumer = ActionCable.createConsumer(uri,options);
        // 2. Create subscription
        Channel appearanceChannel = new Channel("ReservationsChannel");
        CommonUtils.log("actioncable-reservation_id:"+reservationBean.getId());
        CommonUtils.log("actioncable-user-id:"+reservationBean.getUser_id());
        appearanceChannel.addParam("reservation_id",reservationBean.getId());
        //appearanceChannel.addParam("reservation_id","905276");
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
                            CommonUtils.log("actioncable:send:"+INIT_CALL+params.toString());
                        }
                        //actioncable:get:{"event":"call_result_submitted","guest_verified":true}
                    }
                }).onRejected(new Subscription.RejectedCallback() {
                    @Override
                    public void call() {
                        // Called when the subscription is rejected by the server
                        runnable.onerror();
                        CommonUtils.log("actioncable:Rejected");
                    }
                }).onReceived(new Subscription.ReceivedCallback() {
                    @Override
                    public void call(JsonElement data) {
                        // Called when the subscription receives data from the server
                        CommonUtils.log("actioncable:get:"+data);
                        ActionCableBean actionCableBean = _gson.fromJson(data, ActionCableBean.class);
                        if(TextUtils.equals(step,INIT_CALL)){
                            step = CALL_INDICATION_RECEIVED;
                        }

                        if(TextUtils.equals(actionCableBean.getEvent(),"establishing_call")){
                            JsonObject params = new JsonObject();
                            params.addProperty("device_id", actionCableBean.getDevice_id());
                            CommonUtils.log(actionCableBean.getDevice_id());
                            subscription.perform("allowed_to_establish_call", params);
                        }

                        if(TextUtils.equals(actionCableBean.getEvent(),"call_result_submitted")){
                            runnable.run(actionCableBean.getGuest_verified());
                        }

                        if(TextUtils.equals(actionCableBean.getEvent(),"call_rejected_by_host")){
                            runnable.onerror();
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
                        runnable.onerror();
                        CommonUtils.log("actioncable:error:"+e.getMessage());
                    }
                });

        // 3. Establish connection
        consumer.connect();
    }

    public void disconnect(){
        if(consumer != null){
            consumer.disconnect();
        }
    }
}
