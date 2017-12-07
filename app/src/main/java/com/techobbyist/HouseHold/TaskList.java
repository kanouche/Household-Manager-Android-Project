package com.techobbyist.HouseHold;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by dell on 05/12/2017.
 */

public class TaskList extends ArrayAdapter<Task> {
    private int layoutResourceId;
    ArrayList<Task> tasks;
    Context context;

    public TaskList(Context context, int textViewResourceId) {
        super(context, textViewResourceId);
        layoutResourceId = textViewResourceId;
    }
    public TaskList(Context context, int resource, ArrayList<Task> tasks) {
        super(context, resource, tasks);
        this.context=context;


    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

            Task task = getItem(position);
            View v = null;
            if (convertView == null) {
                LayoutInflater vi;
                vi = LayoutInflater.from(getContext());
                v = vi.inflate(R.layout.task_list, null);

            } else {
                v = convertView;
            }
            TextView taskname = (TextView) v.findViewById(R.id.taskname);
            TextView personname = (TextView) v.findViewById(R.id.personname);
            TextView deadline = (TextView) v.findViewById(R.id.deadline);
            TextView requiredtools = (TextView) v.findViewById(R.id.requiredtools);
            TextView notes = (TextView) v.findViewById(R.id.note);

            /*
            if(task.getpersonName()=="M"){
                iconImage.setImageResource(context.getResources().getIdentifier("male","drawable","com.package.application"));
            }
            else{
                iconImage.setImageResource(context.getResources().getIdentifier("female","drawable","com.package.application"));

            }
            */
            taskname.setText(task.gettaskName());
            personname.setText("Task assigned to : "+ task.getpersonName());
            deadline.setText("Task due to :"+task.getDeadline());
            requiredtools.setText("USE :"+task.getRequiredItems());
            notes.setText("notes :"+task.getNote());



        return v;

    }

}

