package criptohugo.com.ar.a1942;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by dmernies on 4/3/18.
 */

public class List2Adapter extends ArrayAdapter<ExampleBean> {
    private Context context;
    private List<ExampleBean> values;

    public List2Adapter(Context context, List<ExampleBean> values) {
        super(context, -1, values);
        this.context = context;
        this.values = values;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ExampleBean bean = values.get(position);
        LayoutInflater inflater = (LayoutInflater) context
                                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View itemView = inflater.inflate(R.layout.item_example_list_layout, parent, false);
        TextView firstLine = itemView.findViewById(R.id.firstLine);
        firstLine.setText(bean.getFirstLine());

        TextView secondLine = itemView.findViewById(R.id.secondLine);
        secondLine.setText(bean.getSecondLine());

        return itemView;
    }
}
