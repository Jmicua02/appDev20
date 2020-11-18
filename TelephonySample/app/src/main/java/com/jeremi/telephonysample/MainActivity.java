package com.jeremi.telephonysample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnSms(View view) {
        Intent intentSms= new Intent(this, qwerty.class);
        startActivity(intentSms);
    }

    public void btnDial(View view) {
        Intent intentDial= new Intent(this, callActivity.class);
        startActivity(intentDial);
    }
}