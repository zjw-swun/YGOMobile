package cn.garymb.ygomobile.plus.spinner;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;
import android.widget.TextView;

import cn.garymb.ygomobile.lite.R;
import cn.garymb.ygomobile.plus.BaseAdapterPlus;


public class SimpleSpinnerAdapter extends BaseAdapterPlus<SimpleSpinnerItem> {
    private int color;

    public SimpleSpinnerAdapter(Context context) {
        super(context);
        color = context.getResources().getColor(R.color.colorPrimaryDark);
    }

    public void setColor(int color) {
        this.color = color;
    }

    @Override
    protected View createView(int position, ViewGroup parent) {
        View view = inflate(android.R.layout.simple_list_item_1, null);
        TextView textView = (TextView) view.findViewById(android.R.id.text1);
        view.setTag(textView);
        return view;
    }

    @Override
    protected void attach(View view, SimpleSpinnerItem item, int position) {
        TextView textView = (TextView) view.getTag();
        textView.setTextColor(color);
        textView.setMaxLines(2);
        if (item != null) {
            textView.setText(item.toString());
        }
    }

    public static Object getSelectTag(Spinner spinner) {
        if (spinner.getCount() > 0) {
            Object item = spinner.getSelectedItem();
            if (item != null && item instanceof SimpleSpinnerItem) {
                SimpleSpinnerItem spItem = (SimpleSpinnerItem) item;
                return spItem.tag;
            }
        }
        return null;
    }

    public static long getSelect(Spinner spinner) {
        if (spinner.getCount() > 0) {
            Object item = spinner.getSelectedItem();
            if (item != null && item instanceof SimpleSpinnerItem) {
                SimpleSpinnerItem spItem = (SimpleSpinnerItem) item;
                return spItem.value;
            }
        }
        return 0;
    }
}
