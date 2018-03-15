package ar.com.criptohugo.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import ar.com.criptohugo.R;
import ar.com.criptohugo.bean.Ticker;


public class TickerDetailFragment extends Fragment {
    private Ticker ticker;

    public TickerDetailFragment() {
        super();
    }

    /**
     * Obtiene una nueva instancia del fragment
     * @param ticker
     * @return fragment instance of TickerDetailFragment
     */
    public static TickerDetailFragment newInstance(Ticker ticker) {
        TickerDetailFragment fragment = new TickerDetailFragment();
        fragment.setTicker(ticker);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
        TextView nameTickerDetail = this.getActivity().findViewById(R.id.nameTickerDetail);
        nameTickerDetail.setText(this.ticker.getName());

        TextView symbolTickerDetail = this.getActivity().findViewById(R.id.symbolTickerDetail);
        symbolTickerDetail.setText(this.ticker.getSymbol());

        TextView valueUsdPrice = this.getActivity().findViewById(R.id.valueUsdPrice);
        valueUsdPrice.setText(this.ticker.getPriceUsd());

        TextView valueBtcPrice = this.getActivity().findViewById(R.id.valueBtcPrice);
        valueBtcPrice.setText(this.ticker.getPriceBtc());

        TextView valueMarketCapUsd = this.getActivity().findViewById(R.id.valueMarketCapUsd);
        valueMarketCapUsd.setText(this.ticker.getMarketCapUsd());

        TextView valueTotalSupply = this.getActivity().findViewById(R.id.valueTotalSupply);
        valueTotalSupply.setText(this.ticker.getTotalSupply());

        TextView valueVol24hs = this.getActivity().findViewById(R.id.valueVol24hs);
        valueVol24hs.setText(this.ticker.getV24hVolumeUsd());

        TextView valueMaxSupply = this.getActivity().findViewById(R.id.valueMaxSupply);
        valueMaxSupply.setText(this.ticker.getMaxSupply());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View viewFragmentDetail = inflater.inflate(R.layout.fragment_ticker_detail, container, false);


        return viewFragmentDetail;
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    public Ticker getTicker() {
        return ticker;
    }

    public void setTicker(Ticker ticker) {
        this.ticker = ticker;
    }
}
