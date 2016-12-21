package com.example.mac.tabsapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.mac.tabsapp.Db.ProductDownloader;

/**
 * Created by mac on 23‏/11‏/2016.
 */

public class TabZero extends Fragment {

    RecyclerView rv;
    final static String urlAddress = "http://b2school.net/q8dir/customers.php";
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_customer, container, false);
        rv=(RecyclerView) rootView.findViewById(R.id.customerRv );
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv.setItemAnimator(new DefaultItemAnimator());
        new ProductDownloader(getActivity(),urlAddress,rv).execute();

        return rootView;
    }
}
