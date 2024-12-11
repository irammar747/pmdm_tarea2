package com.example.ramirez_marin_inmaculada_pmdm_02;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ramirez_marin_inmaculada_pmdm_02.databinding.ItemCardviewBinding;

public class PersonajeViewHolder extends RecyclerView.ViewHolder {

    private final ItemCardviewBinding binding;

    public PersonajeViewHolder(ItemCardviewBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }
    public void bind(PersonajeData per){
        binding.image.setImageResource(per.getImageResId());
        binding.name.setText(per.getName());
        binding.executePendingBindings(); // Asegura que se apliquen los cambios de inmediato
    }
}
