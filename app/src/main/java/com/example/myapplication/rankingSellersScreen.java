package com.example.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class rankingSellersScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void displayInformation() {
        UserInputInformation UI = new UserInputInformation();
        Seller[] sellers = UI.sellersToRank;
        TextView seller1 = findViewById(R.id.textView2);
        TextView seller2 = findViewById(R.id.textView3);
        TextView seller3 = findViewById(R.id.textView4);
        String seller1Summary = sellers[0].getName() + " " + sellers[0].getLocation() + " " + String.valueOf(sellers[0].getCrop().getCost());
        seller1.setText(seller1Summary);
        String seller2Summary = sellers[0].getName() + " " + sellers[0].getLocation() + " " + String.valueOf(sellers[0].getCrop().getCost());
        seller2.setText(seller2Summary);
        String seller3Summary = sellers[0].getName() + " " + sellers[0].getLocation() + " " + String.valueOf(sellers[0].getCrop().getCost());
        seller3.setText(seller3Summary);
    }
}
