package jp.metroengines.metrocheckin.utils;
import android.content.Context;
import android.widget.Toast;

/**
 * Created by mac on 2018/1/23.
 */

public class CommonUtils {

    public static final String HOSTURL = "https://staging.metroengines.jp";
    public static final String MPDTOKEN = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJ1c2VyX2lkIjoiYzk0OThmMWMtNWFiMy0xMWU2LWE1ZDMtMDY4MTBmNWNlZjYzIiwiZXhwIjoxNTE5Mjk0NjU1fQ.BTWwCJw0Br0vw3sAT9sdpYTwFpmPq8BUHesVeW2DvDafCtEghS8Gkg5NN0O2dCKC-XuS9MOeq3VuPJhQH21p_QOSsPLcDfguKte2sk9d_lIh1BtQH96zIYv5Ip88Nfohv0S_OguJ_eQC0yRy9IBI9Qn3kMq-WBicl5kxfmR6_jk";

    public static final String RESERVATION_URL = HOSTURL + "/api/v1/reservations/";
    public static final String ACESS_TOKEN_URL = HOSTURL + "/api/v1/twilio-video/token";

    public static void toast(Context context,String text){
       Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
    }


}
