package com.example.user.librarylistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public class ListaSimple extends AppCompatActivity {

    ListView lista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_simple);

        lista=(ListView) findViewById(R.id.lista);
        String[]data={"uno","dos"};
        ListAdapter adapter= new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,data);

        lista.setAdapter(adapter);

    }
}
