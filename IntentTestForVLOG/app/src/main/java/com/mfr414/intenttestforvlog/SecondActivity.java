package com.mfr414.intenttestforvlog;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    String LinkFromMain;
    TextView tvLink;
    Button btnOpenLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent = getIntent();
        LinkFromMain = intent.getStringExtra(MainActivity.EXTRA_LINK);
        tvLink = findViewById(R.id.textViewLink);
        tvLink.setText(LinkFromMain);
        btnOpenLink = findViewById(R.id.buttonOpen);
    }

    public void openLink(View v){
        String url = tvLink.getText().toString();
        Uri webpage = Uri.parse(url);
        Intent intentOpen = new Intent(Intent.ACTION_VIEW,webpage);
        if(intentOpen.resolveActivity(getPackageManager())!= null){
            startActivity(intentOpen);
        }else{
            Toast.makeText(this,"Error to open Website",Toast.LENGTH_SHORT);
            Log.d("Url",tvLink.getText().toString());
        }
    }

    public void backToFirstActivity(View v){
        Intent intentBackActivity = new Intent(this,MainActivity.class);
        startActivity(intentBackActivity);
    }
}
