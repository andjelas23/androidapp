package com.example.kasa.readme;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class Main3Activity extends AppCompatActivity {
    static String autor,knjiga,url;
    EditText ed1,ed2;
    ListView lv2;
    Button button;
    ArrayList<Bib> spisak = new ArrayList<Bib>();
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        lv2 = (ListView) findViewById(R.id.lv2);
        ed1 = (EditText) findViewById(R.id.edit1);
        ed2 = (EditText) findViewById(R.id.edit2);

        b1 = (Button) findViewById(R.id.but);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                autor = ed1.getText().toString();
                autor=autor.replaceAll(" ","%20");
                knjiga=ed2.getText().toString();
                knjiga=knjiga.replaceAll(" ","%20");

                if (autor.length()>0){
                    url = "http://bp.etf.ac.me/users/sara92/stampajKnjige.php?autor="+autor;
                }
                if (knjiga.length()>0)
                {
                    url="http://bp.etf.ac.me/users/sara92/stampajKnjige.php?knjiga="+knjiga;
                }

                if((autor.length()>0)&&(knjiga.length()>0))
                {
                    url = "http://bp.etf.ac.me/users/sara92/stampajKnjige.php?autor=" +autor+"&knjiga="+knjiga;
                }
                if ((autor.length()==0)&&(knjiga.length()==0)) {
                    Toast.makeText(Main3Activity.this,"Unesite naziz autora i/ili knjige",Toast.LENGTH_LONG).show();
                }

                new GetDaataTask().execute();
            }
        });

    }
    public class GetDaataTask  extends AsyncTask<Void, Void, String[]> {

        @Override
        protected String[] doInBackground(Void... params) {

            try {
                FjeNet pom = new FjeNet();
                spisak = pom.getInternetDaata();

            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(String[] result) {

            lv2.setAdapter(new CustomAdapter(Main3Activity.this,R.layout.red_spiska, spisak));
            super.onPostExecute(result);
        }

    }


}
