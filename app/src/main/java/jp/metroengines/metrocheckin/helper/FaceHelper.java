package jp.metroengines.metrocheckin.helper;

import android.content.Context;
import android.util.Base64;

import com.google.gson.Gson;
import com.yanzhenjie.nohttp.RequestMethod;
import com.yanzhenjie.nohttp.rest.StringRequest;

import jp.metroengines.metrocheckin.R;
import jp.metroengines.metrocheckin.utils.HttpUtils;
import jp.metroengines.metrocheckin.utils.SPUtils;
import jp.metroengines.metrocheckin.widgets.MyProgressDialog;

/**
 * Created by mac on 2018/1/25.
 */

public class FaceHelper {

    private static final String API_KEY = "ByQCB3rygnP_OoSKRad0M0mOzVY4qaH4";
    private static final String API_SECRET = "4NAXpXS4PSJ5PCjahAO2kakBmhRVIbhF";

    private static final String DETECT_URL = "https://api-cn.faceplusplus.com/facepp/v3/detect";
    private static final String COMPARE_URL = "https://api-cn.faceplusplus.com/facepp/v3/compare";

    Context context;
    MyProgressDialog myProgressDialog;
    Gson gson;
    HttpUtils httpUtils;

    public FaceHelper(Context context){
        this.context = context;
        httpUtils = new HttpUtils(context);
        myProgressDialog = httpUtils.get_dialog();
        gson = httpUtils.get_gson();
    }

    public void detect_face(byte[] image, final HttpUtils.HttpRunnable runnable){
        myProgressDialog.show(context.getString(R.string.wait));
        String image_base64 = Base64.encodeToString(image,Base64.NO_WRAP);
        StringRequest request = new StringRequest(DETECT_URL, RequestMethod.POST);
        request.add("api_key", API_KEY);
        request.add("api_secret", API_SECRET);
        request.add("image_base64", image_base64);
        httpUtils.send(request, runnable);
    }

    public void compare_face(byte[] image, final HttpUtils.HttpRunnable runnable){
        myProgressDialog.show(context.getString(R.string.wait));
        String image_base64 = Base64.encodeToString(image,Base64.NO_WRAP);
        StringRequest request = new StringRequest(COMPARE_URL, RequestMethod.POST);
        request.add("api_key", API_KEY);
        request.add("api_secret", API_SECRET);
        request.add("image_base64_1", image_base64);
        request.add("face_token2", (String)SPUtils.get(context,SPUtils.PASSPORT_FACE_TOKEN,""));
        httpUtils.send(request, runnable);
    }

    public HttpUtils get_http_utils(){
        return httpUtils;
    }
}
