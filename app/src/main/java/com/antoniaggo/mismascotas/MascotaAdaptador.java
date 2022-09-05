package com.antoniaggo.mismascotas;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder>{
    ArrayList<Mascota> mascotas;
    Activity activity;

    // Construye nuestra lista de contactos
    public MascotaAdaptador(ArrayList<Mascota> mascotas, Activity activity) {
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
    public void onBindViewHolder(@NonNull MascotaViewHolder mascotaViewHolder, int position) {
        // Obtiene el objeto en el que está iterando
        Mascota mascota = mascotas.get(position);
        // Setea la información
        mascotaViewHolder.img_foto_CV.setImageResource(mascota.getFoto());
        mascotaViewHolder.pet_nombre_CV.setText(mascota.getNombre());
        mascotaViewHolder.number_like_bone_CV.setText(mascota.getNumber_like_bone());

        mascotaViewHolder.img_foto_CV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, mascota.getNombre(), Toast.LENGTH_SHORT).show();
                //
                // Para cambiar de pantalla de MainActivity a DetalleMascota
                // al pulsar sobre un ítem de MainActivity
                //
                Intent intent = new Intent(activity, MascotasFavoritas.class);
                //
                // Para enviar los datos de cada mascota a la Activity DetalleMascota
                //
                intent.putExtra(activity.getResources().getString(R.string.pfoto), mascota.getFoto());
                intent.putExtra(activity.getResources().getString(R.string.pnombre), mascota.getNombre());
                intent.putExtra(activity.getResources().getString(R.string.plikesnumber), mascota.getNumber_like_bone());
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
        mascotaViewHolder.img_bone_dog_CV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, "Diste Like a: " + mascota.getNombre(), Toast.LENGTH_SHORT).show();
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
        private androidx.appcompat.widget.AppCompatImageButton img_bone_dog_CV;
        private com.google.android.material.textview.MaterialTextView pet_nombre_CV;
        private com.google.android.material.textview.MaterialTextView number_like_bone_CV;
        private androidx.appcompat.widget.AppCompatImageButton img_bone_dog_color_CV;

        public MascotaViewHolder(@NonNull View itemView) {
            super(itemView);
            img_foto_CV = itemView.findViewById(R.id.img_foto_CV);
            img_bone_dog_CV = itemView.findViewById(R.id.img_bone_dog_CV);
            pet_nombre_CV = itemView.findViewById(R.id.pet_nombre_CV);
            number_like_bone_CV = itemView.findViewById(R.id.number_like_bone_CV);
            img_bone_dog_color_CV = itemView.findViewById(R.id.img_bone_dog_color_CV);
        }
    }
}
