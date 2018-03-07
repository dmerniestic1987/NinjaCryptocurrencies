package ar.com.criptohugo;

import android.app.Fragment;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import ar.com.criptohugo.fragment.TickerListFragment;

public class MainActivity extends AppCompatActivity implements TickerListFragment.OnFragmentInteractionListener {
    private static final String TAG = "MainActivity";
    private TickerListFragment tikerListFragment;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_criptocurrencies:

                    return true;
                case R.id.navigation_portfolio:
                    return true;
                case R.id.navigation_notices:
                    return true;
            }
            return false;
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        Context context = getApplicationContext();
        CharSequence text = "";
        int duration = Toast.LENGTH_SHORT;



        if (id == R.id.action_developer_info) {
            Log.i(TAG, "developer info");
            Toast toast = Toast.makeText(context, R.string.action_developer_info, duration);
            toast.show();
            return true;
        }

        if (id == R.id.action_help) {
            Log.i(TAG, "Ayuda");
            Toast toast = Toast.makeText(context, R.string.action_help, duration);
            toast.show();
            return true;
        }

        if (id == R.id.action_terms_conditions) {
            Log.i(TAG, "Términos y Condiciones");
            Toast toast = Toast.makeText(context, R.string.action_terms_conditions, duration);
            toast.show();
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

        this.tikerListFragment = TickerListFragment.newInstance();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.container, this.tikerListFragment).commit();

    }

    public void onFragmentInteraction(Uri uri){

    }
}
