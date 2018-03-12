package ar.com.criptohugo.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import ar.com.criptohugo.R;
import ar.com.criptohugo.adapter.TickerArrayAdapter;
import ar.com.criptohugo.bean.Ticker;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link TickerListFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link TickerListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TickerListFragment extends Fragment {
    private ListView listViewTicker;

    private OnFragmentInteractionListener mListener;
    private TickerArrayAdapter tickerArrayAdapter;
    public TickerListFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
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
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    public void onStart(){
        super.onStart();
        this.listViewTicker = this.getActivity().findViewById(R.id.listViewTicker);

        tickerArrayAdapter = new TickerArrayAdapter(getContext(), new ArrayList<Ticker>());
        listViewTicker.setAdapter(tickerArrayAdapter);

        listViewTicker.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

            }
        });

        HttpCallTickerListAsyncTask asyn = new HttpCallTickerListAsyncTask();
        asyn.execute();
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
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    private class HttpCallTickerListAsyncTask extends AsyncTask<Void, Void, List<Ticker>> {

        @Override
        protected List<Ticker> doInBackground(Void... voids) {
            Log.d("TickerList", "AsyncTask doInBackground");
            final String url = "https://api.coinmarketcap.com/v1/ticker/?limit=10";
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
            ResponseEntity<Ticker []> responseEntity = restTemplate.getForEntity(url, Ticker[].class);
            Ticker [] arrayTicker = responseEntity.getBody();
            List<Ticker> list = new ArrayList<>();
            for (int i = 0; i < arrayTicker.length; i++){
                list.add(arrayTicker[i]);
            }
            return list;
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
