package com.mfr414.intent;

import android.content.Intent;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.mfr414.intent.extra.MESSAGE";
    private EditText mMessageEditText;
    public static final String LOG_TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMessageEditText = findViewById(R.id.editText_main);
    }

    public void launchSecondActivity(View view) {
        Log.d(LOG_TAG,"Button clicked");
        Intent intent = new Intent(this,SecondActivity.class);
        startActivity(intent);
        String message = mMessageEditText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE,message);
    }

}
