package com.icy.agropro;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity2 extends AppCompatActivity {

    Button crops_predict, weather_forecast, market_prices;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Snackbar.make(this.findViewById(android.R.id.content), "Welcome to AgroAssistant", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
        getSupportActionBar().setTitle("Smart AgroPro");


        crops_predict = findViewById(R.id.cropPrediction);
        weather_forecast = findViewById(R.id.weatherForecast);
        market_prices = findViewById(R.id.marketPrices);

        crops_predict.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity2.this,CropPredictionLandingPage1.class));
            }
        });
        weather_forecast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity2.this,WeatherForecast.class));
            }
        });
        market_prices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity2.this,MarketPrices.class));
            }
        });


    }
}