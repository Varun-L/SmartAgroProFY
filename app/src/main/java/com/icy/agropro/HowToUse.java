package com.icy.agropro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

public class HowToUse extends AppCompatActivity {

    TextView t1;
    WebView w1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_how_to_use);

        Snackbar.make(this.findViewById(android.R.id.content), "Thank You for using our App", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();

        getSupportActionBar().setTitle("How To Use");

        w1= findViewById(R.id.webView2_how_to_use);
        HelperUtilityVolley h = new HelperUtilityVolley();
        h.letVolleyWeb(2,"a","b",w1,HowToUse.this);

    }
}