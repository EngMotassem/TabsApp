package com.example.mac.tabsapp;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

//import com.example.mac.tabsapp.Db.ProductDownloader;

import com.example.mac.tabsapp.Db.Customers;
import com.example.mac.tabsapp.Db.ProductDownloader;

import java.util.ArrayList;

/**
 * A placeholder fragment containing a simple view.
 */
public class CustomerActivityFragment extends Fragment {
    ArrayList<Customers> productses = new ArrayList<Customers>();
    RecyclerView rv;
    final static String urlAddress = "http://b2school.net/q8dir/customers.php";

    public CustomerActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_customer, container, false);

        rv=(RecyclerView) v.findViewById(R.id.customerRv );
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv.setItemAnimator(new DefaultItemAnimator());
        String findAddress = urlAddress;
        new ProductDownloader(getActivity(),findAddress,rv).execute();

        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
        new ProductDownloader(getActivity(),urlAddress,rv).execute();

    }
}
