package com.example.mac.tabsapp.Db;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.mac.tabsapp.Adapters.CatAdapter;
import com.example.mac.tabsapp.Adapters.CustomerAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import java.util.ArrayList;

/**
 * Created by mac on 9‏/12‏/2016.
 */

public class CatParser extends AsyncTask<Void,Void,Integer> {

    Context c;
    String jsonData;
    RecyclerView rv;
    private CatAdapter adapter;

    ProgressDialog pd;
    private ArrayList<Categories> productse=new ArrayList<>();

    public CatParser() {
    }

    public CatParser(Context c, String jsonData, RecyclerView rv) {
        this.c = c;
        this.jsonData = jsonData;
        this.rv = rv;
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
            CatAdapter adapter=new CatAdapter(c,productse);
            rv.setAdapter(adapter);
        }
    }

    private int parseData()
    {
        try
        {
            JSONArray ja=new JSONArray(jsonData);
            JSONObject jo=null;

            productse.clear();
            Categories prod;

            for (int i=0;i<ja.length();i++)
            {
                jo=ja.getJSONObject(i);

                int id=jo.getInt("id");
                String name=jo.getString("name");
                String imageUrl=jo.getString("image");
                String details=jo.getString("des");

                prod=new Categories();
                String baseUrl="http://b2school.net/q8dir/images/";

                prod.setId(id);
                prod.setName(name);
                prod.setImageUrl(baseUrl+imageUrl);
                prod.setDes(details);

                productse.add(prod);


            }
            adapter=new CatAdapter(c,productse);
            adapter.notifyDataSetChanged();

            return 1;

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return 0;
    }




}
