package com.example.alemne.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.alemne.MainActivity;
import com.example.alemne.R;

public class SplashScreen extends AppCompatActivity {
    final static int SPLASH_TIME = 2000; //This is 2 seconds

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(i);

                // close this activity

                finish();

            }
        },SPLASH_TIME);
    }
}