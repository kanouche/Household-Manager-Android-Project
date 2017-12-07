package com.techobbyist.HouseHold;

import android.content.ContentValues;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.content.Intent;
import android.widget.Toast;
import android.widget.ArrayAdapter;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Ramzy on 2017-11-26.
 */

public class Tab1Fragment extends Fragment {
    private static final String TAG = "Tab1Fragment";


    private ArrayList<Item> shopping_list = new ArrayList<Item>() ;
    private EditText itemname,quantity;
    private ImageButton additem;

    private DataBaseHelper helper;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.tab1_fragment, container, false);
        fillItemList();
        additem = (ImageButton) view.findViewById(R.id.Additem);
        itemname = (EditText) view.findViewById(R.id.Itemname);
        quantity=(EditText) view.findViewById(R.id.itemquantity);
        additem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch(view.getId()){
                    case R.id.Additem:
                        additem();
                        break;
                }
            }
        });
        helper=new DataBaseHelper(getActivity());
        return view;
    }

    private void additem(){
        String nameStr = itemname.getText().toString();
        String quantityStr=quantity.getText().toString();
        Item i=new Item(nameStr,quantityStr);
        if(nameStr.isEmpty())
        {
            displayToast("Name  field empty");
        }

        else{
            helper.insertitem(i);
            displayToast("the item has been added succesfully !");
        }
    }

    private void displayToast(String message){
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }


    public void fillItemList(){
        DataBaseHelper db = new DataBaseHelper(getActivity());
        shopping_list=db.getAllItem();

    }





}
