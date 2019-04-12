package com.mfr414.intenttestforvlog;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_LINK = "com.mfr414.intenttestforvlog.LINK";
    EditText link;
    Button btnNextActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        link = findViewById(R.id.editLinkWebsite);
        btnNextActivity = findViewById(R.id.buttonNextActivity);
    }

    public void ShareToNextActivity(View v){
        String LinkWebsite = link.getText().toString();
        if(LinkWebsite.matches("")){
            Toast.makeText(this,"Link is Empty",Toast.LENGTH_SHORT);
        }else{
            Intent intentPass = new Intent(this,SecondActivity.class);
            intentPass.putExtra(EXTRA_LINK,LinkWebsite);
            startActivity(intentPass);
        }
    }
}
