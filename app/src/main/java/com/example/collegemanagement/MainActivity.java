package com.example.collegemanagement;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.provider.Settings;
import android.view.MenuItem;
import android.widget.FrameLayout;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
Toolbar ToolBar;
BottomNavigationView BottomNavigationView;
DrawerLayout drawerLayout;
NavigationView NavigationView;
FrameLayout FrameLayout;
ActionBarDrawerToggle actionBarDrawerToggle;
LoginDataBase dataBase;
SessionManagerSharePreference sessionManagerSharePreference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        sessionManagerSharePreference = new SessionManagerSharePreference(getApplicationContext());
        getSupportFragmentManager().beginTransaction().replace(R.id.FrameLayout,new HomeFragment()).commit();

         ToolBar = findViewById(R.id.ToolBar);
         drawerLayout = findViewById(R.id.drawerLayout);
         NavigationView = findViewById(R.id.NavigationView);
         BottomNavigationView = findViewById(R.id.BottomNavigationView);
         FrameLayout = findViewById(R.id.FrameLayout);
         dataBase = new LoginDataBase(this);

         setSupportActionBar(ToolBar);
         actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,ToolBar,R.string.Open,R.string.Close);
         drawerLayout.addDrawerListener(actionBarDrawerToggle);
         actionBarDrawerToggle.syncState();
         drawerLayout.closeDrawer(GravityCompat.START);

         BottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
             @Override
             public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                 if (item.getItemId()==R.id.home){
                     getSupportFragmentManager().beginTransaction().replace(R.id.FrameLayout,new HomeFragment()).commit();
                     drawerLayout.closeDrawer(GravityCompat.START);
                 } else if (item.getItemId()==R.id.call) {
                     getSupportFragmentManager().beginTransaction().replace(R.id.FrameLayout,new CallFragment()).commit();
                 }
                 return true;
             }
         });

         NavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
             @Override
             public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    if (item.getItemId()==R.id.admin){
                        getSupportFragmentManager().beginTransaction().replace(R.id.FrameLayout,new AdminPasswordFragment()).commit();
                        drawerLayout.closeDrawer(GravityCompat.START);
                    }else if (item.getItemId()==R.id.phone) {
                     getSupportFragmentManager().beginTransaction().replace(R.id.FrameLayout,new TeacherCallFragment()).commit();
                     drawerLayout.closeDrawer(GravityCompat.START);
                    } else if (item.getItemId()==R.id.StudentCall) {
                        getSupportFragmentManager().beginTransaction().replace(R.id.FrameLayout,new TeacherCallStudentFragment()).commit();
                        drawerLayout.closeDrawer(GravityCompat.START);
                    } else if (item.getItemId()==R.id.camera) {
                        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                        startActivity(intent);
                        drawerLayout.closeDrawer(GravityCompat.START);
                    } else if (item.getItemId()==R.id.setting) {
                        Intent intent = new Intent(Settings.ACTION_SETTINGS);
                        startActivity(intent);
                        drawerLayout.closeDrawer(GravityCompat.START);
                    } else if (item.getItemId()==R.id.map){
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse("geo:"));
                        startActivity(intent);
                        drawerLayout.closeDrawer(GravityCompat.START);
                    } else if (item.getItemId()==R.id.share) {
                        Intent gall = new Intent(Intent.ACTION_SEND);
                        gall.setType("image/*");
                        gall.putExtra(Intent.EXTRA_TEXT,"Hello");
                        startActivity(gall);
                        drawerLayout.closeDrawer(GravityCompat.START);
                    } else if (item.getItemId()==R.id.logout) {
                        sessionManagerSharePreference.LogoutData();
                        startActivity(new Intent(MainActivity.this, LoginPages.class));
                        drawerLayout.closeDrawer(GravityCompat.START);
                    } else if (item.getItemId()==R.id.gallery) {
                        Intent intent = new Intent(Intent.ACTION_PICK);
                        intent.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                        startActivity(intent);
                    }
                 return true;
             }
         });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.drawerLayout), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder alertbuilder = new AlertDialog.Builder(this);
        alertbuilder.setTitle("EXIT");
        alertbuilder.setMessage("Do You Went To Exits This Application");
        alertbuilder.setIcon(R.drawable.baseline_exit_to_app_24);
        alertbuilder.setCancelable(false);
        alertbuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        alertbuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finishAffinity();
            }
        });
        alertbuilder.show();
    }
}