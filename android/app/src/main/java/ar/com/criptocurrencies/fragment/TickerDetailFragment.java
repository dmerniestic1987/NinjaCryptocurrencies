package ar.com.criptocurrencies.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import ar.com.criptocurrencies.R;
import ar.com.criptocurrencies.bean.Ticker;


public class TickerDetailFragment extends Fragment {
    private Ticker ticker;
    private static String TAG = "TickerDetailFragment";

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
