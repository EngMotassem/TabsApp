package com.example.mac.tabsapp.Db;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by mac on 9‏/12‏/2016.
 */

public class Connector {
    public static HttpURLConnection connect(String urlAddress)

    {
        try
        {
            //final String encodedURL = URLEncoder.encode(urlAddress, "UTF-8");
            URL url=new URL(urlAddress);
            HttpURLConnection con= (HttpURLConnection) url.openConnection();

            // Httpc httpclient = new DefaultHttpClient();
            //  httpclient.getParams().setParameter("http.protocol.content-charset", "UTF-8");

            //CON PROPS
            con.setRequestMethod("GET");

            con.setConnectTimeout(20000);
            con.setReadTimeout(20000);
            con.setDoInput(true);


            return con;


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

}
