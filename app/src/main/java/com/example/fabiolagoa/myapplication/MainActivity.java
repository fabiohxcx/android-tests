package com.example.fabiolagoa.myapplication;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CardView card = (CardView) findViewById(R.id.cardview);
        card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
/*                Toast.makeText(MainActivity.this, "Teste", Toast.LENGTH_SHORT).show();

                NotificationCompat.Builder mBuilder =
                        (NotificationCompat.Builder) new NotificationCompat.Builder(MainActivity.this)
                                .setSmallIcon(android.R.drawable.ic_menu_help)
                                .setContentTitle("My notification")
                                .setContentText("Hello World!");

                NotificationManager mNotificationManager =
                        (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                // mId allows you to update the notification later on.
                mNotificationManager.notify(0, mBuilder.build());*/


                Intent notificationIntent = new Intent(MainActivity.this, MainActivity.class);

                notificationIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
                        | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                //notificationIntent.setData(Uri.parse("http://www.google.com"));
                PendingIntent pi = PendingIntent.getActivity(MainActivity.this, 0, notificationIntent, 0);
                // Resources r = getResources();
                Notification notification = new NotificationCompat.Builder(MainActivity.this)
                        .setTicker("Ticker")
                        .setSmallIcon(android.R.drawable.ic_menu_report_image)
                        .setContentTitle("My notification NEWSS")
                        .setContentText("Hello World")
                        .setContentIntent(pi)
                        .setAutoCancel(true)
                        .build();

                NotificationManager notificationManager2 = (NotificationManager) getSystemService(Service.NOTIFICATION_SERVICE);
                notificationManager2.notify(0, notification);
            }
        });

    }


}
