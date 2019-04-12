package com.mfr414.registerjs3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_NAME = "com.mfr414.registerjs3.NAME";
    public static final String EXTRA_PHONE = "com.mfr414.registerjs3.PHONE";
    public static final String EXTRA_ADDRESS = "com.mfr414.registerjs3.ADDRESS";
    private EditText nameEditText;
    private EditText addressEditText;
    private EditText phoneEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nameEditText = findViewById(R.id.name_EditText);
        addressEditText = findViewById(R.id.address_EditText);
        phoneEditText = findViewById(R.id.phone_editText);

    }
    public void sendMessage(View v){
        Intent intent = new Intent(this,SecondActivity.class);
        String name = nameEditText.getText().toString();
        String address = addressEditText.getText().toString();
        String phone = phoneEditText.getText().toString();
        if(name.matches("")){
            Toast.makeText(this,"Enter Your Name",Toast.LENGTH_SHORT).show();
            if(address.matches("")){
                Toast.makeText(this,"Enter Your Address",Toast.LENGTH_SHORT).show();
                if(phone.matches("")){
                    Toast.makeText(this,"Enter Your Phonenumber",Toast.LENGTH_SHORT).show();
                    return;
                }
                return;
            }
            return;
        }else {
            intent.putExtra(EXTRA_NAME,name);
            intent.putExtra(EXTRA_ADDRESS,address);
            intent.putExtra(EXTRA_PHONE,phone);
            startActivity(intent);
        }
    }
}
