package helloworld.ninja.taller.com.helloworldandroid;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Layout;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

/**
 * Main Activity: Ejemplo 01 para taller Ninja
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button botonMundo;
    private TextView textHello;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        this.setTitle("Mundo triste y gris");
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Con esta App. podés cambiar al mundo", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        this.textHello = this.findViewById(R.id.textHello);
        this.botonMundo = this.findViewById(R.id.botonMundo);
        this.botonMundo.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            Snackbar.make(null, "Con esta App. podés cambiar al mundo", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        this.textHello.setText("Hola MuNDo GeNiALL!!!!! :) :) :) :)");
        this.textHello.setTextColor(ContextCompat.getColor(this, android.R.color.holo_blue_light));
        this.botonMundo.setVisibility(View.GONE);
        this.setTitle("Mundo feliz con unicornios");
    }
}
