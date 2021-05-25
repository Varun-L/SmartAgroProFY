package com.icy.agropro;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.sucho.placepicker.AddressData;
import com.sucho.placepicker.Constants;
import com.sucho.placepicker.MapType;

import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;

public class CropPredictionBasic extends AppCompatActivity {

//    13.6288, 79.4192 In case

    String lat,lon;
    Button pick_location , submit_button;
    TextView text_location , text_result;
    EditText ph_land, area_sq, rainfall_land;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crop_prediction_basic);

        pick_location = findViewById(R.id.pickLocation);
        submit_button = findViewById(R.id.submitButton);
        text_location = findViewById(R.id.textLocationPick);
        text_result = findViewById(R.id.textViewResult);
        ph_land = findViewById(R.id.pHLand);
        area_sq = findViewById(R.id.inputLandArea);
        rainfall_land = findViewById(R.id.rainFallLand);

        pick_location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new HelperUtilityVolley().getPlacePickerIntent(CropPredictionBasic.this);
                startActivityForResult(intent, 1);

            }
        });
        submit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HelperUtilityVolley helperUtilityVolley = new HelperUtilityVolley();

                String ph1 = ph_land.getText().toString();
                String asq1 = area_sq.getText().toString();
                String rainfall1 = rainfall_land.getText().toString();
                helperUtilityVolley.letVolleyCropPredictionBasic(lat,lon,ph1,rainfall1,asq1,text_result,CropPredictionBasic.this);
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
                text_location.setVisibility(View.VISIBLE);
                text_location.setText(stringBuilder);


            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }


    }
