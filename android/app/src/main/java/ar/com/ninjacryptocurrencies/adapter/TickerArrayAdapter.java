package ar.com.ninjacryptocurrencies.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.List;
import java.util.Locale;

import ar.com.ninjacryptocurrencies.R;
import ar.com.ninjacryptocurrencies.bean.Ticker;

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
    }

    @Override
    public void clear() {
        super.clear();
        this.listTicker.clear();
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Ticker bean = listTicker.get(position);
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View itemView;
        if (convertView == null){
            itemView = inflater.inflate(R.layout.item_ticker_list, parent, false);
        }
        else{
            itemView = convertView;
        }

        itemView.setId(bean.getId().hashCode());
        TextView titleTicker = itemView.findViewById(R.id.titleTicker);
        titleTicker.setText(bean.getName() + " (" + bean.getSymbol() + ")");

        NumberFormat format = NumberFormat.getCurrencyInstance(new Locale("es_AR"));
        format.setCurrency(Currency.getInstance("USD"));
        String result = format.format(bean.getPriceUsdBigDecimal());
        TextView valueUsdPrice = itemView.findViewById(R.id.valueUsdPrice);
        valueUsdPrice.setText(result);

        NumberFormat formatBtc = NumberFormat.getInstance(Locale.ENGLISH);
        format.setMinimumFractionDigits(1);
        format.setMaximumFractionDigits(9);
        TextView valueBtcPrice = itemView.findViewById(R.id.valueBtcPrice);
        valueBtcPrice.setText(formatBtc.format(bean.getPriceBTCBigDecimal()));


        TextView text1Hs = itemView.findViewById(R.id.text1hs);
        text1Hs.setText(bean.getPercentChange1h() + " %");
        text1Hs.setTextColor(ContextCompat.getColor(this.getContext(), R.color.greenPrimaryDark));
        if (bean.getPercentChange1h().startsWith("-")){
            text1Hs.setTextColor(ContextCompat.getColor(this.getContext(), R.color.red_warning));
        }

        TextView text24Hs = itemView.findViewById(R.id.text24hs);
        text24Hs.setText(bean.getPercentChange24h() + " %");
        text24Hs.setTextColor(ContextCompat.getColor(this.getContext(), R.color.greenPrimaryDark));
        if (bean.getPercentChange24h().startsWith("-")){
            text24Hs.setTextColor(ContextCompat.getColor(this.getContext(), R.color.red_warning));
        }


        TextView text7days = itemView.findViewById(R.id.text7days);
        text7days.setText(bean.getPercentChange7d() + " %");
        text7days.setTextColor(ContextCompat.getColor(this.getContext(), R.color.greenPrimaryDark));
        if (bean.getPercentChange7d().startsWith("-")){
            text7days.setTextColor(ContextCompat.getColor(this.getContext(), R.color.red_warning));
        }

        TextView textCirculating = itemView.findViewById(R.id.textCirculating);
        textCirculating.setText(bean.getAvailableSupply() + " (" + bean.getSymbol() + ")");
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
