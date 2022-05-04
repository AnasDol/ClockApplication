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
    private static TextView presentTimeTextView_widget;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presentTimeTextView = findViewById(R.id.presentTimeTextView);
        presentTimeTextView_widget = findViewById(R.id.presentTimeTextView_widget);
        Intent intent = new Intent(this, ForegroundService.class);
        startService(intent);
        startForegroundService(intent);

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void click(View view) {
        System.out.println("click");
        Intent i=new Intent(this, ForegroundService.class);
        if (view.getId()==R.id.start) {
            startService(i);
            startForegroundService(i);
        }
        else {
            stopService(i);
        }
    }

    public static void updateTime(String text) {
        presentTimeTextView.setText(text);
        //presentTimeTextView_widget.setText(text);
    }
}