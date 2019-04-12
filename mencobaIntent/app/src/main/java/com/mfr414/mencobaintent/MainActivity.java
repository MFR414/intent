package com.mfr414.mencobaintent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_LINK = "com.mfr414.mencobaintent.LINK";
    String linkName;
    EditText addLink;
    Button btnDisplayLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addLink = findViewById(R.id.addLink);
        btnDisplayLink = findViewById(R.id.buttonNextActivity);
    }

    public void displayLink(View v){
        linkName = addLink.getText().toString();
        if(addLink.getText().toString() != null){
            Intent intentDisplay = new Intent(this,SecondActivity.class);
            intentDisplay.putExtra(EXTRA_LINK,linkName);
            startActivity(intentDisplay);
        }else{
            Toast.makeText(this,"Error,Can't transfer Link name",Toast.LENGTH_SHORT);
        }
    }
}
