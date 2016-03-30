package com.example.jakobwilhjelmpoulsen.energyapp;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by jakobwilhjelmpoulsen on 23/03/2016.
 */
public class displayAppliance extends homeScreen {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_appliance);

        Typeface custom_font = Typeface.createFromAsset(getAssets(), "BodoniFLF-Bold.ttf");
        TextView header = (TextView) findViewById(R.id.HeadLine);
        TextView applianceHeader = (TextView) findViewById(R.id.ApplianceNameHeader);
        header.setTypeface(custom_font);
        applianceHeader.setTypeface(custom_font);

        Intent i = getIntent();
        Bundle databundle = i.getExtras();

        // sets the headline for the appliance name, on the new activity

        String applName = databundle.getString("applianceName");
        Double wattCalc = databundle.getDouble("wattCalc");
        Double timeCalc = databundle.getDouble("timeCalc");
        Double kwhCalc = databundle.getDouble("kwhCalc");
        Double rateCalc = databundle.getDouble("rateCalc");
        Double priceCalc = databundle.getDouble("priceCalc");

        TextView t2 = (TextView) findViewById(R.id.watt);
        TextView t3 = (TextView) findViewById(R.id.timeUsed);
        TextView t4 = (TextView) findViewById(R.id.ratePrice);
        TextView t5 = (TextView) findViewById(R.id.totalPrice);
        TextView t6 = (TextView) findViewById(R.id.bottomLine);

        TextView HeadLineAppliance = (TextView) findViewById((R.id.ApplianceNameHeader));
        HeadLineAppliance.setText(applName + " info");

        t2.setText(applName + " watt: " + (wattCalc));
        t3.setText(applName + " uses: " + Double.toString((kwhCalc) / (timeCalc)) + " kilowatts pr. hour");
        t4.setText("Your watt rate is: " + Double.toString(rateCalc) + " øre pr. kWh");
        t5.setText(applName + " cost you: " + Double.toString(priceCalc) + " kr pr. day" +
                "\n" + applName + " cost you: " + Double.toString((priceCalc) * 30) + " kr pr. month" +
                "\n" + applName + " cost you: " + Double.toString((priceCalc) * 365) + " kr pr. year");
        t6.setText("Thats Whatt'sUp!");
    }
}
