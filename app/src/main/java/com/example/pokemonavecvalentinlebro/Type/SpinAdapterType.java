package com.example.pokemonavecvalentinlebro.Type;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class SpinAdapterType extends ArrayAdapter<Type> {

    // Your sent context
    private Context context;
    // Your custom values for the spinner (User)
    private ArrayList<Type> types;

    public SpinAdapterType(Context context, int textViewResourceId,
                             ArrayList<Type> types) {
        super(context, textViewResourceId, types);
        this.context = context;
        this.types = types;
    }

    @Override
    public int getCount(){
        return types.size();
    }

    @Override
    public Type getItem(int position){
        return this.types.get(position);
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
        label.setText(this.types.get(position).getName());

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
        label.setText(this.types.get(position).getName());

        return label;
    }
}
