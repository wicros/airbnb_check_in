package jp.metroengines.metrocheckin.utils;
import android.content.Context;
import android.widget.Toast;

/**
 * Created by mac on 2018/1/23.
 */

public class CommonUtils {

    public static final String HOSTURL = "https://staging.metroengines.jp";

    public static final String RESERVATION_URL = HOSTURL + "/api/v1/users/current/reservations/reservation-code/";

    public static void toast(Context context,String text){
       Toast.makeText(context, text, Toast.LENGTH_LONG).show();
    }


}
