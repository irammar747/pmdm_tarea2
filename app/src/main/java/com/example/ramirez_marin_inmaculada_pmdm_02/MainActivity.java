package com.example.ramirez_marin_inmaculada_pmdm_02;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.ramirez_marin_inmaculada_pmdm_02.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private NavController navController;
    private ActionBarDrawerToggle toggle;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Configura el NavController
        navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController);

        // Obtener el NavController desde el NavHostFragment
        FragmentManager fragmentManager = getSupportFragmentManager();
        NavHostFragment navHostFragment = (NavHostFragment) fragmentManager.findFragmentById(R.id.nav_host_fragment);
        if (navHostFragment != null) {
            navController = navHostFragment.getNavController();
        }

        //Para que no se muestre atrás cuando se muestra la hamburguesa
        navController.addOnDestinationChangedListener(this::onChangeView);
        // Configurar menú toggle
        configureToggleMenu();

        // Configurar la navegación
        configureNavigation();

        // Configurar el icono del menú en la ActionBar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    private void onChangeView(NavController navController, NavDestination navDestination, Bundle bundle) {
        if(toggle == null)return;
        if(navDestination.getId() == R.id.personajeDetailFragment){
            toggle.setDrawerIndicatorEnabled(false);
        }else{
            toggle.setDrawerIndicatorEnabled(true);
        }
        toggle.syncState(); // Actualiza el estado del toggle
    }

    private void configureNavigation() {
        NavigationUI.setupWithNavController(binding.navView, navController);

        // Manejar la selección de elementos del menú
        binding.navView.setNavigationItemSelectedListener(menuItem -> {
            if (menuItem.getItemId() == R.id.nav_home) {
                navController.navigate(R.id.mainFragment); // Navegar al fragmento de inicio
            }else if(menuItem.getItemId() == R.id.nav_setting){
                navController.navigate(R.id.settingFragment);
            }
            binding.drawerLayout.closeDrawers(); // Cerrar el menú
            toggle.syncState();
            return true;
        });

    }

    private void configureToggleMenu() {
        // Configurar el ActionBarDrawerToggle
        toggle = new ActionBarDrawerToggle(
                this,
                binding.drawerLayout,
                R.string.open_drawer,
                R.string.close_drawer
        );
        binding.drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        //setSupportActionBar(binding.toolbar); // Esto ya gestiona el ícono
    }

    // Método para manejar el clic en un juego
    public void personajeClicked(PersonajeData personaje, View view) {

        // Mostrar el Toast con el nombre del personaje seleccionado
        Toast.makeText(this, "Se ha seleccionado el personaje: " + personaje.getName(), Toast.LENGTH_SHORT).show();

        // Crear un Bundle para pasar los datos al PersonajeGameDetailFragment
        Bundle bundle = new Bundle();
        bundle.putString("name", personaje.getName());
        bundle.putString("description", personaje.getDescription());
        bundle.putString("ability", personaje.getAbility());
        bundle.putInt("image", personaje.getImageResId());

        // Navegar al detalle del personaje con el Bundle
        Navigation.findNavController(view).navigate(R.id.personajeDetailFragment, bundle);
    }
    @Override
    public boolean onSupportNavigateUp() {
        if (toggle != null) {
            toggle.syncState(); // Sincroniza el estado del toggle
        }
        Fragment navHostFragment = getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);

        if (navHostFragment != null) {
            NavController navController = NavHostFragment.findNavController(navHostFragment);
            return NavigationUI.navigateUp(navController, binding.drawerLayout) || super.onSupportNavigateUp();
        }
        return super.onSupportNavigateUp();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        // Manejar clics en el icono del menú
        if (toggle.onOptionsItemSelected(item)) {
            return true;
        }

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