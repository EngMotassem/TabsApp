package com.example.mac.tabsapp;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.media.browse.MediaBrowser;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.media.MediaBrowserServiceCompat;
import android.support.v4.util.TimeUtils;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import com.example.mac.tabsapp.Db.Categories;

import com.example.mac.tabsapp.Db.CatSpinnerDownloader;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by mac on 23‏/11‏/2016.
 */

public class TabOne extends Fragment {

    private Button button;
    private String encoded_string, image_name;
    private Bitmap bitmap;
    private File file;
    private Uri file_uri;
    private ImageView imageView;
    private String mCurrentPhotoPath;

    private Bitmap mImageBitmap;
    private EditText customerName,desc,phone,address,mapLocation;
    private Spinner spinner;
   // private Location location;
  // public static final String LOCATION_DATA_EXTRA = PACKAGE_NAME + ".LOCATION_DATA_EXTRA"



    final static String adress="http://b2school.net/q8dir/cats.php";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab1, container, false);
Intent intent=new Intent();
        Location location = intent.getParcelableExtra(Constants.LOCATION_DATA_EXTRA);
        //location.getLatitude();
         customerName=(EditText) rootView.findViewById(R.id.nameText);
          desc=(EditText) rootView.findViewById(R.id.descText);
        phone=(EditText) rootView.findViewById(R.id.phoneText);
        mapLocation=(EditText)rootView.findViewById(R.id.address);
        //address=(EditText) rootView.findViewById(R.id.addressTxt);
       // mapLocation.setText((int) location.getLatitude());


button=(Button)rootView.findViewById(R.id.start);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                makeRequest();


            }
        });



        return rootView;
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if ((requestCode == 10) && (resultCode == Activity.RESULT_OK)) {


           // new Encode_image().execute();




        }
    }






    private void makeRequest() {

        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        StringRequest request = new StringRequest(Request.Method.POST, "http://b2school.net/q8dir/imageUpload.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        Toast.makeText(getActivity(),"done",Toast.LENGTH_LONG).show();

                    }
                }, new Response.ErrorListener() {



            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(getActivity(),"error",Toast.LENGTH_LONG).show();
                customerName.setText(" ");
                desc.setText(" ");
                phone.setText(" ");
                address.setText(" ");

            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

//                Map<String,String> params = new HashMap<String, String>();
                /*
                Map<String,String> params = new HashMap<String, String>();
                params.put(KEY_USERNAME,username);
                params.put(KEY_PASSWORD,password);
                params.put(KEY_EMAIL, email);
                return params;
                 */

                HashMap<String, String> map = new HashMap<>();
                //map.put("encoded_string",encoded_string);
               // map.put("image_name",image_name);
                map.put("customer_name",customerName.getText().toString());
                map.put("customer_details",desc.getText().toString());
                map.put("customer_phone",phone.getText().toString());



                return map;
            }
        };
        requestQueue.add(request);
    }
    }


