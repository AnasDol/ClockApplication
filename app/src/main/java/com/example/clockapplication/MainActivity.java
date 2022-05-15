package com.example.clockapplication;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private static TextView presentTimeTextView;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent(this, ForegroundService.class);
        startService(intent);
        startForegroundService(intent);

        presentTimeTextView = findViewById(R.id.presentTimeTextView);

    }

    public static void updateTime(String text) {
        presentTimeTextView.setText(text);
    }
}