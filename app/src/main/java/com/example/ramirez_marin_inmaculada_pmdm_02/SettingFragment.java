package com.example.ramirez_marin_inmaculada_pmdm_02;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Locale;

import androidx.preference.ListPreference;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.PreferenceManager;

public class SettingFragment extends PreferenceFragmentCompat {

    @Override
    public void onCreatePreferences(@Nullable Bundle savedInstanceState, @Nullable String rootKey) {
        // Establecer el archivo de preferencias
        setPreferencesFromResource(R.xml.preferences, rootKey);

        ListPreference languagePreference = findPreference("language");
        if(languagePreference != null){
            languagePreference.setOnPreferenceChangeListener((preference, newValue) -> {
                // Cambiar el idioma cuando se seleccione una nueva opción
                String languageCode = (String) newValue;
                changeLanguage(languageCode);
                return true;
            });
        }
    }

    private void changeLanguage(String languageCode) {
        // Cambiar el idioma de la aplicación
        Locale locale = new Locale(languageCode);
        Locale.setDefault(locale);

        // Actualizar la configuración de idioma
        android.content.res.Configuration config = getResources().getConfiguration();
        config.setLocale(locale);
        getContext().getApplicationContext().getResources().updateConfiguration(config, getContext().getApplicationContext().getResources().getDisplayMetrics());

        // Guardar la preferencia de idioma en SharedPreferences
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getContext());
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("language", languageCode);
        editor.apply();
    }

    @Override
    public void onStart() {
        super.onStart();
        // Cambia el título del ActionBar
        if (getActivity() != null) {
            ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(R.string.ajustes);
        }
    }
}