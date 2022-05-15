package com.example.clockapplication;

import android.appwidget.AppWidgetManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class TimeBroadcastReceiver extends BroadcastReceiver {

    private static String datetime;
    private Format formatter;

    public TimeBroadcastReceiver() {
        formatter = new SimpleDateFormat("MMM dd yyyy a hh mm", new Locale("eng"));
        datetime = formatter.format(new Date());
    }

    @Override
    public void onReceive(Context context, Intent intent) {

        datetime = formatter.format(new Date());
        System.out.println(datetime);

        MainActivity.updateTime(datetime);

        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
        ComponentName thisWidget = new ComponentName(context,MyWidget.class);
        int[] appWidgetIds = appWidgetManager.getAppWidgetIds(thisWidget);

        for (int appWidgetId:appWidgetIds) {
            RemoteViews view = new RemoteViews(context.getPackageName(), R.layout.widget);
            view.setTextViewText(R.id.presentTimeTextView_widget, datetime);
            appWidgetManager.updateAppWidget(appWidgetId, view);
        }
    }

    public static String getDatetime() {
        return datetime;
    }
}
