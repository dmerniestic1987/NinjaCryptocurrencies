package criptohugo.com.ar.a1942;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ListActivity2 extends AppCompatActivity {
    private ListView listView;
    private static final String TAG = "list2example";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });

        listView = (ListView) this.findViewById(R.id.listView);
        List<ExampleBean> examples = new ArrayList<>();
        examples.add(new ExampleBean("Windows", "Microsoft Windows"));
        examples.add(new ExampleBean("Linux", "GNU Linux"));
        examples.add(new ExampleBean("MacOS", "Apple MacOS"));
        examples.add(new ExampleBean("Android", "Google Android"));
        examples.add(new ExampleBean("FreeBSD", "Free BSD Foundation"));

        listView.setAdapter(new List2Adapter(this, examples));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Log.d(TAG, "PositioN: "  + position + " - id: " + id);
            }
        });
    }

}
