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
import com.google.firebase.analytics.FirebaseAnalytics;

import ar.com.ninjacryptocurrencies.R;

/**
 * Contiene le Fragment con las publicidades generadas con Firebase AdMob
 */
public class AdsFragment extends Fragment implements View.OnClickListener{
    private Button buttonPurpleNinja;
    private ImageView imagePurpleNinja;
    private AdView adView;
    private AdView adView2;

    private FirebaseAnalytics firebaseAnalytics;

    public AdsFragment() {
        super();
    }

    public static AdsFragment newInstance() {
        AdsFragment fragment = new AdsFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onStart() {
        super.onStart();
        MobileAds.initialize(getContext(), getString(R.string.admob_key_test_banner));
        firebaseAnalytics = FirebaseAnalytics.getInstance(getContext());

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
        return inflater.inflate(R.layout.fragment_ads, container, false);
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        firebaseAnalytics = FirebaseAnalytics.getInstance(getContext());
        firebaseAnalytics.logEvent("publicidades", null);
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

            Bundle params = new Bundle();
            params.putString("url_video", url);
            firebaseAnalytics.logEvent("video_ninja_purpura", params);
            startActivity(browserIntent);
        }
    }
}
