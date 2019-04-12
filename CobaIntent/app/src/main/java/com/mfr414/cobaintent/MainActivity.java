package com.mfr414.cobaintent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editLink;
    Button btnNextActivity;
    public static final String EXTRA_LINK = "com.mfr414.cobaintent.LINK";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editLink = findViewById(R.id.editLinkWebsite);
        btnNextActivity = findViewById(R.id.buttonNextActivity);
    }

    public void kirimDataKeActivityLain(View v){
        String textLink = editLink.getText().toString();
        if(textLink != null){
            Intent intentKirim = new Intent(this,SecondActivity.class);
            intentKirim.putExtra(EXTRA_LINK,textLink);
            startActivity(intentKirim);
        }else{
            Toast.makeText(this,"Error, text is empty",Toast.LENGTH_SHORT);
        }
    }
}
