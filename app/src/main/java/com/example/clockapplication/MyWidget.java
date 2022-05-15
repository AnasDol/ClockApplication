package com.example.clockapplication;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.widget.RemoteViews;

import androidx.annotation.RequiresApi;

public class MyWidget extends AppWidgetProvider {

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onEnabled(Context context) {
        super.onEnabled(context);

        Intent intent = new Intent(context, ForegroundService.class);
        context.startService(intent);
        context.startForegroundService(intent);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        super.onUpdate(context, appWidgetManager, appWidgetIds);
        Intent intent = new Intent(context, ForegroundService.class);
        context.startService(intent);
        context.startForegroundService(intent);

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onRestored(Context context, int[] oldWidgetIds, int[] newWidgetIds) {
        super.onRestored(context, oldWidgetIds, newWidgetIds);
        Intent intent = new Intent(context, ForegroundService.class);
        context.startService(intent);
        context.startForegroundService(intent);
    }

    @Override
    public void onDeleted(Context context, int[] appWidgetIds) {
        super.onDeleted(context, appWidgetIds);
    }

    @Override
    public void onDisabled(Context context) {
        super.onDisabled(context);
    }

}