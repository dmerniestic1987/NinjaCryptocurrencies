package ar.com.criptohugo;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_criptocurrencies:
                    mTextMessage.setText(R.string.title_criptocurrencies);
                    return true;
                case R.id.navigation_portfolio:
                    mTextMessage.setText(R.string.title_portfolio);
                    return true;
                case R.id.navigation_notices:
                    mTextMessage.setText(R.string.title_notices);
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

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

    }

}
