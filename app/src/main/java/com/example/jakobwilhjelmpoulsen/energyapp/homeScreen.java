package com.example.jakobwilhjelmpoulsen.energyapp;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by jakobwilhjelmpoulsen on 23/03/2016.
 */
public class homeScreen extends AppCompatActivity {
    String applName;
    double wattCalc;
    double timeCalc;
    double kwhCalc;
    double rateCalc;
    double priceCalc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        Typeface custom_font = Typeface.createFromAsset(getAssets(), "BodoniFLF-Bold.ttf");
        TextView header = (TextView) findViewById(R.id.HeadLine);
        header.setTypeface(custom_font);

    }

    public void onButtonClick(View v) {
        // to switch to that button, that the user clicks
        switch (v.getId()) {
            case R.id.button:
                EditText e1 = (EditText) findViewById(R.id.editTextApplianceName);
                EditText e2 = (EditText) findViewById(R.id.editTextWatt);
                EditText e3 = (EditText) findViewById(R.id.editTextTimeUsed);
                EditText e4 = (EditText) findViewById(R.id.editTextRatePrice);

                applName = e1.getText().toString();
                wattCalc = Double.parseDouble(e2.getText().toString());
                timeCalc = Double.parseDouble(e3.getText().toString());
                rateCalc = Double.parseDouble(e4.getText().toString());
                kwhCalc = (wattCalc) / (1000) * (timeCalc);
                priceCalc = (rateCalc) * (kwhCalc) / (100);

                Intent i = new Intent(homeScreen.this, displayAppliance.class);
                i.putExtra("applianceName",applName);
                i.putExtra("wattCalc", wattCalc);
                i.putExtra("timeCalc", timeCalc);
                i.putExtra("kwhCalc", kwhCalc);
                i.putExtra("rateCalc", rateCalc);
                i.putExtra("priceCalc", priceCalc);
                startActivity(i);
                break;

        }
    }
}
