package com.go.customizelistview.Utility;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.go.customizelistview.R;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {

    Context context;
    public static ArrayList<Product> array_list;

    public CustomAdapter(Context context, ArrayList<Product> array_list) {
        this.array_list = array_list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return array_list.size();
    }

    @Override
    public Object getItem(int i) {
        return array_list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final ViewHolder holder;
        final String [] quantity = {"1", "2", "3", "4", "5"};

        Product product = array_list.get(i);
        if (view == null) {
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.list_item, null, true);

            holder.tv_name = view.findViewById(R.id.textView_name);
            holder.tv_weight = view.findViewById(R.id.textView_weight);
            holder.tv_price = view.findViewById(R.id.textView_price);
            holder.sp_quantity = view.findViewById(R.id.spinner_quantity);
            holder.cb_buy = view.findViewById(R.id.checkBox_buy);
            holder.iv_image = view.findViewById(R.id.imageView_image);

            view.setTag(holder);
        } else {
            // the getTag returns the viewHolder object set as a tag to the view
            holder = (ViewHolder) view.getTag();
        }

        int id = context.getResources().getIdentifier(array_list.get(i).getImage(), "drawable", context.getPackageName());
        holder.iv_image.setImageResource(id);

        holder.tv_name.setText(array_list.get(i).getName());
        holder.tv_weight.setText(array_list.get(i).getWeight());
        holder.tv_price.setText("S/." + String.valueOf(array_list.get(i).getPrice()));

        // holder.cb_buy.setText("Checkbox " + i);
        holder.cb_buy.setChecked(array_list.get(i).getChecked());
        holder.cb_buy.setTag(i);
        holder.cb_buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer position = (Integer)  holder.cb_buy.getTag();

                if (array_list.get(position).getChecked()) {
                    array_list.get(position).setChecked(false);
                } else {
                    array_list.get(position).setChecked(true);
                }
            }
        });

        holder.sp_quantity.setAdapter(new ArrayAdapter<String>(context, android.R.layout.simple_spinner_dropdown_item, quantity));
        holder.sp_quantity.setTag(i);
        holder.sp_quantity.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Integer position = (Integer)  holder.sp_quantity.getTag();
                array_list.get(position).setQuantity(Integer.parseInt(quantity[i]));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        return view;
    }

    private class ViewHolder {
        private TextView tv_name;
        private TextView tv_weight;
        private TextView tv_price;
        private Spinner sp_quantity;
        private CheckBox cb_buy;
        private ImageView iv_image;
    }

    /* @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Product package_ = array_list.get(i);
        if (view == null) {
            LayoutInflater layout_inflater = LayoutInflater.from(context);
            view = layout_inflater.inflate(R.layout.list_item, null);

            ImageView iv_image = view.findViewById(R.id.imageView_image);
            TextView tv_name = view.findViewById(R.id.textView_name);
            TextView tv_weight = view.findViewById(R.id.textView_weight);
            TextView tv_price = view.findViewById(R.id.textView_price);
            Spinner sp_quantity = view.findViewById(R.id.spinner_quantity);

            tv_name.setText(package_.getName());
            tv_weight.setText(package_.getWeight());
            tv_price.setText("S/." + package_.getPrice());

            final String [] quantity = {"1", "2", "3", "4", "5"};
            sp_quantity.setAdapter(new ArrayAdapter<String>(context, android.R.layout.simple_spinner_dropdown_item, quantity));
        }
        return view;
    } */
}
