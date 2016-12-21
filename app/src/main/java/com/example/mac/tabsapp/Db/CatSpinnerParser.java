package com.example.mac.tabsapp.Db;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

import com.example.mac.tabsapp.Adapters.CatAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by mac on 9‏/12‏/2016.
 */

public class CatSpinnerParser extends AsyncTask<Void,Void,Integer> {

    Context c;
    String jsonData;
    Spinner sp;
    private CatAdapter adapter;

    ProgressDialog pd;
    private ArrayList<SpinnerData> productse=new ArrayList<>();

    public CatSpinnerParser() {
    }

    public CatSpinnerParser(Context c, String jsonData, Spinner sp) {
        this.c = c;
        this.jsonData = jsonData;
        this.sp = sp;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        pd=new ProgressDialog(c);
        pd.setTitle("Parse");
        pd.setMessage("Parsing...Please wait");
        pd.show();
    }

    @Override
    protected Integer doInBackground(Void... params) {
        return this.parseData();
    }

    @Override
    protected void onPostExecute(Integer result) {
        super.onPostExecute(result);

        pd.dismiss();

        if(result==0)
        {
            Toast.makeText(c,"Unable To Parse Cat",Toast.LENGTH_SHORT).show();
        }else
        {
         //   CatAdapter adapter=new CatAdapter(c,productse);
            sp.setAdapter((SpinnerAdapter) adapter);
        }
    }

    private int parseData()
    {
        try
        {
            JSONArray ja=new JSONArray(jsonData);
            JSONObject jo=null;

            productse.clear();
            SpinnerData prod;

            for (int i=0;i<ja.length();i++)
            {
                jo=ja.getJSONObject(i);

                int id=jo.getInt("id");
                String name=jo.getString("name");

/*
[{"0":"1","id":"1",
"1":"flowers","name":"flowers","2"
:"buy flowers","des":"buy flowers","3":"3-camomile-png-image-thumb.png",
"image":"3-camomile-png-image-thumb.png",
"4":"1","priority":"1"},{"0":"3","id":"3","1":"car renal",
"name":"car renal","2":"car renal","des":"car renal",
"3":"1-audi-r8-png-image-thumb.png",
"image":"1-audi-r8-png-image-thumb.png",

"4":"2","priority":"2"}]
 */

                prod=new SpinnerData();
                String baseUrl="http://bschool.net/q8dir/images/";

                prod.setId(id);
                prod.setName(name);

                productse.add(prod);


            }
           // adapter=new CatAdapter(c,productse);
            adapter.notifyDataSetChanged();

            return 1;

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return 0;
    }




}
