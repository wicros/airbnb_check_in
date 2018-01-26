package jp.metroengines.metrocheckin.activity;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.twilio.common.TwilioAccessManager;
import com.twilio.common.TwilioAccessManagerFactory;
import com.twilio.common.TwilioAccessManagerListener;
import com.twilio.conversations.AudioOutput;
import com.twilio.conversations.AudioTrack;
import com.twilio.conversations.CameraCapturer;
import com.twilio.conversations.CameraCapturerFactory;
import com.twilio.conversations.CapturerErrorListener;
import com.twilio.conversations.CapturerException;
import com.twilio.conversations.Conversation;
import com.twilio.conversations.ConversationCallback;
import com.twilio.conversations.ConversationListener;
import com.twilio.conversations.ConversationsClient;
import com.twilio.conversations.ConversationsClientListener;
import com.twilio.conversations.IncomingInvite;
import com.twilio.conversations.LocalMedia;
import com.twilio.conversations.LocalMediaFactory;
import com.twilio.conversations.LocalMediaListener;
import com.twilio.conversations.LocalVideoTrack;
import com.twilio.conversations.LocalVideoTrackFactory;
import com.twilio.conversations.MediaTrack;
import com.twilio.conversations.OutgoingInvite;
import com.twilio.conversations.Participant;
import com.twilio.conversations.ParticipantListener;
import com.twilio.conversations.TwilioConversations;
import com.twilio.conversations.TwilioConversationsException;
import com.twilio.conversations.VideoRendererObserver;
import com.twilio.conversations.VideoTrack;
import com.twilio.conversations.VideoViewRenderer;
import com.yanzhenjie.nohttp.rest.AsyncRequestExecutor;
import com.yanzhenjie.nohttp.rest.Response;
import com.yanzhenjie.nohttp.rest.SimpleResponseListener;
import com.yanzhenjie.nohttp.rest.StringRequest;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import jp.metroengines.metrocheckin.R;
import jp.metroengines.metrocheckin.bean.MPDBean;
import jp.metroengines.metrocheckin.bean.ReservationBean;
import jp.metroengines.metrocheckin.bean.TokenBean;
import jp.metroengines.metrocheckin.utils.CommonUtils;
import jp.metroengines.metrocheckin.utils.SPUtils;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

public class VideoCallActivity extends BaseActivity {
    private String mAccessToken;
    private static final String TAG = VideoCallActivity.class.getName();
    /*
    * Android application UI elements
    */
    private FrameLayout previewFrameLayout;
    private ViewGroup localContainer;
    private ViewGroup participantContainer;
    private FloatingActionButton callActionFab;
    private OkHttpClient client = new OkHttpClient();

    private TwilioAccessManager accessManager;
    private ConversationsClient conversationsClient;
    private CameraCapturer cameraCapturer;

    private Conversation conversation;
    private OutgoingInvite outgoingInvite;
    private Context mContext;

