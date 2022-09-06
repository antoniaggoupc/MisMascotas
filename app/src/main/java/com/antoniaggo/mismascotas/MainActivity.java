package com.antoniaggo.mismascotas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;


import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Mascota> mascotas = new ArrayList<>();
    private RecyclerView listaMascotas;
    private ImageView img_star;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // The Toolbar will not display the application title unless it is declared as an ActionBar.

        // assigning ID of the toolbar to a variable
        Toolbar toolbar = findViewById(R.id.toolbar);
        // using toolbar as ActionBar
        // Sets the Toolbar to act as the ActionBar for this Activity window.
        // Make sure the toolbar exists in the activity and is not null
        setSupportActionBar(toolbar);

        listaMascotas = findViewById(R.id.recyclerViewMascotas);


        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);

        inicializarListaMascotas();
        inicializarAdaptador();

        img_star = findViewById(R.id.imv_star);
        img_star.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onMascotasFavoritas();
            }
        });


    }


    public void inicializarListaMascotas(){
        mascotas.add(new Mascota(R.drawable.icons8_fish_96,"Fish",20));
        mascotas.add(new Mascota(R.drawable.icons8_hamster_96,"Hamster", 10));
        mascotas.add(new Mascota(R.drawable.icons8_kissing_cat_48,"Catty", 7));
        mascotas.add(new Mascota(R.drawable.icons8_parrot_96,"Parrot", 5));
        mascotas.add(new Mascota(R.drawable.icons8_squirrel_96,"Squirrel", 4));
        mascotas.add(new Mascota(R.drawable.icons8_fish_96,"Fish_2",2));
        mascotas.add(new Mascota(R.drawable.icons8_hamster_96,"Hamster_2", 7));
        mascotas.add(new Mascota(R.drawable.icons8_kissing_cat_48,"Catty_2", 3));
        mascotas.add(new Mascota(R.drawable.icons8_parrot_96,"Parrot_2", 25));
        mascotas.add(new Mascota(R.drawable.icons8_squirrel_96,"Squirrel_2", 12));

    }

    // Crear un objeto de contactoAdaptador pasarle nuestra lista para que contactoAdaptador pueda hacer lo que tenemos definido
    public void inicializarAdaptador(){
        MascotaAdaptador adapter = new MascotaAdaptador(mascotas,this);
        listaMascotas.setAdapter(adapter);
    }


    public void onMascotasFavoritas()
    {
        //
        // Para cambiar de pantalla de MainActivity a DetalleContacto
        // al pulsar sobre un ítem de MainActivity
        //
        Intent intent = new Intent(MainActivity.this, MascotasFavoritas.class);
        //
        // Para enviar los datos de cada contacto a la Activity DetalleContacto
        //
           /* intent.putExtra(getResources().getString(R.string.pnombre), contactos.get(i).getNombre());
            intent.putExtra(getResources().getString(R.string.ptelefono), contactos.get(i).getTelefono());
            intent.putExtra(getResources().getString(R.string.pemail), contactos.get(i).getEmail());
            */

        startActivity(intent);
        // Elimino esta Activity para que no se vayan congelando y guardando en background ya
        // que es como se comporta por defecto.  Una activity encima de la otra,ect.
        // Con esta forma de programar sólo tengo siempre una Activity ejecutándose
        // y mi aplicación no se ralentiza a medida que el usuario la va usando
        // ya que no se van superponiendo las activies una encima de la otra
        //
        //finish();
    }


}