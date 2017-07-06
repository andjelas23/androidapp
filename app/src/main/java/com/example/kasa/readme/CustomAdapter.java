package com.example.kasa.readme;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by KASA on 3.7.2017.
 */

public class CustomAdapter extends ArrayAdapter<Bib> {


    Context context;
    ArrayList<Bib> array;


    public CustomAdapter(Context context, int textViewResourceId, ArrayList<Bib> lista) {
        super(context, textViewResourceId, lista);
        this.context = context;
        this.array = lista;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View lista1 = inflater.inflate(R.layout.red_spiska, parent, false);
        TextView opis = (TextView) lista1.findViewById(R.id.textView3);
        opis.setText(array.get(position).b);


        return lista1;
    }
}

