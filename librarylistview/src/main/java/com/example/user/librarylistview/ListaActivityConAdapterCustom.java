package com.example.user.librarylistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ListaActivityConAdapterCustom extends AppCompatActivity {

    ListView lista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_activity_con_adapter_custom);
        lista=(ListView)findViewById(R.id.listaConAdapterCustom);

        final List<Persona> personas= new ArrayList<Persona>();
        Persona persona1= new Persona();
        persona1.setApellido("Amanqui");
        persona1.setNombre("Wilder");


        Persona persona2= new Persona();
        persona2.setApellido("TAz");
        persona2.setNombre("Ronald");

        personas.add(persona1);
        personas.add(persona2);

        int layout= R.layout.row_file;
        ListAdapter adapter= new AdapterCustom(this,layout,personas);
        lista.setAdapter(adapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Persona persona= personas.get(position);
                Toast.makeText(getApplicationContext(),""+persona.getNombre(),Toast.LENGTH_SHORT).show();
            }
        });

    }
}
