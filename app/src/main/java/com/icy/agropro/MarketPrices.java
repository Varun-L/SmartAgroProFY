package com.icy.agropro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

public class MarketPrices extends AppCompatActivity {

    Button get_market_prices;
    EditText code;
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market_prices);

        Snackbar.make(this.findViewById(android.R.id.content), "Market Prices : Current Market Prices of various commodities.", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
        getSupportActionBar().setTitle("Current Market Prices");

        get_market_prices = findViewById(R.id.get_market_prices_data);
        code = findViewById(R.id.editTextNumberSigned);
        webView = findViewById(R.id.webView1);

        get_market_prices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HelperUtilityVolley helperUtilityVolley = new HelperUtilityVolley();
                helperUtilityVolley.letVolleyWeb(99,code.getText().toString(),"b",webView,MarketPrices.this);

            }
        });


    }
}