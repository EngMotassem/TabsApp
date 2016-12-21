package com.example.mac.tabsapp.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.mac.tabsapp.R;

/**
 * Created by mac on 9‏/12‏/2016.
 */

public class CustomerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private TextView customerName;
    private  TextView phone;
    ItemClickListner itemClickListner;

    public TextView getPhone() {
        return phone;
    }

    public void setPhone(TextView phone) {
        this.phone = phone;
    }

    public CustomerViewHolder(View itemView) {
        super(itemView);
        customerName= (TextView) itemView.findViewById(R.id.customername);
        phone= (TextView) itemView.findViewById(R.id.phoneNumber);


        itemView.setOnClickListener(this);

    }

    public TextView getCustomerName() {
        return customerName;
    }

    public void setCustomerName(TextView customerName) {
        this.customerName = customerName;
    }

    public ItemClickListner getItemClickListner() {
        return itemClickListner;
    }

    public void setItemClickListner(ItemClickListner itemClickListner) {
        this.itemClickListner = itemClickListner;
    }
    @Override
    public void onClick(View v) {
        this.itemClickListner.onItemClick(v,getLayoutPosition());

    }


}