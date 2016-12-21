package com.example.mac.tabsapp.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.example.mac.tabsapp.Db.Categories;
import com.example.mac.tabsapp.Db.SpinnerData;
import com.example.mac.tabsapp.R;

import java.util.ArrayList;

/**
 * Created by mac on 9‏/12‏/2016.
 */

public class SpinnerAdapter extends ArrayAdapter<String> {

    private Context context;
    private ArrayList<SpinnerData> customers=new ArrayList<>();


    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return super.getView(position, convertView, parent);
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return super.getDropDownView(position, convertView, parent);
    }

    public SpinnerAdapter(Context context, int resource) {
        super(context, resource);
    }
}
