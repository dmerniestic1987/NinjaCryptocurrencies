package ar.com.criptohugo.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

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

        List<Ticker> listTickers = new ArrayList<>();
        listTickers.add(new Ticker("JFHF", "HOKJFLS"));
        listTickers.add(new Ticker(Long.toHexString(System.currentTimeMillis()), " hexa"));
        listTickers.add(new Ticker("dfasdf", "fadsfasd"));
        listTickers.add(new Ticker("dfadfa", "adfasdf"));
        listTickers.add(new Ticker(getContext().getPackageName(), "asdfasdf"));

        TickerArrayAdapter adapter = new TickerArrayAdapter(getContext(), listTickers);
        listViewTicker.setAdapter(adapter);

        listViewTicker.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
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
}
