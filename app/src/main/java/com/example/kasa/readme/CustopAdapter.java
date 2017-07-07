package com.example.kasa.readme;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;


public class CustopAdapter extends ArrayAdapter<Klasa> {


    Context context;
    ArrayList<Klasa> array;


    public CustopAdapter(Context context, int textViewResourceId, ArrayList<Klasa> lista) {
        super(context, textViewResourceId, lista);
        this.context = context;
        this.array = lista;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View lista1 = inflater.inflate(R.layout.red_liste, parent, false);
        TextView opis = (TextView) lista1.findViewById(R.id.textView2);
        opis.setText(array.get(position).a);
        
       //a is from Klasa


        return lista1;
    }
}


