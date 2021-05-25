package com.icy.agropro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.snackbar.Snackbar;

public class CropPredictionLandingPage1 extends AppCompatActivity {


    Button crop_prediction_b , crop_prediction_a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crop_prediction_landing_page1);

        Snackbar.make(this.findViewById(android.R.id.content), "Crop Prediction : Know which crops are most suitable to grow for your farm.", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();

        getSupportActionBar().setTitle("Smart Crop Prediction");


        crop_prediction_b = findViewById(R.id.cropPredictionBasic);
        crop_prediction_a = findViewById(R.id.cropPredictionAdvanced);

        crop_prediction_a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(CropPredictionLandingPage1.this,CropPredictionAdvanced.class));

            }
        });

        crop_prediction_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CropPredictionLandingPage1.this,CropPredictionBasic.class));

            }
        });

    }
}