package com.example.ramirez_marin_inmaculada_pmdm_02;

public class PersonajeData {
    private int imageResId;
    private String name;
    private String description;
    private String ability;

    public PersonajeData(int imageResId, String name, String description, String ability) {
        this.imageResId = imageResId;
        this.name = name;
        this.description = description;
        this.ability = ability;
    }

    public int getImageResId() {
        return imageResId;
    }

    public String getAbility() {
        return ability;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
