package ar.com.ninjacryptocurrencies.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.firebase.analytics.FirebaseAnalytics;

import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ar.com.ninjacryptocurrencies.R;
import ar.com.ninjacryptocurrencies.adapter.TickerArrayAdapter;
import ar.com.ninjacryptocurrencies.analytics.CryptoCurrenciesAnalytics;
import ar.com.ninjacryptocurrencies.bean.Ticker;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link TickerListFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link TickerListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TickerListFragment extends Fragment {
    private static final String TAG = "TickerListFragment";

    private ListView listViewTicker;
    private OnFragmentInteractionListener mListener;
    private TickerArrayAdapter tickerArrayAdapter;

    private FirebaseAnalytics firebaseAnalytics;

    public TickerListFragment() {
        super();
    }

    /**
     * Factory to create a new TickerListFragment
     *
     * @return A new instance of fragment TickerListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TickerListFragment newInstance() {
        TickerListFragment fragment = new TickerListFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate - clean ListTickerManager");
        super.onCreate(savedInstanceState);

        firebaseAnalytics = FirebaseAnalytics.getInstance(getContext());
        Bundle bundle = new Bundle();
        bundle.putString(FirebaseAnalytics.Param.ITEM_CATEGORY, CryptoCurrenciesAnalytics.CRYPTOCURRENCIES_CATEGORY);
        firebaseAnalytics.logEvent(FirebaseAnalytics.Event.VIEW_ITEM_LIST, bundle);
    }

    public void onStart(){
        super.onStart();
        this.listViewTicker = this.getActivity().findViewById(R.id.listViewTicker);

        tickerArrayAdapter = new TickerArrayAdapter(getContext(), new ArrayList<Ticker>());
        listViewTicker.setAdapter(tickerArrayAdapter);

        HttpCallTickerListAsyncTask asyncTas = new HttpCallTickerListAsyncTask();
        asyncTas.execute();

        listViewTicker.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Ticker ticker = tickerArrayAdapter.getTickerByPosition(position);
                TickerDetailFragment detailFragment = TickerDetailFragment.newInstance();

                Bundle tickerBundle = new Bundle();
                tickerBundle.putSerializable("ticker", ticker);
                detailFragment.setArguments(tickerBundle);

                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.container, detailFragment);
                transaction.commit();

            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_ticker_list, container, false);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * Inteface
     */
    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }


    /**
     * Clase que llama a la consulta de tickers
     */
    private class HttpCallTickerListAsyncTask extends AsyncTask<Void, Void, List<Ticker>> {

        @Override
        protected List<Ticker> doInBackground(Void... voids) {
            Log.d("TickerList", "AsyncTask doInBackground");
            final String url = getString(R.string.url_request_capCoinMarket);
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
            ResponseEntity<Ticker []> responseEntity = restTemplate.getForEntity(url, Ticker[].class);

            Ticker [] arrayTicker = responseEntity.getBody();
            return Arrays.asList(arrayTicker);
        }

        @Override
        protected void onPostExecute(List<Ticker> tickers) {
            super.onPostExecute(tickers);

            Log.d("TickerList", "AsyncTask onPostExecute - Tickers: " + tickers.size());
            tickerArrayAdapter.clear();
            for (Ticker ticker : tickers){
                tickerArrayAdapter.add(ticker);
            }
            tickerArrayAdapter.notifyDataSetChanged();
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Log.d("TickerList", "AsyncTask o PreExecute");
        }
    }
}
