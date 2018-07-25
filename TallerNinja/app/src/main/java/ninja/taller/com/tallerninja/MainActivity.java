package ninja.taller.com.tallerninja;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Sarlanga Marlanga", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                Log.d("TAGTALLER", " CLICK EN SARLANGA MARLANGA");

                //Con esto abrimos un nuevo Activity
                Intent intent = new Intent(getBaseContext(), NuevoActivity.class);
                startActivity(intent);

            }
        });

        Log.d("TAGTALLER", " * * * *Estamos en onCreate()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("TAGTALLER", " * * * *Estamos en onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("TAGTALLER", " * * * *Estamos en onResume()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("TAGTALLER", " * * * *Estamos en onDestroy()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("TAGTALLER", " * * * *Estamos en onStop()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("TAGTALLER", " * * * *Estamos en onPause()");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);

        Log.d("TAGTALLER", "onCreateMenuOption ** ");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {

            Log.d("TAGTALLER", "CLICK EN SETTINGS ");
            return true;
        }


        return super.onOptionsItemSelected(item);
    }
}
