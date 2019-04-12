package com.mfr414.mencobaintent;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    String linkAddress;
    TextView displayLink;
    Button btnOpenLink;
    Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intentDisplay = getIntent();

        displayLink = findViewById(R.id.linkDisplay);
        btnOpenLink = findViewById(R.id.buttonOpenLink);
        btnBack = findViewById(R.id.buttonBack);

        linkAddress = intentDisplay.getStringExtra(MainActivity.EXTRA_LINK);

        displayLink.setText(linkAddress);
    }

    public void openLink(View v){
        String url = "http://" + displayLink.getText().toString();
        Uri website = Uri.parse(url);
        Intent intentOpenLink = new Intent(Intent.ACTION_VIEW,website);
        startActivity(intentOpenLink);
    }

    public void backToPrevActivity(View v){
        Intent intentActivityBack = new Intent(this,MainActivity.class);
        startActivity(intentActivityBack);
    }
}
