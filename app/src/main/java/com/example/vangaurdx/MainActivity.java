package com.example.vangaurdx;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
//import android.widget.Toolbar;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity
{
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    private RecyclerView postView;
    private Toolbar mToolbar;
    private ActionBarDrawerToggle actionBarDrawerToggle;

    private FirebaseAuth mAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth =FirebaseAuth.getInstance();

        mToolbar = (Toolbar) findViewById(R.id.main_toolbar) ;
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("HOME | BOARD");

        drawerLayout = (DrawerLayout)  findViewById(R.id.drawable_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(MainActivity.this,drawerLayout,R.string.drawer_open,R.string.drawer_Close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        navigationView = (NavigationView) findViewById(R.id.nav_view);
        View navView = navigationView.inflateHeaderView(R.layout.navigation_header);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item)
            {
                userMenuSelector(item);
                return false;
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser currentUser= mAuth.getCurrentUser();
        if (currentUser==null)
        {
            SendUserToLogin();
        }
    }

    private void SendUserToLogin() {
        Intent loginIntent =new Intent(MainActivity.this,LoginActivity.class);
        loginIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(loginIntent);
        finish();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(actionBarDrawerToggle.onOptionsItemSelected(item))
        {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    //private void setSupportActionBar(Toolbar mToolbar) {}

    private void userMenuSelector(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.nav_profile:
                Toast.makeText(this, "PROFILE", Toast.LENGTH_SHORT).show();
                break;

            case R.id.nav_home:
                Toast.makeText(this, "HOME | BOARD", Toast.LENGTH_SHORT).show();
                break;

            case R.id.nav_cohorts:
                Toast.makeText(this, "COHORTS", Toast.LENGTH_SHORT).show();
                break;

            case R.id.nav_find_cohorts:
                Toast.makeText(this, "FIND COHORTS", Toast.LENGTH_SHORT).show();
                break;

           // case R.id.nav_board:
            //    Toast.makeText(this, "ADD TILES", Toast.LENGTH_SHORT).show();
            //    break;

            case R.id.nav_memorans:
                Toast.makeText(this, "MEMORANS", Toast.LENGTH_SHORT).show();
                break;

            case R.id.nav_settings:
                Toast.makeText(this, "SETTINGS", Toast.LENGTH_SHORT).show();
                break;

            case R.id.nav_logout:
                Toast.makeText(this, "LOGOUT", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}