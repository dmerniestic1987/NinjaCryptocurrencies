package ar.com.ninjacryptocurrencies.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import ar.com.ninjacryptocurrencies.R;

public class NinjaTermConditionActivity extends AppCompatActivity implements View.OnClickListener{
    private Button aceptar, cancelar;
    private static String TAG = "NinjaTermsConditions";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ninja_term_condition);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        this.aceptar = this.findViewById(R.id.btn_aceptar_ninja);
        aceptar.setOnClickListener(this);

        this.cancelar = this.findViewById(R.id.btn_cancelar_ninja);
        cancelar.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_aceptar_ninja){
            aceptar();
            this.finish();
        }

        if (view.getId() == R.id.btn_cancelar_ninja){
            this.finish();
        }
    }

    /**
     * Realiza algo con el aceptar
     */
    private void aceptar() {
        Log.d(TAG, "Aceptar");
        Toast.makeText(this,"Ha aceptado los térmios y condiciones", Toast.LENGTH_LONG).show();
    }
}
