package com.example.sai.majorproject.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.sai.majorproject.R;
import com.example.sai.majorproject.Utilities.UtilityMethods;

public class SplashScreenActivity extends AppCompatActivity {

    //splash screen timer
    private static int SPLASH_TIME_OUT=3000;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashscreen_layout);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                UtilityMethods.startNewActivity(SplashScreenActivity.this,ActivityMain.class);
                finish();
            }
        },SPLASH_TIME_OUT);

    }
}
