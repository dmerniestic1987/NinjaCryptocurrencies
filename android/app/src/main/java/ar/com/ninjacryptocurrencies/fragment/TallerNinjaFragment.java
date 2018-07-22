package ar.com.ninjacryptocurrencies.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;

import ar.com.ninjacryptocurrencies.R;
import ar.com.ninjacryptocurrencies.activity.NinjaCryptocurrenciesActivity;

/**
 * Fragment para el taller ninja. Simula una pantalla
 * para comenzar el proceso de compras de BitCoin o Ethereum
 */
public class TallerNinjaFragment extends Fragment {
    private static String TAG = "TallerNinjaFragment";

    private EditText editDocumento;
    private Switch switchComprarBitcoin;
    private Switch switchComprarEthereum;
    private Button buttonComenzarCompra;
    private NinjaCryptocurrenciesActivity activity;


    public TallerNinjaFragment() {
        super();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate: Creación inicial del fragment ");

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.i(TAG, "onAttach: Se llama una vez después de asociar el Fragment al Activity");
        this.activity = (NinjaCryptocurrenciesActivity) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_taller_ninja, container, false);
        Log.i(TAG, "onCreateView - Crea y carga la jerarquía de vistas del fragment");
        this.editDocumento = view.findViewById(R.id.editDocumento);
        this.switchComprarBitcoin = view.findViewById(R.id.switchComprarBitcoin);
        this.switchComprarEthereum = view.findViewById(R.id.switchComprarEthereum);
        this.buttonComenzarCompra = view.findViewById(R.id.buttonComenzarCompra);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i(TAG,"onStart(): Hace el Fragment visible al usuario. El Activity conteneder está started");

    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i(TAG, "onResume(): Hace que el Fragment empiece a interactuar con el usuario. Activity contenedor resumed");

        //Seteamos las acciones con el click
        this.buttonComenzarCompra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(TAG, "click - buttonComenzarCompra");
                iniciarCompra();
            }
        });
    }

    /**
     * Compieza el proceso de compra de BitCoin o Ethereum
     */
    private void iniciarCompra(){

    }
}
