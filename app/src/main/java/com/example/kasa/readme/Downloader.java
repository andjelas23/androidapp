package com.example.kasa.readme;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.ListView;
import android.widget.Toast;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class Downloader extends AsyncTask<Void,Integer,String> {

    Context c;
    String address;
    ListView lv;
    ProgressDialog pd;

    public Downloader(Context c, String address, ListView lv) {
        this.c = c;
        this.address = address;
        this.lv = lv;
    }

    //B4 JOB STARTS
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        pd = new ProgressDialog(c);
        pd.setTitle("Fetch Data");
        pd.setMessage("Fetching Data...Please wait");
        pd.show();
    }

    @Override
    protected String doInBackground(Void... params) {
        String data = downloadData();
        return data;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        pd.dismiss();
        if (s != null) {
            Parser p = new Parser(c, s, lv);
            p.execute();
        } else {
            Toast.makeText(c, "Unable to download data", Toast.LENGTH_SHORT).show();
        }
    }

    private String downloadData()
    {
        HttpURLConnection con=Connector.connect(address);
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
                jsonData.append(line+"n");
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