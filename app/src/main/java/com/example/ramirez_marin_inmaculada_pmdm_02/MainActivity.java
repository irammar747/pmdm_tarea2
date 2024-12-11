package com.example.ramirez_marin_inmaculada_pmdm_02;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.ramirez_marin_inmaculada_pmdm_02.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private NavController navController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Configura el NavController
        navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController);
    }

    // Método para manejar el clic en un juego
    public void personajeClicked(PersonajeData personaje, View view) {
        // Crear un Bundle para pasar los datos al PersonajeGameDetailFragment
        Bundle bundle = new Bundle();
        bundle.putString("name", personaje.getName());
        bundle.putString("description", personaje.getDescription());
        bundle.putString("ability", personaje.getAbility());
        bundle.putInt("image", personaje.getImageResId());

        // Navegar al GameDetailFragment con el Bundle
        Navigation.findNavController(view).navigate(R.id.personajeDetailFragment, bundle);
    }
    @Override
    public boolean onSupportNavigateUp() {
        //NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        // Utiliza el método navigateUp del NavController
        return navController.navigateUp() || super.onSupportNavigateUp();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId() == R.id.menu_about) {
            showAboutDialog(); // Llama al método que muestra el Dialog
            return true;
        }else{
            return super.onOptionsItemSelected(item);
        }
    }
    private void showAboutDialog() {
        // Crear un AlertDialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Acerca de...")
                .setMessage("Aplicación desarrollada por Inma. Versión 1.0.")
                .setPositiveButton("OK", null) // Botón OK para cerrar el dialog
                .show();
    }
}