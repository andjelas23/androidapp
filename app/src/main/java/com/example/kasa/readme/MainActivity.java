package com.example.kasa.readme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public  void otvoriBibl(View view){

        Intent intent = new Intent(this,Main2Activity.class);
        startActivity(intent);
    }
    public  void otvoriKnjigu(View view){

        Intent intent = new Intent(this,Main3Activity.class);
        startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

}