    /*
    * A VideoViewRenderer receives frames from a local or remote video track and renders the frames to a provided view
    */
    private VideoViewRenderer participantVideoRenderer;
    private VideoViewRenderer localVideoRenderer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_call);

        mContext = this.getApplicationContext();
   /*
    * Check camera and microphone permissions. Needed in Android M.
    */
        if (!checkPermissionForCameraAndMicrophone()) {
            requestPermissionForCameraAndMicrophone();
        }

   /*
    * Load views from resources
    */
        previewFrameLayout = (FrameLayout) findViewById(R.id.previewFrameLayout);
        localContainer = (ViewGroup) findViewById(R.id.localContainer);
        participantContainer = (ViewGroup) findViewById(R.id.participantContainer);

        callActionFab = (FloatingActionButton) findViewById(R.id.call_action_fab);
        callActionFab.setOnClickListener(callActionFabClickListener());

        getCapabilityToken();
    }

    private void getCapabilityToken() {
        StringRequest request = new StringRequest(CommonUtils.ACESS_TOKEN_URL);
        request.addHeader("auth-token",CommonUtils.MPDTOKEN);
        ReservationBean reservationBean = gson.fromJson((String) SPUtils.get(this,SPUtils.CURRENT_RESERVATION,"{}"), ReservationBean.class);
        request.addHeader("user-name",reservationBean.getGuest_first_name());

        AsyncRequestExecutor.INSTANCE.execute(0, request, new SimpleResponseListener<String>() {
            @Override
            public void onSucceed(int what, Response<String> response) {
                MPDBean mPDBean = gson.fromJson(response.get(), MPDBean.class);
                TokenBean tokenBean = gson.fromJson(response.get(), TokenBean.class);
                if (tokenBean != null && !TextUtils.isEmpty(tokenBean.getToken())){
                    mAccessToken = tokenBean.getToken();
                    CommonUtils.toast(VideoCallActivity.this, "token:"+tokenBean.getToken());
                    initializeTwilioSdk(mAccessToken);
                }else if(mPDBean != null && !TextUtils.isEmpty(mPDBean.getMessage())){
                    CommonUtils.toast(VideoCallActivity.this, mPDBean.getMessage());
                }else{
                    CommonUtils.toast(VideoCallActivity.this, VideoCallActivity.this.getString(R.string.net_error));
                }
            }
            @Override
            public void onFailed(int what, Response<String> response) {
                CommonUtils.toast(VideoCallActivity.this, VideoCallActivity.this.getString(R.string.net_error));
            }
        });
    }

