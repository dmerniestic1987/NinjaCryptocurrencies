package ar.com.ninjacryptocurrencies.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.analytics.FirebaseAnalytics;

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

        TextView valueUsdPrice = view.findViewById(R.id.valueUsdPrice);
        valueUsdPrice.setText(this.ticker.getPriceUsd());

        TextView valueBtcPrice = view.findViewById(R.id.valueBtcPrice);
        valueBtcPrice.setText(this.ticker.getPriceBtc());

        TextView valueMarketCapUsd = view.findViewById(R.id.valueMarketCapUsd);
        valueMarketCapUsd.setText(this.ticker.getMarketCapUsd());

        TextView valueTotalSupply = view.findViewById(R.id.valueTotalSupply);
        valueTotalSupply.setText(this.ticker.getTotalSupply());

        TextView valueVol24hs = view.findViewById(R.id.valueVol24hs);
        valueVol24hs.setText(this.ticker.getV24hVolumeUsd());

        TextView valueMaxSupply = view.findViewById(R.id.valueMaxSupply);
        valueMaxSupply.setText(this.ticker.getMaxSupply());
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
