package com.example.ramirez_marin_inmaculada_pmdm_02;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.preference.EditTextPreference;
import androidx.preference.PreferenceFragmentCompat;

public class PreferencesFragment extends PreferenceFragmentCompat {
    @Override
    public void onCreatePreferences(@Nullable Bundle savedInstanceState, @Nullable String rootKey) {
        setPreferencesFromResource(R.xml.preferences, rootKey);

        EditTextPreference languagePreference = findPreference("language");
        if(languagePreference != null){
            languagePreference.setOnPreferenceChangeListener((preference, newValue) -> {
                return true;
            });
        }
    }
}
