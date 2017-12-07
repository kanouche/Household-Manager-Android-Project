package com.techobbyist.HouseHold;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by dell on 05/12/2017.
 */

public class ItemsList extends ArrayAdapter<Item> {
    private int layoutResourceId;
    ArrayList<Item> items;
    Context context;

    public ItemsList(Context context, int textViewResourceId) {
        super(context, textViewResourceId);
        layoutResourceId = textViewResourceId;
    }
    public ItemsList(Context context, int resource, ArrayList<Item> items) {
        super(context, resource, items);
        this.context=context;


    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

            Item item = getItem(position);
            View v = null;
            if (convertView == null) {
                LayoutInflater vi;
                vi = LayoutInflater.from(getContext());
                v = vi.inflate(R.layout.items_list, null);

            } else {
                v = convertView;
            }
            TextView itemName = (TextView) v.findViewById(R.id.itemname);
            TextView itemQuantity = (TextView) v.findViewById(R.id.itemquantity);
            itemName.setText(item.getName());
            itemQuantity.setText("Quantity : "+ item.getQuantity());
        return v;

    }

}

