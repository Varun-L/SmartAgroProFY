package com.icy.agropro;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;
import com.sucho.placepicker.AddressData;
import com.sucho.placepicker.Constants;

import org.jetbrains.annotations.Nullable;

public class WeatherForecast extends AppCompatActivity {

    String lat, lon;
    TextView pick_location_text, result_text;
    Button pick_location, get_current_weather, get_weather_forecast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_forecast);

        Snackbar.make(this.findViewById(android.R.id.content), "Weather Forecast : You can check the hourly changes in climatic conditions.", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();

        getSupportActionBar().setTitle("Weather Forecast");

        pick_location = findViewById(R.id.pickLocation);
        get_current_weather = findViewById(R.id.get_current_climate_det);
        get_weather_forecast = findViewById(R.id.get_weather_forecast_det);
        result_text = findViewById(R.id.textView3_result_text);
        pick_location_text = findViewById(R.id.textLocationPick);

        pick_location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new HelperUtilityVolley().getPlacePickerIntent(WeatherForecast.this);
                startActivityForResult(intent, 1);
            }
        });

        get_current_weather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HelperUtilityVolley helperUtilityVolley = new HelperUtilityVolley();
                helperUtilityVolley.letVolley(0,lat,lon,result_text,WeatherForecast.this);

            }
        });

        get_weather_forecast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HelperUtilityVolley helperUtilityVolley = new HelperUtilityVolley();
                helperUtilityVolley.letVolley(1,lat,lon,result_text,WeatherForecast.this);

            }
        });


    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK && data != null) {
                AddressData addressData = data.getParcelableExtra(Constants.ADDRESS_INTENT);

                String address;
                lat=String.valueOf(addressData.getLatitude());
                lon=String.valueOf(addressData.getLongitude());
                address= String.valueOf(addressData.component3().get(0).getAddressLine(0));


                String stringBuilder = "Selected Location: \n LATITUDE : "+lat+"\n LONGITUDE : "+lon;
                stringBuilder+="\n Address : "+address;
                pick_location_text.setVisibility(View.VISIBLE);
                pick_location_text.setText(stringBuilder);


            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }


}