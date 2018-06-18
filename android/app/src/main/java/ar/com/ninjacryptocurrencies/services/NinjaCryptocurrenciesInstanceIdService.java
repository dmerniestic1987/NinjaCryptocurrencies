package ar.com.ninjacryptocurrencies.services;

import android.util.Log;

import com.crashlytics.android.Crashlytics;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Servicio que obtiene el Token para recibir notificaciones
 * @author dmernies
 */
public class NinjaCryptocurrenciesInstanceIdService extends FirebaseInstanceIdService {
    private String token;
    private String id;
    private static final String TAG = "CRYPTO_InstanceIdServ";
    public NinjaCryptocurrenciesInstanceIdService() {
        super();
    }

    @Override
    public void onTokenRefresh() {
        super.onTokenRefresh();
        this.token = FirebaseInstanceId.getInstance().getToken();
        this.id = FirebaseInstanceId.getInstance().getId();
        Log.i(TAG, "onTokenRefresh()");
    }
}
