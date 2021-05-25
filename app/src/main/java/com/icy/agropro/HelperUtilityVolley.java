package com.icy.agropro;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.text.Html;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.sucho.placepicker.MapType;

public class HelperUtilityVolley {


    public void letVolley(int opcode, String latitude_, String longitude_, TextView textView, Activity activity){

        String url="https://original-agro-pro.herokuapp.com";
//        url="http:192.168.0.101:5000";
        switch (opcode){
            case 0:
//                Current Climate Data
                url += "/api_climate?lat="+latitude_+"&lon="+longitude_;

                break;
            case 1:
//                Weather Forecast Data
                url += "/api_weather_forecast?lat="+latitude_+"&lon="+longitude_;
                break;

            case 99:
//                Experimental
                url += "/api_experimental?code="+latitude_;
                break;
            default:
                url += "/api_test?lat="+latitude_+"&lon="+longitude_;

        }

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        textView.setVisibility(View.VISIBLE);
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){
                            textView.setText(Html.fromHtml(response,Html.FROM_HTML_MODE_COMPACT));
                        }
                        else{
                            textView.setText(Html.fromHtml(response));
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(activity, "Something Went Wrong"+error.toString()+error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
        RequestQueue requestQueue = Volley.newRequestQueue(activity);
        requestQueue.add(stringRequest);

    }

    public void letVolleyWeb(int opcode, String latitude_, String longitude_, WebView webView, Activity activity){

        String url="https://original-agro-pro.herokuapp.com";
//        url="http://192.168.0.101:5000";

        switch (opcode){
            case 2:
//                How To Use
                url+="/api_how_to_use";
                break;

            case 99:
//                Experimental
                url += "/api_experimental?code="+latitude_;
                break;
            default:
                url += "/api_test?lat="+latitude_+"&lon="+longitude_;

        }

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                         webView.loadData(response,"text/html","utf-8");
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(activity, "Something Went Wrong"+error.toString()+error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
        RequestQueue requestQueue = Volley.newRequestQueue(activity);
        requestQueue.add(stringRequest);

    }

    public void letVolleyCropPredictionBasic(String latitude_, String longitude_, String pHSoil, String rainfallLand, String landArea ,TextView textView, Activity activity){

        String url="https://original-agro-pro.herokuapp.com/api_crop_prediction_basic";
        url+="?lat="+latitude_+"&lon="+longitude_;
        url += "&ph_soil="+pHSoil+"&rainfall="+rainfallLand+"&area_sq="+landArea;
//        url="http:192.168.0.101:5000";

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        textView.setVisibility(View.VISIBLE);
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){
                            textView.setText(Html.fromHtml(response,Html.FROM_HTML_MODE_COMPACT));
                        }
                        else{
                            textView.setText(Html.fromHtml(response));
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(activity, "Something Went Wrong"+error.toString()+error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
        RequestQueue requestQueue = Volley.newRequestQueue(activity);
        requestQueue.add(stringRequest);

    }
    public void letVolleyCropPredictionAdvanced(String latitude_, String longitude_, String N1, String P1, String K1, String pHSoil, String rainfallLand, String landArea ,TextView textView, Activity activity){

        String url="https://original-agro-pro.herokuapp.com/api_crop_prediction_advanced";
        url+="?lat="+latitude_+"&lon="+longitude_;
        url += "&N="+N1+"&P="+P1+"&K="+K1;
        url += "&ph_soil="+pHSoil+"&rainfall="+rainfallLand+"&area_sq="+landArea;
//        url="http:192.168.0.101:5000";

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        textView.setVisibility(View.VISIBLE);
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){
                            textView.setText(Html.fromHtml(response,Html.FROM_HTML_MODE_COMPACT));
                        }
                        else{
                            textView.setText(Html.fromHtml(response));
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(activity, "Something Went Wrong"+error.toString()+error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
        RequestQueue requestQueue = Volley.newRequestQueue(activity);
        requestQueue.add(stringRequest);

    }

    public Intent getPlacePickerIntent(Activity activity){
        return new com.sucho.placepicker.PlacePicker.IntentBuilder()
                .setLatLong(13.6288, 79.4192)  // Initial Latitude and Longitude the Map will load into
                .showLatLong(true)  // Show Coordinates in the Activity
                .setMapZoom(14.0f)  // Map Zoom Level. Default: 14.0
                .setAddressRequired(true) // Set If return only Coordinates if cannot fetch Address for the coordinates. Default: True
                .hideMarkerShadow(true) // Hides the shadow under the map marker. Default: False
//                        .setMarkerDrawable(R.drawable.s13) // Change the default Marker Image
//                        .setMarkerImageImageColor(R.color.colorPrimary)
                .setFabColor(R.color.quantum_purple)
                .setPrimaryTextColor(R.color.colorPrimary) // Change text color of Shortened Address
                .setSecondaryTextColor(R.color.colorAccent) // Change text color of full Address
                .setBottomViewColor(R.color.design_default_color_background) // Change Address View Background Color (Default: White)
                .setMapRawResourceStyle(R.raw.mapstylestandard)  //Set Map Style (https://mapstyle.withgoogle.com/)
                .setMapType(MapType.NORMAL)
//                        .setPlaceSearchBar(false,"") //Activate GooglePlace Search Bar. Default is false/not activated. SearchBar is a chargeable feature by Google
//                        .onlyCoordinates(true)  //Get only Coordinates from Place Picker
                .hideLocationButton(true)   //Hide Location Button (Default: false)
//                        .disableMarkerAnimation(true)   //Disable Marker Animation (Default: false)
                .build(activity);
    }
}
