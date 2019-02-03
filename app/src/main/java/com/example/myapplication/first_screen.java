package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class first_screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_screen);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button farmer = findViewById(R.id.farmer);
        System.out.println(farmer);

        farmer.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(first_screen.this, SellerInputInformation.class));
            }
        });

        Button Buyer = findViewById(R.id.buyer);
        System.out.println(Buyer);

        Buyer.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(first_screen.this, UserInputInformation.class));
            }
        });
    }

}
