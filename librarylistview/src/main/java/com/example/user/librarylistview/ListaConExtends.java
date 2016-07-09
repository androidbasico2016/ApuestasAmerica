package com.example.user.librarylistview;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;

public class ListaConExtends extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_con_extends);
        String[]data={"aa"};
        ListAdapter adapter= new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,data);
        //getListView().setEmptyView(findViewById(android.R.id.empty));
        setListAdapter(adapter);

    }
}
