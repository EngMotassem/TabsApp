package com.example.mac.tabsapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.File;

/**
 * Created by mac on 11‏/12‏/2016.
 */

public class Details extends Fragment {

    private ImageButton phoneButton;
   // private String customer_name;
    private TextView  customer_name,customer_details,customer_phone;

    // private Location location;
    // public static final String LOCATION_DATA_EXTRA = PACKAGE_NAME + ".LOCATION_DATA_EXTRA"


    final static String adress = "http://b2school.net/q8dir/cats.php";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.details, container, false);


        return rootView;
    }
}
