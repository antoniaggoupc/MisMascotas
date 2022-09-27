package com.antoniaggo.mismascotas.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
<<<<<<< HEAD
=======
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
>>>>>>> homework-week-4

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.antoniaggo.mismascotas.R;
<<<<<<< HEAD

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RecyclerViewFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RecyclerViewFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public RecyclerViewFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RecyclerViewFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RecyclerViewFragment newInstance(String param1, String param2) {
        RecyclerViewFragment fragment = new RecyclerViewFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
=======
import com.antoniaggo.mismascotas.adapter.MascotaAdaptador;
import com.antoniaggo.mismascotas.pojo.Mascota;

import java.util.ArrayList;

public class RecyclerViewFragment extends Fragment {

    private ArrayList<Mascota> mascotas = new ArrayList<>();
    private RecyclerView listaMascotas;

>>>>>>> homework-week-4

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
<<<<<<< HEAD
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
=======

>>>>>>> homework-week-4
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
<<<<<<< HEAD
        return inflater.inflate(R.layout.fragment_recycler_view, container, false);
    }
=======
        // Equivalente al setContentView(R.layout.activity_main); de la clase MainActivity
        // Es decir, la forma en que asociamos un layout a una clase
        View v = inflater.inflate(R.layout.fragment_recycler_view, container, false);

        // Nos hemos traido el RecyclerView del Activity Main
        listaMascotas = v.findViewById(R.id.recyclerViewMascotas);


        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);

        inicializarListaMascotas();
        inicializarAdaptador();
        return v;

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

    // Crear un objeto de MascotaAdaptador pasarle nuestra lista para que mascotaAdaptador pueda hacer lo que tenemos definido
    public void inicializarAdaptador(){
        MascotaAdaptador adapter = new MascotaAdaptador(mascotas,getActivity());
        listaMascotas.setAdapter(adapter);
    }

>>>>>>> homework-week-4
}