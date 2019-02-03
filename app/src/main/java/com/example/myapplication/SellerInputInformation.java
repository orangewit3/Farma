package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ToggleButton;

import java.util.ArrayList;

public class SellerInputInformation extends AppCompatActivity {

    public static ArrayList<Seller> allSellers = new ArrayList<>();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farmers_input);
        Button submitButton = findViewById(R.id.Submit);
        submitButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                onSubmitButtonClick();
            }
        });
    }

    public void onSubmitButtonClick() {
        String typeOfFood = "";
        boolean isGMO = false;
        String locationString;
        double cost;
        int days;

        CheckBox corn = findViewById(R.id.checkBox);
        CheckBox soybean = findViewById(R.id.checkBox2);
        CheckBox wheat = findViewById(R.id.checkBox3);
        if (corn.isChecked()) {
            typeOfFood = "Corn";
        }
        if (soybean.isChecked()) {
            typeOfFood = "Soybean";
        }
        if (wheat.isChecked()) {
            typeOfFood = "Wheat";
        }
        ToggleButton yesOrNo = findViewById(R.id.toggleButton2);
        if (yesOrNo.isChecked()) {
            isGMO = true;
        }
        EditText location = findViewById(R.id.location);
        locationString = location.getText().toString();
        EditText price = findViewById(R.id.price);
        cost = Double.parseDouble(price.getText().toString());
        EditText timeTaken = findViewById(R.id.transportationcost);
        days = Integer.parseInt(timeTaken.getText().toString());
        Crop newCrop = new Crop(typeOfFood, cost, isGMO, days);
        Seller seller = new Seller("Roger", locationString, newCrop);
        allSellers.add(seller);
        startActivity(new Intent(SellerInputInformation.this, MainActivity.class));
    }

}
