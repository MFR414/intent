package com.mfr414.cobaintent;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    String Link;
    TextView LinkDisplay;
    Button btnOpenLink;
    Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent terimaIntent = getIntent();
        Link = terimaIntent.getStringExtra(MainActivity.EXTRA_LINK);

        LinkDisplay = findViewById(R.id.viewLink);
        btnOpenLink = findViewById(R.id.buttonOpenLink);
        btnBack = findViewById(R.id.buttonBack);

        LinkDisplay.setText(Link);
    }

    public void openLink(View v){
        Uri website = Uri.parse(Link);
        Intent intentOpenLink = new Intent(Intent.ACTION_VIEW,website);
        if(intentOpenLink.resolveActivity(getPackageManager()) != null){
            startActivity(intentOpenLink);
        }else{
            Log.d("implicitIntentError","Implicit Intent is Error,Please chack the code");
        }
    }

    public void backToFirstActivity(View v){
        Intent backIntent = new Intent(this,MainActivity.class);
        startActivity(backIntent);
    }
}
