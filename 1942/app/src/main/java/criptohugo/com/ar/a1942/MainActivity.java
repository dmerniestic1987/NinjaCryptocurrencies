package criptohugo.com.ar.a1942;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText editText;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Nos fuimos de activtiy", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                Intent intent = new Intent(view.getContext(), ListExample01Activity.class);
                startActivity(intent);
            }

        });

        this.editText = (EditText) findViewById(R.id.editText);

        Context applicationContext = this.getApplicationContext();
        editText.append("Package Name: " + applicationContext.getPackageName() + "\n");
        editText.append("Data DIR: " + applicationContext.getApplicationInfo().dataDir + "\n");
        editText.append("Com DataDIR: " + applicationContext.getApplicationInfo().compatibleWidthLimitDp + "\n");

        Context context = this;
        editText.append("Package Name: " + context.getPackageName() + "\n");
        editText.append("Data DIR: " + context.getApplicationInfo().dataDir + "\n");
        editText.append("Com DataDIR: " + context.getApplicationInfo().compatibleWidthLimitDp + "\n");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
