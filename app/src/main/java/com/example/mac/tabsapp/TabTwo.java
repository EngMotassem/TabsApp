package com.example.mac.tabsapp;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.mac.tabsapp.Db.Categories;
import com.example.mac.tabsapp.Db.CatDownloader;

//import com.example.mac.tabsapp.Adapters.;


import java.util.ArrayList;

/**
 * Created by mac on 23‏/11‏/2016.
 */

public class TabTwo extends Fragment {

    ArrayList<Categories> categories = new ArrayList<Categories>();
    RecyclerView rv;
    Context c;
     final static String adress="http://b2school.net/q8dir/cats.php";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.tab2, container, false);
        rv=(RecyclerView) v.findViewById(R.id.categoriesRv );
        rv.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        rv.setLayoutManager(layoutManager);
        rv.setItemAnimator(new DefaultItemAnimator());
        CatDownloader downloader= (CatDownloader) new CatDownloader(getActivity(),adress,rv).execute();

        return v;
    }
}
