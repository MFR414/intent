package com.mfr414.implicitintent;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText mWebEditText;
    private EditText mLocEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mWebEditText = findViewById(R.id.web_EditText);
        mLocEditText = findViewById(R.id.openLocation_edittext);
    }

     public void openWebsite(View v){
        String url = mWebEditText.getText().toString();
         Uri webpage = Uri.parse(url);
         Intent intent =new Intent(Intent.ACTION_VIEW,webpage);
         if(intent.resolveActivity(getPackageManager()) != null){
             startActivity(intent);
         }else{
             Log.d("ImplicitIntents","Can't Handle This!!");
         }
     }

    public void openLocation(View view) {
        String Loc = mLocEditText.getText().toString();
        Uri addressUri = Uri.parse("geo:0,0?q=" + Loc);
        Intent intentLoc = new Intent(Intent.ACTION_VIEW,addressUri);
        if(intentLoc.resolveActivity(getPackageManager()) != null){
            startActivity(intentLoc);
        }else{
            Log.d("ImplicitIntents","Can't Handle This!!");
        }
    }
}
