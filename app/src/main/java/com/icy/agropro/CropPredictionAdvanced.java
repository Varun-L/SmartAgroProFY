package com.icy.agropro;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.sucho.placepicker.AddressData;
import com.sucho.placepicker.Constants;
import com.sucho.placepicker.MapType;

import org.jetbrains.annotations.Nullable;

public class CropPredictionAdvanced extends AppCompatActivity {


    String lat,lon;
    Button pick_location , submit_button;
    TextView text_location , text_result;
    EditText ph_land, area_sq, rainfall_land,N1,P1,K1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crop_prediction_advanced);

        pick_location = findViewById(R.id.pickLocation);
        submit_button = findViewById(R.id.submitButton);
        text_location = findViewById(R.id.textLocationPick);
        text_result = findViewById(R.id.textViewResult);
        ph_land = findViewById(R.id.pHLand);
        area_sq = findViewById(R.id.inputLandArea);
        rainfall_land = findViewById(R.id.rainFallLand);
        N1 = findViewById(R.id.nitrogen);
        P1 = findViewById(R.id.phosphorous);
        K1 = findViewById(R.id.potassium);

        pick_location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new HelperUtilityVolley().getPlacePickerIntent(CropPredictionAdvanced.this);
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
                String n1 = N1.getText().toString();
                String p1 = P1.getText().toString();
                String k1 = K1.getText().toString();

                helperUtilityVolley.letVolleyCropPredictionAdvanced(lat,lon,n1,p1,k1,ph1,rainfall1,asq1,text_result,CropPredictionAdvanced.this);


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