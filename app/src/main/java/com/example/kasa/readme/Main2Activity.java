package com.example.kasa.readme;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

//import static com.example.kasa.readme.grad;
import static com.example.kasa.readme.R.id.parent;
import static com.example.kasa.readme.R.id.spinner1;
import static com.example.kasa.readme.R.id.visible;


public class Main2Activity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    ArrayList<Klasa> listaPodaci = new ArrayList<Klasa>();
    ListView lv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        lv = (ListView)findViewById(R.id.lv);
        Spinner spinner1 = (Spinner) findViewById(R.id.spinner1);


        ArrayAdapter<String> myAdapt = new ArrayAdapter<String>(Main2Activity.this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.gradovi));
        myAdapt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(myAdapt);
        spinner1.setOnItemSelectedListener(this);



    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String sSelected = parent.getItemAtPosition(position).toString();
        if (position > 0) {
            lv.setVisibility(View.VISIBLE);
            Spinner spinner1 = (Spinner) findViewById(R.id.spinner1);
            Grad g = new Grad(sSelected);
            new GetDataTask().execute();
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
         //
    }


    public class GetDataTask  extends AsyncTask<Void, Void, String[]> {

        @Override
        protected String[] doInBackground(Void... params) {

            try {

                FunkcijeInternet pom = new FunkcijeInternet();
                listaPodaci = pom.getInternetData();

            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();

            }

            return null;
        }

        @Override
        protected void onPostExecute(String[] result) {

            lv.setAdapter(new CustopAdapter(Main2Activity.this,R.layout.red_liste, listaPodaci));

            super.onPostExecute(result);
        }

    }


}
