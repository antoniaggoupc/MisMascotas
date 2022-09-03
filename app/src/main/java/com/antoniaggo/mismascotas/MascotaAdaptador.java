package com.antoniaggo.mismascotas;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder>{
    ArrayList<Mascota> mascotas;
    Activity activity;

    // Construye nuestra lista de contactos
    public MascotaAdaptador(ArrayList<Mascota> contactos, Activity activity) {
        this.mascotas = mascotas;
        this.activity = activity;
    }

    // Infla el layout y lo pasará al ViewHolder para que él obtenga los views
    @NonNull
    @Override
    public MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_cardview_mascota, parent, false);
        return new MascotaViewHolder(v);
    }
    @Override
    public void onBindViewHolder(@NonNull MascotaAdaptador.MascotaViewHolder holder, int position) {
        // Obtiene el objeto en el que está iterando
        Mascota contacto = mascotas.get(position);
        // Setea la información
        MascotaViewHolder.img_foto_CV.setImageResource(contacto.getFoto());
        MascotaViewHolder.tv_nombre_CV.setText(contacto.getNombre());
        MascotaViewHolder.tv_telefono_CV.setText(contacto.getTelefono());

        contactoViewHolder.img_foto_CV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, contacto.getNombre(), Toast.LENGTH_SHORT).show();
                //
                // Para cambiar de pantalla de MainActivity a DetalleContacto
                // al pulsar sobre un ítem de MainActivity
                //
                Intent intent = new Intent(activity, DetalleContacto.class);
                //
                // Para enviar los datos de cada contacto a la Activity DetalleContacto
                //
                intent.putExtra(activity.getResources().getString(R.string.pnombre), contacto.getNombre());
                intent.putExtra(activity.getResources().getString(R.string.ptelefono), contacto.getTelefono());
                intent.putExtra(activity.getResources().getString(R.string.pemail), contacto.getEmail());
                activity.startActivity(intent);
                // Elimino esta Activity para que no se vayan congelando y guardando en background ya
                // que es como se comporta por defecto.  Una activity encima de la otra,ect.
                // Con esta forma de programar sólo tengo siempre una Activity ejecutándose
                // y mi aplicación no se ralentiza a medida que el usuario la va usando
                // ya que no se van superponiendo las activies una encima de la otra
                //
                activity.finish();
            }
        });
        contactoViewHolder.btn_Like_CV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, "Diste Like a: " + contacto.getNombre(), Toast.LENGTH_SHORT).show();
            }

        });
    }

    // Devuelve la cantidad de elementos que contiene la lista
    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder {

        private androidx.appcompat.widget.AppCompatImageView img_foto_CV;
        private com.google.android.material.textview.MaterialTextView tv_nombre_CV;
        private com.google.android.material.textview.MaterialTextView tv_telefono_CV;
        private ImageButton btn_Like_CV;

        public MascotaViewHolder(@NonNull View itemView) {
            super(itemView);
            img_foto_CV = itemView.findViewById(R.id.img_foto_CV);
            tv_nombre_CV = itemView.findViewById(R.id.tv_nombre_CV);
            tv_telefono_CV = itemView.findViewById(R.id.tv_telefono_CV);
            btn_Like_CV = itemView.findViewById(R.id.btn_like_CV);
        }
    }
}
