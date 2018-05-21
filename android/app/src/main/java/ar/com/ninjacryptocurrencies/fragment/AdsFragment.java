package ar.com.ninjacryptocurrencies.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import ar.com.ninjacryptocurrencies.R;

public class AdsFragment extends Fragment implements View.OnClickListener{
    private Button buttonPurpleNinja;
    private ImageView imagePurpleNinja;
    private AdView adView;
    private AdView adView2;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    public AdsFragment() {

    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AdsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AdsFragment newInstance(String param1, String param2) {
        AdsFragment fragment = new AdsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public static AdsFragment newInstance() {
        AdsFragment fragment = new AdsFragment();
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

    @Override
    public void onStart() {
        super.onStart();
        MobileAds.initialize(getContext(), getString(R.string.admob_key_test_banner));
        this.buttonPurpleNinja = this.getActivity().findViewById(R.id.buttonPurpleNinja);
        this.buttonPurpleNinja.setOnClickListener(this);

        this.imagePurpleNinja = this.getActivity().findViewById(R.id.imagePurpleNinja);
        this.imagePurpleNinja.setOnClickListener(this);

        adView = this.getActivity().findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);

        adView2 = this.getActivity().findViewById(R.id.adView2);
        AdRequest adRequest2 = new AdRequest.Builder().build();
        adView2.loadAd(adRequest2);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ads, container, false);
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.buttonPurpleNinja || view.getId() == R.id.imagePurpleNinja){
            String url = getString(R.string.url_ninja_purpura_youtube);
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(browserIntent);
        }
    }
}
