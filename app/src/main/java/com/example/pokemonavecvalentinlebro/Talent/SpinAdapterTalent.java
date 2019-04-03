package com.example.pokemonavecvalentinlebro.Talent;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class SpinAdapterTalent extends ArrayAdapter<Talent> {

    // Your sent context
    private Context context;
    // Your custom values for the spinner (User)
    private ArrayList<Talent> talents;

    public SpinAdapterTalent(Context context, int textViewResourceId,
                       ArrayList<Talent> talents) {
        super(context, textViewResourceId, talents);
        this.context = context;
        this.talents = talents;
    }

    @Override
    public int getCount(){
        return talents.size();
    }

    @Override
    public Talent getItem(int position){
        return this.talents.get(position);
    }

    @Override
    public long getItemId(int position){
        return position;
    }


    // And the "magic" goes here
    // This is for the "passive" state of the spinner
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // I created a dynamic TextView here, but you can reference your own  custom layout for each spinner item
        TextView label = (TextView) super.getView(position, convertView, parent);
        label.setTextColor(Color.BLACK);
        // Then you can get the current item using the values array (Users array) and the current position
        // You can NOW reference each method you has created in your bean object (User class)
        label.setText(this.talents.get(position).getName());

        // And finally return your dynamic (or custom) view for each spinner item
        return label;
    }

    // And here is when the "chooser" is popped up
    // Normally is the same view, but you can customize it if you want
    @Override
    public View getDropDownView(int position, View convertView,
                                ViewGroup parent) {
        TextView label = (TextView) super.getDropDownView(position, convertView, parent);
        label.setTextColor(Color.BLACK);
        label.setText(this.talents.get(position).getName());

        return label;
    }
}
