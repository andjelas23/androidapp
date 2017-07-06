package com.example.kasa.readme;
/**
 * Created by KASA on 16.6.2017.
 */
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;

import java.io.BufferedReader;

import java.io.InputStream;
import java.io.InputStreamReader;

import java.net.HttpURLConnection;

import java.net.URL;

import java.util.ArrayList;

import static com.example.kasa.readme.Grad.grad;

/**
 * Created by SV on 5/31/2017.
 */

public  class FunkcijeInternet {


    public ArrayList<Klasa> getInternetData() throws Exception {
        String data = null;
        ArrayList<Klasa> listaRez = new ArrayList<Klasa>();
        JSONArray  jArray;

        Log.d("A","A");


        URL url = new URL("http://bp.etf.ac.me/users/sara92/stampaj.php?id="+grad);
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        try {
            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            StringBuffer sb = new StringBuffer("");
            String l="";
            String nl= System.getProperty("line.separator");


            while ((l=reader.readLine()) !=null){
                sb.append(l+nl);
            }


            data= sb.toString();


        }
        finally {
            try{
                if (data!=null)
                {
                    listaRez.clear();
                    jArray = new JSONArray(data);
                    JSONObject json_data=null;
                    for(int i=0;i<jArray.length();i++){
                        json_data = jArray.getJSONObject(i);
                        Klasa cstmTemp= new Klasa(json_data.getString("biblioteka"));
                        listaRez.add(cstmTemp);

                    }
                }
                //
            }
            catch(JSONException e1){

            }
        }
        return listaRez;
    }

}
