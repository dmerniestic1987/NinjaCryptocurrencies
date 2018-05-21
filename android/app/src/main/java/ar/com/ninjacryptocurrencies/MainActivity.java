package ar.com.ninjacryptocurrencies;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import ar.com.ninjacryptocurrencies.activity.InfoDeveloperActivity;
import ar.com.ninjacryptocurrencies.activity.SingInActivity;
import ar.com.ninjacryptocurrencies.fragment.CodeFragment;
import ar.com.ninjacryptocurrencies.fragment.PortfolioFragment;
import ar.com.ninjacryptocurrencies.fragment.TickerListFragment;

public class MainActivity extends AppCompatActivity implements TickerListFragment.OnFragmentInteractionListener {
    private static final String TAG = "MainActivity";
    private FirebaseAuth firebaseAuth;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment = null;
            switch (item.getItemId()) {
                case R.id.navigation_criptocurrencies:
                    fragment = TickerListFragment.newInstance();
                    break;
                case R.id.navigation_ads:
                    fragment = PortfolioFragment.newInstance();
                    break;
                case R.id.navigation_code:
                    fragment = CodeFragment.newInstance();
                    break;
                default:
                    fragment = TickerListFragment.newInstance();
                    break;
            }
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.main_container, fragment).commit();
            return true;
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;

        if (id == R.id.action_developer_info) {
            Log.i(TAG, "developer info");

            String url = getString(R.string.url_info_developer);
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(browserIntent);
            return true;
        }

        if (id == R.id.action_terms_conditions) {
            Log.i(TAG, "Términos y Condiciones");
            Toast toast = Toast.makeText(context, R.string.action_terms_conditions, duration);
            toast.show();
            return true;
        }

        if (id == R.id.signOut) {
            Log.i(TAG, getString(R.string.sign_out_option));
            firebaseAuth.signOut();
            goToSignInActivity();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.main_container, TickerListFragment.newInstance()).commit();

        firebaseAuth = FirebaseAuth.getInstance();
    }

    public void onFragmentInteraction(Uri uri){

    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser user = firebaseAuth.getCurrentUser();
        if (user == null){
            goToSignInActivity();
        }
    }

    private void goToSignInActivity() {
        Intent i = new Intent(this, SingInActivity.class);
        startActivity(i);
    }
}