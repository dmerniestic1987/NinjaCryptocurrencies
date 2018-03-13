package ar.com.criptohugo.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import ar.com.criptohugo.Config.ConfigManager;
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

    @Override
    public void add(@Nullable Ticker object) {
        this.listTicker.add(object);
        super.add(object);
    }

    @Override
    public void clear() {
        this.listTicker = new ArrayList<>();
        super.clear();
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Ticker bean = listTicker.get(position);
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View itemView = inflater.inflate(R.layout.item_ticker_list, parent, false);
        TextView titleTicker = itemView.findViewById(R.id.titleTicker);
        titleTicker.setText(bean.getName());



        NumberFormat format = NumberFormat.getInstance(ConfigManager.getLocale());
        format.setMinimumFractionDigits(2);
        format.setMaximumFractionDigits(6);
        TextView valueUsdPrice = itemView.findViewById(R.id.valueUsdPrice);
        valueUsdPrice.setText(format.format(bean.getPriceUsdBigDecimal()));

        NumberFormat formatBtc = NumberFormat.getInstance(ConfigManager.getLocale());
        format.setMinimumFractionDigits(1);
        format.setMaximumFractionDigits(9);
        TextView valueBtcPrice = itemView.findViewById(R.id.valueBtcPrice);
        valueBtcPrice.setText(formatBtc.format(bean.getPriceBTCBigDecimal()));
        return itemView;
    }

    /**
     * Gets a ticket by position
     * @param position
     * @return ticker
     */
    public Ticker getTickerByPosition(Integer position){
        return this.listTicker.get(position);
    }
}
