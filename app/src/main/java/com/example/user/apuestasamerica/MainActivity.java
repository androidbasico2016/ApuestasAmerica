package com.example.user.apuestasamerica;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

//comentario desde github

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        recyclerView = (RecyclerView) findViewById(R.id.lista);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        String data[] = {"Argentina", "Bolivia", "Brazil", "Canada",
                "Chile", "Colombia", "Cuba", "Estados Unidos",
                "Mexico", "Peru", "Uruguay", "Venezuela",};

        String ubicacion[] = {"Sud America", "Sud America", "Sud America", "Norte America",
                "Sud America", "Sud America", "Centro America", "Norte America",
                "Norte America", "Sud America", "Sud America", "Sud America"};
        List<Pais> paises = new ArrayList<>();
        for (int i = 0; i < data.length; i++) {
            Pais pais = new Pais();
            pais.setNombre(data[i]);
            pais.setDescripcion(ubicacion[i]);
            pais.setImagen(getResources().getIdentifier(pais.getNombre().toLowerCase().replace(" ", ""), "drawable", getPackageName()));
            paises.add(pais);

        }

        RecyclerView.Adapter adapter1 = new MyRecyclerAdapter(this, paises);
        recyclerView.setAdapter(adapter1);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        return true;
    }
}
