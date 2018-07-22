package ar.com.ninjacryptocurrencies.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import ar.com.ninjacryptocurrencies.R;
import ar.com.ninjacryptocurrencies.activity.NinjaCryptocurrenciesActivity;
import ar.com.ninjacryptocurrencies.bean.TallerNinjaBean;

/**
 * Fragment para el taller ninja. Simula una pantalla
 * para comenzar el proceso de compras de BitCoin o Ethereum
 */
public class TallerNinjaFragment extends Fragment implements View.OnClickListener{
    private static String TAG = "TallerNinjaFragment";

    private EditText editDocumento;
    private Switch switchComprarBitcoin;
    private Switch switchComprarEthereum;
    private Button buttonComenzarCompra;
    private ImageView imageViewTarjetaBitcoin;
    private NinjaCryptocurrenciesActivity activity;
    private TextView textErrorDocumento;


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
        this.imageViewTarjetaBitcoin = view.findViewById(R.id.imageViewTarjetaBitcoin);
        this.textErrorDocumento = view.findViewById(R.id.textErrorDocumento);
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

        this.editDocumento.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                textErrorDocumento.setVisibility(View.GONE);
            }

            @Override
            public void afterTextChanged(Editable editable) { }
        });

        //Seteamos las acciones con el click
        this.buttonComenzarCompra.setOnClickListener(this);

        this.imageViewTarjetaBitcoin.setOnClickListener(this);

    }

    /**
     * Compieza el proceso de compra de BitCoin o Ethereum
     */
    private void iniciarCompra(){
        Log.i(TAG, "iniciarCompra()");
        TallerNinjaBean bean = new TallerNinjaBean();
        bean.setComprarBitcoin(this.switchComprarBitcoin.isChecked());
        bean.setComprarEthereum(this.switchComprarEthereum.isChecked());
        bean.setDocumento(this.editDocumento.getText().toString());

        Log.i(TAG, bean.toString());

    }

    /**
     * Valida que la pantalla cuente con los datos correctos (Qw
     * @return
     */
    private boolean validateScreen(){
        String documento = this.editDocumento.getText().toString();
        if (documento == null || documento.trim().isEmpty()){
            this.textErrorDocumento.setVisibility(View.VISIBLE);
            return false;
        }

        return true;
    }

    /**
     * Realiza la operación cuando se hace click en algún elemento como el
     * botón comenzar compra o la imagen de las tarjetas de crédito
     * @param view
     */
    @Override
    public void onClick(View view) {
        Log.i(TAG, "click - " + view.getClass().getCanonicalName());
        if (validateScreen())
            iniciarCompra();
    }
}
