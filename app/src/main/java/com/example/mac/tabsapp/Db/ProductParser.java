package com.example.mac.tabsapp.Db;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.mac.tabsapp.Adapters.CustomerAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by mac on 9‏/12‏/2016.
 */

public class ProductParser extends AsyncTask<Void,Void,Integer> {

    Context c;
    String jsonData;
    RecyclerView rv;
    private CustomerAdapter adapter;

    ProgressDialog pd;
    private ArrayList<Customers> productse=new ArrayList<>();

    public ProductParser() {
    }

    public ProductParser(Context c, String jsonData, RecyclerView rv) {
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
            Toast.makeText(c,"Unable To Parse",Toast.LENGTH_SHORT).show();
        }else
        {
            //BIND DATA TO RECYCLERVIEW
            CustomerAdapter adapter=new CustomerAdapter(c,productse);
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
            Customers prod;

            for (int i=0;i<ja.length();i++)
            {
                jo=ja.getJSONObject(i);
                /*

                [{"0":"1",
                "id":"1","1":"3",
                "catid":"3","2":"aaa",
                "name":"aaa","3":"best company in car retal",
                "des":"best company in car retal",
                "4":"92929922","phone":"92929922",
                "5":null,"image":null,
                "6":"kuwait-hawali","address":"kuwait-hawali","7":null,
                "lang":null,"8":null,"lat":null}]
                 */

                int id=jo.getInt("id");
                String name=jo.getString("name");
                String imageUrl=jo.getString("image");
                String details=jo.getString("des");
                String phone=jo.getString("phone");

                int cat_id=jo.getInt("catid");


                prod=new Customers();
                String baseUrl="http://bschool.net/q8dir/images/";

                prod.setId(id);
                prod.setName(name);
                prod.setImageUrl(baseUrl+imageUrl);
                prod.setDes(details);
                prod.setPhone(phone);
                prod.setCatid(cat_id);

                productse.add(prod);


            }
           adapter=new CustomerAdapter(c,productse);
            adapter.notifyDataSetChanged();

            return 1;

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return 0;
    }




}
