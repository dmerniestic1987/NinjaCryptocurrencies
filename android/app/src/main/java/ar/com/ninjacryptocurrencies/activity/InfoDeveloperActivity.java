package ar.com.ninjacryptocurrencies.activity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;
import com.google.firebase.analytics.FirebaseAnalytics;
import ar.com.ninjacryptocurrencies.R;

/**
 * Muestra la información del desarrollador con un WebView
 */
public class InfoDeveloperActivity extends AppCompatActivity {
    private WebView webViewInfoDeveloper;

    private FirebaseAnalytics firebaseAnalytics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_developer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle(getString(R.string.action_developer_info));

        firebaseAnalytics = FirebaseAnalytics.getInstance(this);
        logEventInfoDeveloper();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
                emailIntent.setData(Uri.parse(getString(R.string.mailto_info_developer)));

                try {
                    startActivity(emailIntent);
                } catch (ActivityNotFoundException e) {
                    Snackbar.make(view, getString(R.string.error_envio_main), Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            }
        });

        webViewInfoDeveloper = (WebView) this.findViewById(R.id.webInfoDeveloper);
        webViewInfoDeveloper.loadUrl(getString(R.string.url_info_developer));
    }

    /**
     * Registra un evento en Firebase
     */
    public void logEventInfoDeveloper(){
        firebaseAnalytics.logEvent("info_developer", null);
    }
}
