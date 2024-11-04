package com.example.app_disciplinas;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.app_disciplinas.databinding.ActivityMainBinding;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.navView.setItemIconTintList(null);

        setSupportActionBar(binding.appBarMain.toolbar);


        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;

        // Configuração da AppBar e navegação
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_primeiro, R.id.nav_segundo,
                R.id.nav_terceiro, R.id.nav_quarto, R.id.nav_quinto, R.id.nav_sexto
        ).setOpenableLayout(drawer).build();

        NavController navController = Navigation.findNavController(this, R.id.fragment_container);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        // Listener para o clique nos itens do menu deslizante (drawer)
//        navigationView.setNavigationItemSelectedListener(item -> {
//            int id = item.getItemId();
//            Fragment selectedFragment = null;
//
//            if (id == R.id.nav_home) {
//                selectedFragment = new HomeFragment();
//            } else if (id == R.id.nav_primeiro) {
//                selectedFragment = new Periodo1Fragment();
//            } else if (id == R.id.nav_segundo) {
//                selectedFragment = new Periodo2Fragment();
//            } else if (id == R.id.nav_terceiro) {
//                Snackbar.make(binding.getRoot(), "Terceiro selecionado", Snackbar.LENGTH_SHORT).show();
//            } else if (id == R.id.nav_quarto) {
//                Snackbar.make(binding.getRoot(), "Quarto selecionado", Snackbar.LENGTH_SHORT).show();
//            } else if (id == R.id.nav_quinto) {
//                Snackbar.make(binding.getRoot(), "Quinto selecionado", Snackbar.LENGTH_SHORT).show();
//            } else if (id == R.id.nav_sexto) {
//                Snackbar.make(binding.getRoot(), "Sexto selecionado", Snackbar.LENGTH_SHORT).show();
//            } else {
//                return false;
//            }
//
//            if (selectedFragment != null) {
//                getSupportFragmentManager()
//                        .beginTransaction()
//                        .replace(R.id.fragment_container, selectedFragment)
//                        .commit();
//            }
//
//            drawer.closeDrawer(binding.navView);
//            return true;
//        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Infla o menu para adicionar itens à action bar
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_sair) {
            // Fecha a atividade
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.fragment_container);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}
