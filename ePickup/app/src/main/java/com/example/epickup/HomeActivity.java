package com.example.epickup;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.epickup.ui.login.LoginActivity;
import com.example.epickup.DatabaseHelper;

public class HomeActivity extends AppCompatActivity {
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        databaseHelper = new DatabaseHelper(HomeActivity.this);

        final Button logoutButton = findViewById(R.id.logoutButton);
        final Button profileButton = findViewById(R.id.viewProfileButton);
        final Button addOrEditItemsButton = findViewById(R.id.addOrEditItemsButton);
        final Button viewOrdersButton = findViewById(R.id.viewOrdersButton);
        final Button searchRestaurantButton = findViewById(R.id.searchRestaurantButton);


        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                DatabaseHelper databaseHelper = new DatabaseHelper(HomeActivity.this);
                boolean logoutSuccess = databaseHelper.logout(true);
                if(logoutSuccess) {
                    Intent goIntent = new Intent(HomeActivity.this, LoginActivity.class);
                    startActivity(goIntent);
                } else {
                    Toast.makeText(getApplicationContext(),"Logout Failed.",Toast.LENGTH_LONG).show();
                }
            }
        });


        profileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent goIntent = new Intent(HomeActivity.this, ProfileActivity.class);
                startActivity(goIntent);
            }
        });

        addOrEditItemsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent goIntent = new Intent(HomeActivity.this, AddOrEditItemsActivity.class);
                startActivity(goIntent);
            }
        });

        viewOrdersButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent goIntent = new Intent(HomeActivity.this, ViewOrdersActivity.class);
                startActivity(goIntent);
            }
        });

        searchRestaurantButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent goIntent = new Intent(HomeActivity.this, SearchRestaurantActivity.class);
                startActivity(goIntent);
            }
        });

    }
}