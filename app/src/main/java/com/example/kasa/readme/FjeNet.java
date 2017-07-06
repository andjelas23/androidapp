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
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import static com.example.kasa.readme.Main3Activity.url;


/**
 * Created by SV on 5/31/2017.
 */

public  class FjeNet {


    public ArrayList<Bib> getInternetDaata() throws Exception {
        String data = null;
        ArrayList<Bib> listaR = new ArrayList<Bib>();
        JSONArray  jArray;

        Log.d("A","A");

        URI uri = new URI(url);
        URL url1 = uri.toURL();

        HttpURLConnection urlConnection = (HttpURLConnection) url1.openConnection();
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
                    listaR.clear();
                    jArray = new JSONArray(data);
                    JSONObject json_data=null;
                    for(int i=0;i<jArray.length();i++){
                        json_data = jArray.getJSONObject(i);
                        Bib cstmTemp= new Bib(json_data.getString("biblioteka"));
                      //  Bib cstmT= new Bib(json_data.getString("grad"));

                        listaR.add(cstmTemp);

                    }
                }
                //
            }
            catch(JSONException e1){

            }
        }
        return listaR;
    }

}
