package com.example.mac.tabsapp.Adapters;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mac.tabsapp.CustomerDetails;
import com.example.mac.tabsapp.Db.Customers;
import com.example.mac.tabsapp.Details;
import com.example.mac.tabsapp.R;

import java.util.ArrayList;

/**
 * Created by mac on 9‏/12‏/2016.
 */

public class CustomerAdapter extends RecyclerView.Adapter<CustomerViewHolder> {

    private ArrayList<Customers> customers=new ArrayList<>();
    private Context context;

    public CustomerAdapter(Context context, ArrayList<Customers> customers) {
        this.customers = customers;
        this.context = context;
    }

    @Override
    public CustomerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.customer_item,null);
         CustomerViewHolder holder=new CustomerViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(CustomerViewHolder holder, int position) {

     final  String customerName=customers.get(position).getName();
        final  String customerDetails=customers.get(position).getDes();
        final  String customerImageUrl=customers.get(position).getImageUrl();
        final  String customerLang=customers.get(position).getLang();
        final  String customerLa=customers.get(position).getLat();
        final  String customerPhone=customers.get(position).getPhone();
        //final  String customerAdress=customers.get(position).geta


        holder.getCustomerName().setText(customerName);
        holder.getPhone().setText(customerPhone);
        holder.setItemClickListner(new ItemClickListner() {
            @Override
            public void onItemClick(View v, int pos) {
                Intent i;
                i = new Intent(context,CustomerDetails.class);
                i.putExtra("name",customerName);
                i.putExtra("details",customerDetails);

                i.putExtra("phone",customerPhone);
                context.startActivity(i);
            }
        });


    }

    @Override
    public int getItemCount() {
        return customers.size();
    }
}
