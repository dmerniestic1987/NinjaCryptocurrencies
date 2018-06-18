package ar.com.ninjacryptocurrencies.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.analytics.FirebaseAnalytics;

import ar.com.ninjacryptocurrencies.BuildConfig;
import ar.com.ninjacryptocurrencies.R;

/**
 * Muestra la información de la aplicación.
 */
public class AboutAppActivity extends AppCompatActivity implements View.OnClickListener{
    private Button aceptar;
    private static String TAG = "AbooutApp";
    private TextView txt_app_version;
    private TextView txt_version_name;

    private FirebaseAnalytics firebaseAnalytics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_app);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        this.aceptar = this.findViewById(R.id.btn_aceptar_ninja);
        aceptar.setOnClickListener(this);

        this.txt_app_version = this.findViewById(R.id.txt_app_version);
        txt_app_version.setText(getString(R.string.display_app_version) + " " + String.valueOf(BuildConfig.VERSION_CODE));
        txt_version_name = this.findViewById(R.id.txt_version_name);
        txt_version_name.setText(getString(R.string.display_version_name) + " " + String.valueOf(BuildConfig.VERSION_NAME));

        firebaseAnalytics = FirebaseAnalytics.getInstance(this);
        logEventAbout();
    }

    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.btn_aceptar_ninja){
            Log.d(TAG, "About OK clicked");
            this.finish();
        }
    }

    /**
     * Registra un evento en Firebase
     */
    public void logEventAbout(){
        Bundle bundle = new Bundle();
        bundle.putString("version_code",  String.valueOf(BuildConfig.VERSION_CODE));
        bundle.putString("version_name",  String.valueOf(BuildConfig.VERSION_NAME));
        firebaseAnalytics.logEvent("about_app", bundle);
    }
}
