package com.techobbyist.HouseHold;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * Created by Ramzy on 2017-11-25.
  */

public class Tab2Fragment extends Fragment{
    private static final String TAG = "Tab2Fragment";
    ArrayList<Task> menuTasks = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.tab2_fragment, container, false);
        fillList();
        TaskList tasklistadapter = new TaskList(getActivity(), R.layout.task_list, menuTasks );
        ListView lv = (ListView) view.findViewById(R.id.taskslistview);
        lv.setAdapter(tasklistadapter);
        return view;
    }

    public void onTabsClick(View view) {
        Context context = Tab2Fragment.this.getActivity();
        Intent intent = new Intent(context, addnewtask.class);
        startActivity(intent);
    }

    public void fillList(){
        DataBaseHelper db = new DataBaseHelper(getActivity());
        menuTasks=db.getAllTasks();

    }

}

