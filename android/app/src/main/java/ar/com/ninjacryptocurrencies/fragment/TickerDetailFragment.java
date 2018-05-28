package ar.com.ninjacryptocurrencies.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.analytics.FirebaseAnalytics;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

import ar.com.ninjacryptocurrencies.R;
import ar.com.ninjacryptocurrencies.analytics.CryptoCurrenciesAnalytics;
import ar.com.ninjacryptocurrencies.bean.Ticker;


public class TickerDetailFragment extends Fragment {
    private Ticker ticker;
    private static String TAG = "TickerDetailFragment";
    private FirebaseAnalytics firebaseAnalytics;

    public TickerDetailFragment() {
        super();
    }

    /**
     * Obtiene una nueva instancia del fragment
     * @return fragment instance of TickerDetailFragment
     */
    public static TickerDetailFragment newInstance() {
        TickerDetailFragment fragment = new TickerDetailFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate - Saco Ticker de Argumentos");
        super.onCreate(savedInstanceState);
        this.ticker = (Ticker) this.getArguments().getSerializable("ticker");

        firebaseAnalytics = FirebaseAnalytics.getInstance(getContext());
        Bundle bundle = new Bundle();
        bundle.putString(FirebaseAnalytics.Param.ITEM_CATEGORY, CryptoCurrenciesAnalytics.CRYPTOCURRENCIES_CATEGORY);
        bundle.putString(FirebaseAnalytics.Param.ITEM_ID, this.ticker.getId());
        bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, this.ticker.getName());

        firebaseAnalytics.logEvent(FirebaseAnalytics.Event.VIEW_ITEM, bundle);

    }


    private void updateScreen(View view) {
        TextView nameTickerDetail = view.findViewById(R.id.nameTickerDetail);
        nameTickerDetail.setText(this.ticker.getName());

        TextView symbolTickerDetail = view.findViewById(R.id.symbolTickerDetail);
        symbolTickerDetail.setText(this.ticker.getSymbol());

        NumberFormat format = NumberFormat.getCurrencyInstance(new Locale("es_AR"));
        format.setCurrency(Currency.getInstance("USD"));

        //************ PRICE USD
        String priceUsd = "";
        if (this.ticker.getPriceUsd() != null)
            priceUsd = format.format(new BigDecimal(this.ticker.getPriceUsd()));

        TextView valueUsdPrice = view.findViewById(R.id.valueUsdPrice);
        valueUsdPrice.setText(priceUsd);

        //************ PRICE BTC
        TextView valueBtcPrice = view.findViewById(R.id.valueBtcPrice);
        valueBtcPrice.setText(this.ticker.getPriceBtc());

        //*********** CAPITAL MARKET
        String marketCapUsd = "";
        if (this.ticker.getMarketCapUsd() != null)
            marketCapUsd = format.format(new BigDecimal(this.ticker.getMarketCapUsd()));

        TextView valueMarketCapUsd = view.findViewById(R.id.valueMarketCapUsd);
        valueMarketCapUsd.setText(marketCapUsd);

        //*********** VOL 24 HS
        String vol24hs = "";
        if (this.ticker.getV24hVolumeUsd() != null)
            vol24hs = format.format(new BigDecimal(this.ticker.getV24hVolumeUsd()));

        TextView valueVol24hs = view.findViewById(R.id.valueVol24hs);
        valueVol24hs.setText(vol24hs);

        //*********** CIRCULACION
        format = NumberFormat.getInstance(new Locale("es_AR"));
        String totalSupply = "";
        if (this.ticker.getTotalSupply() != null){
            totalSupply = format.format(new BigDecimal(this.ticker.getTotalSupply()));
        }
        TextView valueTotalSupply = view.findViewById(R.id.valueTotalSupply);
        valueTotalSupply.setText(totalSupply + " " + this.ticker.getSymbol());

        //*********** CANTIDAD MAXIMA
        String maxSupply = "";
        if (this.ticker.getMaxSupply() != null){
            maxSupply = format.format(new BigDecimal(this.ticker.getMaxSupply()));
        }
        TextView valueMaxSupply = view.findViewById(R.id.valueMaxSupply);
        valueMaxSupply.setText(maxSupply + " " + this.ticker.getSymbol());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView - Inflo layout");
        View viewFragmentDetail = inflater.inflate(R.layout.fragment_ticker_detail, container, false);
        updateScreen(viewFragmentDetail);
        return viewFragmentDetail;
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
