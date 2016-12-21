package com.example.mac.tabsapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import com.example.mac.tabsapp.Db.ProductDownloader;
import android.view.View;
import android.widget.TextView;

import com.example.mac.tabsapp.Db.Customers;

import java.util.ArrayList;

public class CategoryCustomer extends AppCompatActivity {
    final static String urlAddress = "http://b2school.net/q8dir/customers.php";
    RecyclerView rv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cat_cus);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

      int id = getIntent().getExtras().getInt("id");
        TextView tv=(TextView)findViewById(R.id.textView);
        tv.setText(String.valueOf(id));

        rv=(RecyclerView) findViewById(R.id.ccrv );
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setItemAnimator(new DefaultItemAnimator());
        String findAddress = urlAddress + "?id=" + id;
        new ProductDownloader(CategoryCustomer.this,findAddress,rv).execute();


      /* FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
    }

}
