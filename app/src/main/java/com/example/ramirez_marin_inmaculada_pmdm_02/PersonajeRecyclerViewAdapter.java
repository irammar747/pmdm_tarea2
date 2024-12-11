package com.example.ramirez_marin_inmaculada_pmdm_02;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ramirez_marin_inmaculada_pmdm_02.databinding.ItemCardviewBinding;

import java.util.ArrayList;

public class PersonajeRecyclerViewAdapter extends RecyclerView.Adapter<PersonajeViewHolder> {
    private final ArrayList<PersonajeData> personajes;
    private final Context context;

    public PersonajeRecyclerViewAdapter(ArrayList<PersonajeData> personajes, Context context) {
        this.personajes = personajes;
        this.context = context;
    }

    @NonNull
    @Override
    public PersonajeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemCardviewBinding binding = ItemCardviewBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new PersonajeViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonajeViewHolder holder, int position) {
        PersonajeData currentPer = this.personajes.get(position);
        holder.bind(currentPer);

        //Manejar el evento de clic
        holder.itemView.setOnClickListener(view -> itemClicked(currentPer, view));
    }

    private void itemClicked(PersonajeData currentPer, View view) {
        // Llama a la función gameClicked de MainActivity, pasando la vista
        ((MainActivity) context).personajeClicked(currentPer, view);
    }

    @Override
    public int getItemCount() {
        return this.personajes.size();
    }

}
