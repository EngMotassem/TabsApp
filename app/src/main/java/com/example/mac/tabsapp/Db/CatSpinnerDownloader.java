package com.example.mac.tabsapp.Db;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

/**
 * Created by mac on 9‏/12‏/2016.
 */

public class CatSpinnerDownloader extends AsyncTask<Void,Void,String> {

    Context c;
    String urlAddress;
    Spinner sp;



    ProgressDialog pd;

    public CatSpinnerDownloader(Context c, String urlAddress, Spinner sp) {
        this.c = c;
        this.urlAddress = urlAddress;
        this.sp = sp;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        pd=new ProgressDialog(c);
        pd.setTitle("Categories ");
        pd.setMessage("Retrieving categories ..Please wait");
        pd.show();
    }

    @Override
    protected String doInBackground(Void... params) {
        return this.downloadData();
    }

    @Override
    protected void onPostExecute(String jsonData) {
        super.onPostExecute(jsonData);

        pd.dismiss();

        if(jsonData==null)
        {
            Toast.makeText(c,"Unsuccessful,No Data Retrieved",Toast.LENGTH_SHORT).show();
        }else {
            //PARSER
            CatSpinnerParser parser=new CatSpinnerParser(c,jsonData,sp);


            parser.execute();

        }


    }

    public CatSpinnerDownloader() {
    }

    private String downloadData()
    {
        HttpURLConnection con= Connector.connect(urlAddress);
        if(con==null)
        {
            return null;
        }

        try
        {
            InputStream is=new BufferedInputStream(con.getInputStream());
            BufferedReader br=new BufferedReader(new InputStreamReader(is));

            String line;
            StringBuffer jsonData=new StringBuffer();

            while ((line=br.readLine()) != null)
            {
                jsonData.append(line+"\n");
            }

            br.close();
            is.close();


            return jsonData.toString();

        } catch (IOException e) {
            e.printStackTrace();
        }


        return null;
    }
}