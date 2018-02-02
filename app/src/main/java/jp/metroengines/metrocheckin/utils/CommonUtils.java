package jp.metroengines.metrocheckin.utils;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by mac on 2018/1/23.
 */

public class CommonUtils {
    public static final String HOSTURL = "https://staging.metroengines.jp/api/v1/";
    //public static final String HOSTURL = "https://minpaku-dashboard.jp/api/v1/";

    public static final String MPDTOKEN = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJ1c2VyX2lkIjoiYzk0OThmMWMtNWFiMy0xMWU2LWE1ZDMtMDY4MTBmNWNlZjYzIiwiZXhwIjoxNTE5Mjk0NjU1fQ.BTWwCJw0Br0vw3sAT9sdpYTwFpmPq8BUHesVeW2DvDafCtEghS8Gkg5NN0O2dCKC-XuS9MOeq3VuPJhQH21p_QOSsPLcDfguKte2sk9d_lIh1BtQH96zIYv5Ip88Nfohv0S_OguJ_eQC0yRy9IBI9Qn3kMq-WBicl5kxfmR6_jk";
    //public static final String MPDTOKEN = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJ1c2VyX2lkIjoiYzk0OThmMWMtNWFiMy0xMWU2LWE1ZDMtMDY4MTBmNWNlZjYzIiwiZXhwIjoxNTE5OTcxNDQ1fQ.JfKQX810hmG-pkR90UPkxIFjw0nzouVC9bunfSh6thZ_Ae4BvFHpBtvV4EkxirMDhbMgOkvOxO_gjMm5GWLMbEzGUbKohvhSGh0TzcdgdBX1gtkSEnAUAJpeSOGycH3wmfSWAWLvNF67wfs3a5KjN_6aHU2X_kU2SNM5x4wMpskTaFvpvkAlZES5Pv_8orQCWYOZ4a6mjeWmxbG3Syx7j6FMJJxM9cEBQURsYEhXRWG9vfGhvlzGLOSRle1GD1dgQ8yGVlIPyvqkPtNFGHIZS1itJXf_XIfT-qISG-e9U_BjCoIgcsPcMGHRCkYRleDy1rvjnipHxj0l50AO6BvSMA";


    public static final String ACTIONURL =  "wss://staging.metroengines.jp/cable?auth-token=" + MPDTOKEN;
    //public static final String ACTIONURL =  "wss://minpaku-dashboard.jp/cable?auth-token=" + MPDTOKEN;

    public static final String RESERVATION_URL = HOSTURL + "reservations/";
    public static final String ACESS_TOKEN_URL = HOSTURL + "twilio-video/token";

    public static final String KEY_TOKEN = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoi44Oh44OI44Ot44Ko44Oz44K444Oz5qCq5byP5Lya56S-IiwiY3JlYXRlZF9hdCI6IjIwMTgvMDEvMzEgMjA6MzkiLCJwYXJ0bmVyIjp0cnVlfQ.NOaHEurLCmOXD2RNDTjRu7b7-A9LrtV1LjSqRgvvKjA";
    public static final String HOSTKEY = "http://staging.key-stations.com/";
    //public static final String HOSTKEY = " https://key-stations.com/";

    public static final String GET_KEY_URL = CommonUtils.HOSTKEY+"api/v1/room_keys/";

    public static void toast(Context context,String text){
       Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
    }

    public static void log(String text){
        Log.i("MetroCheckIn",text);
    }

    public static String passport_url(String user_id,String account_id, String listing_id, int reservation_id){
        return HOSTURL + "users/"+ user_id +"/accounts/" + account_id +
                "/listings/" + listing_id +
                "/reservations/" + reservation_id + "/passport_photos";
    }
}
