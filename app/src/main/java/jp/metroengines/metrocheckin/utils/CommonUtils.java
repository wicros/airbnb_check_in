package jp.metroengines.metrocheckin.utils;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by mac on 2018/1/23.
 */

public class CommonUtils {
    //public static final String HOSTURL = "https://staging.metroengines.jp/api/v1/";
    public static final String HOSTURL = "https://minpaku-dashboard.jp/api/v1/";

    //public static final String MPDTOKEN = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJ1c2VyX2lkIjoiYzk0OThmMWMtNWFiMy0xMWU2LWE1ZDMtMDY4MTBmNWNlZjYzIiwiZXhwIjoxNTE5Mjk0NjU1fQ.BTWwCJw0Br0vw3sAT9sdpYTwFpmPq8BUHesVeW2DvDafCtEghS8Gkg5NN0O2dCKC-XuS9MOeq3VuPJhQH21p_QOSsPLcDfguKte2sk9d_lIh1BtQH96zIYv5Ip88Nfohv0S_OguJ_eQC0yRy9IBI9Qn3kMq-WBicl5kxfmR6_jk";
    public static final String MPDTOKEN = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJ1c2VyX2lkIjoiYzk0OThmMWMtNWFiMy0xMWU2LWE1ZDMtMDY4MTBmNWNlZjYzIiwiZXhwIjoxNTIyNTczNjM1fQ.zbWEE63He5exHb1yRaUGKQd2Z0QnM06NXq-HOhgIy7fPx_oQUpF_sBv-wInTXMshJyxtBHArGMqfdk1WKeGQaOjJEt8m8NUCOIyP3eQIHWyPdUQNP3Cp5X-tw8Za7z4GN0mDh621BiviEzDqkaARamKYkocQiJr37eVExh8SAjPqkHtPIUuDAwzGWZ6K0ujdrSuKCdp1S_unQciG75gnfagPqggvxOYkKwZrtOHXqVURHi1-WOIWGI5CJiVR_CoGudTkMGGVbOwvyxxhSyDPasCk3SpFNAhw-Oz20bidec7UWMGTP5GHmfJXvzphUS9i8kMRiwB6Yy-SpuZaSZaZlA";

    //public static final String ACTIONURL =  "wss://staging.metroengines.jp/cable?auth-token=" + MPDTOKEN;
    public static final String ACTIONURL =  "wss://minpaku-dashboard.jp/cable?auth-token=" + MPDTOKEN;

    public static final String RESERVATION_URL = HOSTURL + "reservations/";
    public static final String ACESS_TOKEN_URL = HOSTURL + "twilio-video/token";

    //public static final String KEY_TOKEN = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoi44Oh44OI44Ot44Ko44Oz44K444Oz5qCq5byP5Lya56S-IiwiY3JlYXRlZF9hdCI6IjIwMTgvMDEvMzEgMjA6MzkiLCJwYXJ0bmVyIjp0cnVlfQ.NOaHEurLCmOXD2RNDTjRu7b7-A9LrtV1LjSqRgvvKjA";
    public static final String KEY_TOKEN="Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoi44Oh44OI44Ot44Ko44Oz44K444Oz5qCq5byP5Lya56S-IiwiY3JlYXRlZF9hdCI6IjIwMTgvMDIvMjAgMTM6MTMiLCJwYXJ0bmVyIjp0cnVlfQ.TACYh6nktZFygMI-3Wj1mN8k1MXEKWCzkEmIpTwuWXs";

    //public static final String HOSTKEY = "http://staging.key-stations.com/";
    public static final String HOSTKEY = "https://key-stations.com/";

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

    public static byte[] fileToBytes(File file) {
        byte[] buffer = null;
        FileInputStream fis = null;
        ByteArrayOutputStream bos = null;

        try {
            fis = new FileInputStream(file);
            bos = new ByteArrayOutputStream();

            byte[] b = new byte[1024];

            int n;

            while ((n = fis.read(b)) != -1) {
                bos.write(b, 0, n);
            }

            buffer = bos.toByteArray();
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        } finally {
            try {
                if (null != bos) {
                    bos.close();
                }
            } catch (IOException ex) {
            } finally{
                try {
                    if(null!=fis){
                        fis.close();
                    }
                } catch (IOException ex) {
                }
            }
        }
        return buffer;
    }

}
