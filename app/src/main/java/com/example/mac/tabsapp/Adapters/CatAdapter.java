package com.example.mac.tabsapp.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mac.tabsapp.Db.Categories;
import com.example.mac.tabsapp.R;
import com.example.mac.tabsapp.CategoryCustomer;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by mac on 9‏/12‏/2016.
 */

public class CatAdapter extends RecyclerView.Adapter<CatViewHolder> {

    private ArrayList<Categories> customers=new ArrayList<>();
    private Context context;

    public CatAdapter(Context context, ArrayList<Categories> customers) {
        this.customers = customers;
        this.context = context;
    }

    @Override
    public CatViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.cat_item,null);
        CatViewHolder holder=new CatViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(CatViewHolder holder, int position) {

        final  String customerName=customers.get(position).getName();
        final  String customerDetails=customers.get(position).getDes();
        final  String customerImageUrl=customers.get(position).getImageUrl();
        final int catId=customers.get(position).getId();


        Picasso.with(context).
                load(customerImageUrl).
                resize(150, 150).
                placeholder(R.drawable.common_full_open_on_phone).
                into(holder.getCatImage());

        holder.getCatName().setText(customerName);


       holder.setItemClickListner(new CatViewHolder.ItemClickListner() {
           @Override
           public void onItemClick(View v, int pos) {
               Intent i=new Intent(context,CategoryCustomer.class);
               i.putExtra("id",catId);
               context.startActivity(i);
           }
       });

    }

    @Override
    public int getItemCount() {
        return customers.size();
    }
}
