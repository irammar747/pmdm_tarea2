package com.example.ramirez_marin_inmaculada_pmdm_02;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.ramirez_marin_inmaculada_pmdm_02.databinding.PersonajeListFragmentBinding;

import java.util.ArrayList;
import java.util.Objects;

public class PersonajeListFragment extends Fragment {
    private PersonajeListFragmentBinding binding; // Binding para el layout
    private ArrayList<PersonajeData> personajes; // Lista de personajes
    private PersonajeRecyclerViewAdapter adapter; // Adaptador del RecyclerView

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflar el layout utilizando el binding
        binding = PersonajeListFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Inicializa la lista de personajes
        loadData(); // Cargar los juegos (puedes implementar esta función para obtener datos)

        // Configurar el RecyclerView
        adapter = new PersonajeRecyclerViewAdapter(personajes, getActivity());
        binding.personajeRecyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.personajeRecyclerview.setAdapter(adapter);

    }

    // Método para cargar juegos (puedes implementar tu lógica aquí)
    private void loadData() {
        personajes = new ArrayList<PersonajeData>();
        // Llenar la lista con datos de los personajes
        personajes.add(new PersonajeData(
                R.drawable.mario, // ID del recurso en drawable para Mario
                "Mario",
                "Rey del Reino Champiñón",
                "Derrotar a todos los enemigos"
        ));

        personajes.add(new PersonajeData(
                R.drawable.luigi, // ID del recurso en drawable para Luigi
                "Luigi",
                "Hermano de Mario",
                "Saltos altos y velocidad"
        ));

        personajes.add(new PersonajeData(
                R.drawable.peach, // ID del recurso en drawable para Peach
                "Peach",
                "Princesa del Reino Champiñón",
                "Salvar el reino y ayudar a Mario"
        ));

        personajes.add(new PersonajeData(
                R.drawable.toad, // ID del recurso en drawable para Toad
                "Toad",
                "Guía del Reino Champiñón",
                "Ayudar a Mario y Peach"
        ));
    }

    @Override
    public void onStart() {
        super.onStart();
        // Cambia el título del ActionBar
        if (getActivity() != null) {
            ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(R.string.lista_personajes);
        }
    }
}
