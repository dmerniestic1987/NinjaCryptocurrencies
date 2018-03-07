package ar.com.criptohugo.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ar.com.criptohugo.R;
import ar.com.criptohugo.bean.Ticker;

/**
 * Created by dmernies on 6/3/18.
 */

public class TickerArrayAdapter extends ArrayAdapter<Ticker> {
    private List<Ticker> listTicker;
    private Context context;

    public TickerArrayAdapter(@NonNull Context context, @NonNull List<Ticker> objects) {
        super(context, -1, objects);
        this.listTicker = objects;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Ticker bean = listTicker.get(position);
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View itemView = inflater.inflate(R.layout.item_ticker_list_layout, parent, false);
        TextView firstLine = itemView.findViewById(R.id.firstLine);
        firstLine.setText(bean.getFirstLine());

        TextView secondLine = itemView.findViewById(R.id.secondLine);
        secondLine.setText(bean.getSecondLine());

        return itemView;
    }
}
