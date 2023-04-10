package com.example.bshop1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity2 extends AppCompatActivity {
    BottomNavigationView btnv ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        anhXa();
        btnv.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.menuHome:{
                        Toast.makeText(MainActivity2.this, "home", Toast.LENGTH_SHORT).show();
                        break;
                    }
                    case R.id.menuCart:{
                        Toast.makeText(MainActivity2.this, "gio ham", Toast.LENGTH_SHORT).show();
                        break;
                    }
                    case R.id.menuMy:{
                        Toast.makeText(MainActivity2.this, "my", Toast.LENGTH_SHORT).show();
                        break;
                    }
                }
                return false;
            }
        });
    }
    public void anhXa(){
        btnv = findViewById(R.id.btnv);
    }
}