//    private void getCapabilityToken() {
//        try {
//            run("http://[your-ngrok-url].ngrok.io/token.php", new Callback() {
//
//                @Override
//                public void onFailure(Call call, IOException e) {
//                    e.printStackTrace();
//                }
//
//                @Override
//                public void onResponse(Call call, Response response) throws IOException {
//                    try {
//                        String token = response.body().string();
//                        JSONObject obj = new JSONObject(token);
//                        mAccessToken = obj.getString("token");
//                        Log.d(TAG, token);
//                        initializeTwilioSdk(mAccessToken);
//
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                }
//            });
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }


    private void initializeTwilioSdk(final String accessToken) {
        TwilioConversations.setLogLevel(TwilioConversations.LogLevel.DEBUG);

        if(!TwilioConversations.isInitialized()) {
            TwilioConversations.initialize(this.mContext, new TwilioConversations.InitListener() {
                @Override
                public void onInitialized() {
                    accessManager = TwilioAccessManagerFactory.createAccessManager(accessToken, accessManagerListener());
                    conversationsClient = TwilioConversations.createConversationsClient(accessManager, conversationsClientListener());
                    // Specify the audio output to use for this conversation client
                    conversationsClient.setAudioOutput(AudioOutput.SPEAKERPHONE);

                    // Initialize the camera capturer and start the camera preview
                    cameraCapturer = CameraCapturerFactory.createCameraCapturer( VideoCallActivity.this, CameraCapturer.CameraSource.CAMERA_SOURCE_FRONT_CAMERA, previewFrameLayout, capturerErrorListener());
                    startPreview();
                    // Register to receive incoming invites
                    conversationsClient.listen();
                    Toast.makeText(VideoCallActivity.this,
                            "success to initialize the Twilio Conversations SDK",
                            Toast.LENGTH_LONG).show();
                }

                @Override
                public void onError(Exception e) {
                    Toast.makeText(VideoCallActivity.this,
                            "Failed to initialize the Twilio Conversations SDK",
                            Toast.LENGTH_LONG).show();
                }
            });
        }
    }

    private void startPreview() {
        cameraCapturer.startPreview();
    }

    private void stopPreview() {
        if(cameraCapturer != null && cameraCapturer.isPreviewing()) {
            cameraCapturer.stopPreview();
        }
    }

    private void reset() {
        if(participantVideoRenderer != null) {
            participantVideoRenderer = null;
        }
        localContainer.removeAllViews();
        participantContainer.removeAllViews();

        if(conversation != null) {
            conversation.dispose();
            conversation = null;
        }
        outgoingInvite = null;

        if (conversationsClient != null) {
            conversationsClient.setAudioOutput(AudioOutput.HEADSET);
        }
        setCallAction();
        startPreview();
    }

    private void hangup() {
        if(conversation != null) {
            conversation.disconnect();
        } else if(outgoingInvite != null){
            outgoingInvite.cancel();
        }
    }

    private void setHangupAction() {
        callActionFab.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this, android.R.color.holo_red_dark)));
        callActionFab.show();
        callActionFab.setOnClickListener(hangupActionFabClickListener());
    }

    private LocalMedia setupLocalMedia() {
        LocalMedia localMedia = LocalMediaFactory.createLocalMedia(localMediaListener());
        LocalVideoTrack localVideoTrack = LocalVideoTrackFactory.createLocalVideoTrack(cameraCapturer);
        localMedia.addLocalVideoTrack(localVideoTrack);
        return localMedia;
    }

    private void setCallAction() {
        callActionFab.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this, android.R.color.holo_green_dark)));
        callActionFab.show();
        callActionFab.setOnClickListener(callActionFabClickListener());
    }

    /*
    * UTILITY FUNCTIONS
    */

    private boolean checkPermissionForCameraAndMicrophone() {
        int resultCamera = ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA);
        int resultMic = ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO);
        return (resultCamera == PackageManager.PERMISSION_GRANTED) && (resultMic == PackageManager.PERMISSION_GRANTED);
    }

    private void requestPermissionForCameraAndMicrophone() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CAMERA) || ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.RECORD_AUDIO)) {
            Toast.makeText(this, "Camera and Microphone permissions needed. Please allow in App Settings for additional functionality.", Toast.LENGTH_LONG).show();
        } else {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA, Manifest.permission.RECORD_AUDIO}, 1);
        }
    }

    private Call run(String url, Callback callback) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        Call response = client.newCall(request);
        response.enqueue(callback);
        return response;
    }

    /*
    * EVENT LISTENERS
    */
    private TwilioAccessManagerListener accessManagerListener() {
        return new TwilioAccessManagerListener() {
            @Override
            public void onAccessManagerTokenExpire(TwilioAccessManager twilioAccessManager) {
            }
            @Override
            public void onTokenUpdated(TwilioAccessManager twilioAccessManager) {
            }
            @Override
            public void onError(TwilioAccessManager twilioAccessManager, String s) {
            }
        };
    }

    private ConversationsClientListener conversationsClientListener() {
        return new ConversationsClientListener() {
            @Override
            public void onStartListeningForInvites(ConversationsClient conversationsClient) {
            }

            @Override
            public void onStopListeningForInvites(ConversationsClient conversationsClient) {
            }

            @Override
            public void onFailedToStartListening(ConversationsClient conversationsClient, TwilioConversationsException e) {
            }

            @Override
            public void onIncomingInvite(ConversationsClient conversationsClient, IncomingInvite incomingInvite) {
                if (conversation == null) {
                    LocalMedia localMedia = setupLocalMedia();
                    incomingInvite.accept(localMedia, new ConversationCallback() {
                        @Override
                        public void onConversation(Conversation conversation, TwilioConversationsException e) {
                            if (e == null) {
                                 VideoCallActivity.this.conversation = conversation;
                                conversation.setConversationListener(conversationListener());
                            } else {
                                Log.e(TAG, e.getMessage());
                                hangup();
                                reset();
                            }
                        }
                    });
                    setHangupAction();
                } else {
                    Log.w(TAG, String.format("Conversation in progress. Invite from %s ignored", incomingInvite.getInvitee()));
                }
            }


            @Override
            public void onIncomingInviteCancelled(ConversationsClient conversationsClient, IncomingInvite incomingInvite) {

            }
        };
    }

    private CapturerErrorListener capturerErrorListener() {
        return new CapturerErrorListener() {
            @Override
            public void onError(CapturerException e) {
                Log.e(TAG, "Camera capturer error:" + e.getMessage());
            }
        };
    }

    private View.OnClickListener hangupActionFabClickListener() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hangup();
                setCallAction();
            }
        };
    }

    private ConversationListener conversationListener() {
        return new ConversationListener() {
            @Override
            public void onFailedToConnectParticipant(Conversation conversation, Participant participant, TwilioConversationsException e) {

            }

            @Override
            public void onConversationEnded(Conversation conversation, TwilioConversationsException e) {
                reset();
            }

            @Override
            public void onParticipantConnected(Conversation conversation, Participant participant) {
                Log.d(TAG, "onParticipantConnected: Participant connected");
                participant.setParticipantListener(participantListener());
            }

            @Override
            public void onParticipantDisconnected(Conversation conversation, Participant participant) {
                reset();
            }
        };
    }

    private ParticipantListener participantListener() {

        return new ParticipantListener() {
            @Override
            public void onVideoTrackAdded(Conversation conversation, Participant participant, VideoTrack videoTrack) {
                Log.i(TAG, "onVideoTrackAdded " + participant.getIdentity());

                // Remote participant
                participantVideoRenderer = new VideoViewRenderer( VideoCallActivity.this, participantContainer);
                participantVideoRenderer.setObserver(new VideoRendererObserver() {

                    @Override
                    public void onFirstFrame() {
                        Log.i(TAG, "Participant onFirstFrame");
                    }

                    @Override
                    public void onFrameDimensionsChanged(int width, int height, int i2) {
                        Log.i(TAG, "Participant onFrameDimensionsChanged " + width + " " + height);
                    }

                });
                videoTrack.addRenderer(participantVideoRenderer);
            }

            @Override
            public void onVideoTrackRemoved(Conversation conversation, Participant participant, VideoTrack videoTrack) {
                participantContainer.removeAllViews();

            }

            @Override
            public void onAudioTrackAdded(Conversation conversation, Participant participant, AudioTrack audioTrack) {

            }

            @Override
            public void onAudioTrackRemoved(Conversation conversation, Participant participant, AudioTrack audioTrack) {

            }

            @Override
            public void onTrackEnabled(Conversation conversation, Participant participant, MediaTrack mediaTrack) {

            }

            @Override
            public void onTrackDisabled(Conversation conversation, Participant participant, MediaTrack mediaTrack) {

            }
        };
    }

    private LocalMediaListener localMediaListener(){
        return new LocalMediaListener() {
            @Override
            public void onLocalVideoTrackAdded(LocalMedia localMedia, LocalVideoTrack localVideoTrack) {
                localVideoRenderer = new VideoViewRenderer( VideoCallActivity.this, localContainer);
                localVideoTrack.addRenderer(localVideoRenderer);
            }

            @Override
            public void onLocalVideoTrackRemoved(LocalMedia localMedia, LocalVideoTrack localVideoTrack) {
                localContainer.removeAllViews();
            }

            @Override
            public void onLocalVideoTrackError(LocalMedia localMedia, LocalVideoTrack localVideoTrack, TwilioConversationsException e) {
                Log.e(TAG, e.getMessage());
            }
        };
    }

    private View.OnClickListener callActionFabClickListener() {
        return new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(conversationsClient != null){
                    stopPreview();

                    Set<String> participants = new HashSet<>();
                    participants.add("YawningQuincyPortland");

                    // Create local media
                    LocalMedia localMedia = setupLocalMedia();
                    outgoingInvite = conversationsClient.sendConversationInvite(participants, localMedia, new ConversationCallback() {
                        @Override
                        public void onConversation(Conversation conversation, TwilioConversationsException e) {
                            Log.e(TAG, "TwilioConversationsException:" + e);
                            if (e == null) {
                                // Participant has accepted invite, we are in active conversation
                                VideoCallActivity.this.conversation = conversation;
                                conversation.setConversationListener(conversationListener());
                                setHangupAction();
                            } else {
                                hangup();
                                reset();
                            }
                        }
                    });
                }else{
                    Log.e(TAG, "invalid participant call");
                }
            }
        };
    }
}