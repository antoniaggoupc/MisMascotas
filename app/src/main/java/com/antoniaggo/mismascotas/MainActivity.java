package com.antoniaggo.mismascotas;

import android.os.Bundle;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    ArrayList<Mascota> mascotas = new ArrayList<Mascota>();
    private RecyclerView listaMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // The Toolbar will not display the application title unless it is declared as an ActionBar.

        // assigning ID of the toolbar to a variable
        // Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        // using toolbar as ActionBar
        // Sets the Toolbar to act as the ActionBar for this Activity window.
        // Make sure the toolbar exists in the activity and is not null
        //setSupportActionBar(toolbar);

        listaMascotas = findViewById(R.id.recyclerViewMascotas);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);

        inicializarListaMascotas();
        inicializarAdaptador();

    }

    // Menu icons are inflated just as they were with actionbar

    public void inicializarListaMascotas(){
        mascotas.add(new Mascota(R.drawable.icons8_fish_96,"Fish", "1"));
        mascotas.add(new Mascota(R.drawable.icons8_hamster_96,"Hamster", "2"));
        mascotas.add(new Mascota(R.drawable.icons8_kissing_cat_48,"Catty", "3"));
        mascotas.add(new Mascota(R.drawable.icons8_parrot_96,"Parrot", "4"));
        mascotas.add(new Mascota(R.drawable.icons8_squirrel_96,"Squirrel", "5"));

    }

    // Crear un objeto de contactoAdaptador pasarle nuestra lista para que contactoAdaptador pueda hacer lo que tenemos definido
    public void inicializarAdaptador(){
        MascotaAdaptador adapter = new MascotaAdaptador(mascotas,this);
        listaMascotas.setAdapter(adapter);
    }


}