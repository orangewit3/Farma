package com.example.myapplication;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class UserInputInformation extends AppCompatActivity {

    public User users;
    public int[] weights;
    //private Analysis;
    SellerInputInformation inputStuff = new SellerInputInformation();
    ArrayList<Seller> sellers = inputStuff.allSellers;
    public Seller[] sellersToRank;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionnaire);
        Button submitButton = findViewById(R.id.sumbitButton);
        submitButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                onSubmitButtonClick();
            }
        });
    }

    public void onSubmitButtonClick() {

        TextView priceText = findViewById(R.id.priceField);
        double price = Double.parseDouble(priceText.getText().toString());

        TextView urgencyText = findViewById(R.id.urgencyField);
        int urgency = Integer.parseInt(urgencyText.getText().toString());

        Switch gmoText = findViewById(R.id.gmoField);
        boolean gmo = Boolean.parseBoolean(gmoText.getText().toString());

        TextView distanceText = findViewById(R.id.locationField);
        String location = (distanceText.getText().toString());

        TextView priceTextImp = findViewById(R.id.priceImportanceField);
        int priceImp = Integer.parseInt(priceTextImp.getText().toString());

        TextView urgencyTextImp = findViewById(R.id.urgencyImportanceField);
        int urgencyImp = Integer.parseInt(urgencyTextImp.getText().toString());

        TextView gmoTextImp = findViewById(R.id.gmoImportanceField);
        int gmoImp = Integer.parseInt(gmoTextImp.getText().toString());

        TextView distanceTextImp = findViewById(R.id.locationImportanceField);
        int distanceImp = Integer.parseInt(distanceTextImp.getText().toString());

        users = new User(urgency,location,price,gmo);
        Analysis a = new Analysis();
        HashMap<String,Double> match = a.calculateWeightedMap(gmoImp,priceImp,urgencyImp,distanceImp);
        double[] weights = a.findWeights(location,priceImp,gmo,urgency);
        Seller[] sellersValues = sellers.toArray(new Seller[sellers.size()]);
        sellersToRank = a.sellerWeightGenerator(sellersValues, users, weights, match);
        startActivity(new Intent(UserInputInformation.this, MainActivity.class));
    }
}
