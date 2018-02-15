package jp.metroengines.metrocheckin.helper;

import android.content.Context;
import android.os.Looper;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.location.places.AutocompleteFilter;
import com.google.android.gms.location.places.AutocompletePrediction;
import com.google.android.gms.location.places.AutocompletePredictionBuffer;
import com.google.android.gms.location.places.Places;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.gson.Gson;
import com.yanzhenjie.nohttp.NoHttp;
import com.yanzhenjie.nohttp.rest.StringRequest;

import jp.metroengines.metrocheckin.utils.HttpUtils;

/**
 * Created by mac on 2018/2/14.
 */

public class MapHelper {

    private Context context;
    private Gson gson;
    private GoogleApiClient mGoogleApiClient;

    public MapHelper(Context context, Gson gson, GoogleApiClient mGoogleApiClient) {
        this.context = context;
        this.gson = gson;
        this.mGoogleApiClient = mGoogleApiClient;
        NoHttp.initialize(context);
    }

    public void getLatLng(final String place, final HttpUtils.HttpRunnable runnable) {
        new Thread(new Runnable() {
            @Override
            public void run() {

                PendingResult<AutocompletePredictionBuffer> result =
                        Places.GeoDataApi.getAutocompletePredictions(mGoogleApiClient, place,
                                new LatLngBounds(new LatLng(0, 0), new LatLng(0, 0)),
                                new AutocompleteFilter.Builder()
                                        .setTypeFilter(AutocompleteFilter.TYPE_FILTER_NONE)
                                        .build());
                AutocompletePredictionBuffer await = result.await();
                AutocompletePrediction autocompletePrediction = null;
                try {
                    autocompletePrediction = await.get(0);
                } catch (Exception e) {

                }
                if (autocompletePrediction != null) {
                    String placeId = autocompletePrediction.getPlaceId();
                    StringRequest request = new StringRequest(getUrl(placeId));
                    Looper.prepare();
                    new HttpUtils(context, gson).send_quiet(request, runnable);
                    Looper.loop();
                }
                await.release();
            }
        }).start();
    }

    private String getUrl(CharSequence place_id) {
        return "https://maps.googleapis.com/maps/api/geocode/json?place_id=" + place_id + "&key=AIzaSyCLSlofDIbscXXCR734DMLmzgFKt_A5f6E";
    }
}
