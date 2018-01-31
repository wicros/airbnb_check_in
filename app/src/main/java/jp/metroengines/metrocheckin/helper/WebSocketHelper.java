package jp.metroengines.metrocheckin.helper;

import com.google.gson.Gson;
import com.neovisionaries.ws.client.WebSocket;
import com.neovisionaries.ws.client.WebSocketAdapter;
import com.neovisionaries.ws.client.WebSocketException;
import com.neovisionaries.ws.client.WebSocketFactory;
import com.neovisionaries.ws.client.WebSocketFrame;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import jp.metroengines.metrocheckin.utils.CommonUtils;

/**
 * Created by mac on 2018/1/29.
 */



public class WebSocketHelper {

    public enum WsStatus {
        CONNECT_SUCCESS,//连接成功
        CONNECT_FAIL,//连接失败
        CONNECTING;//正在连接
    }
    /**
     * WebSocket config
     */
    private static WebSocketHelper mInstance;
    private static final int FRAME_QUEUE_SIZE = 5;
    private static final int CONNECT_TIMEOUT = 5000;
    private static final String URL = "wss://staging.metroengines.jp/cable?auth-token="+CommonUtils.MPDTOKEN;
    private WsStatus mStatus;
    private WebSocket ws;
    private WsListener mListener;
    private WebSocketRunnable runnable;
    private  Gson gson;

    public WebSocketHelper(){
    }

    public static WebSocketHelper getInstance(){
        if(mInstance == null){
            synchronized (WebSocketHelper.class){
                if(mInstance == null){
                    mInstance = new WebSocketHelper();
                }
            }
        }
        return mInstance;
    }

    public void init(WebSocketRunnable runnable,Gson gson){
        this.gson = gson;
        CommonUtils.log("websocket-url:"+URL);
        try {
            ws = new WebSocketFactory().createSocket(URL, CONNECT_TIMEOUT)
                    .setFrameQueueSize(FRAME_QUEUE_SIZE)//设置帧队列最大值为5
                    .setMissingCloseFrameAllowed(false)//设置不允许服务端关闭连接却未发送关闭帧
                    .addListener(mListener = new WsListener())//添加回调监听
                    .connectAsynchronously();//异步连接
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.runnable = runnable;
    }

    public void send(String text){
        CommonUtils.log("websocket:send:"+text);
        ws.sendText(text);
    }

    public interface WebSocketRunnable {
        void run(WebSocket websocket, String text);
        void start(WebSocket websocket);
    }

    /**
     * 继承默认的监听空实现WebSocketAdapter,重写我们需要的方法
     * onTextMessage 收到文字信息
     * onConnected 连接成功
     * onConnectError 连接失败
     * onDisconnected 连接关闭
     */
    class WsListener extends WebSocketAdapter {
        @Override
        public void onTextMessage(WebSocket websocket, String text) throws Exception {
            super.onTextMessage(websocket, text);
            CommonUtils.log("websocket:get:"+text);
            runnable.run(websocket, text);
        }

        @Override
        public void onConnected(WebSocket websocket, Map<String, List<String>> headers)
                throws Exception {
            super.onConnected(websocket, headers);
            CommonUtils.log("websocket:连接成功");
            setStatus(WsStatus.CONNECT_SUCCESS);
            runnable.start(websocket);
        }

        @Override
        public void onConnectError(WebSocket websocket, WebSocketException exception)
                throws Exception {
            super.onConnectError(websocket, exception);
            CommonUtils.log("websocket:连接错误:"+exception.getMessage());
            setStatus(WsStatus.CONNECT_FAIL);
        }

        @Override
        public void onDisconnected(WebSocket websocket, WebSocketFrame serverCloseFrame, WebSocketFrame clientCloseFrame, boolean closedByServer)
                throws Exception {
            super.onDisconnected(websocket, serverCloseFrame, clientCloseFrame, closedByServer);
            CommonUtils.log("websocket:断开连接");
            setStatus(WsStatus.CONNECT_FAIL);
        }
    }

    private void setStatus(WsStatus status){
        this.mStatus = status;
    }

    private WsStatus getStatus(){
        return mStatus;
    }

    public void disconnect(){
        if(ws != null)
            ws.disconnect();
    }

}
