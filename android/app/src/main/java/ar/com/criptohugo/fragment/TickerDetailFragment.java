package ar.com.criptohugo.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ticker_detail, container, false);
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
