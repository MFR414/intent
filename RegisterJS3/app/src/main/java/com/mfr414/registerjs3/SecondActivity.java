package com.mfr414.registerjs3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.mfr414.registerjs3.MESSAGE";
    protected String nameView;
    protected String addressView;
    protected String phoneView;
    String title = "Share via";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent = getIntent();
        String name = intent.getStringExtra(MainActivity.EXTRA_NAME);
        String address = intent.getStringExtra(MainActivity.EXTRA_ADDRESS);
        String phone = intent.getStringExtra(MainActivity.EXTRA_PHONE);
        TextView tvName = findViewById(R.id.nameView);
        TextView tvAddress = findViewById(R.id.addressView);
        TextView tvPhone = findViewById(R.id.phoneView);
        tvName.setText(name);
        tvAddress.setText(address);
        tvPhone.setText(phone);
        nameView = tvName.getText().toString();
        addressView = tvAddress.getText().toString();
        phoneView = tvPhone.getText().toString();
    }

    public void Share(View view) {
        Intent intentshare = new Intent(Intent.ACTION_SEND);
        intentshare.setType("text/plain");
        String share_Message = "Name = "+nameView+".Address = "+addressView+".Phone "+phoneView;
        intentshare.putExtra(EXTRA_MESSAGE,share_Message);
        startActivity(intentshare);
    }
}
