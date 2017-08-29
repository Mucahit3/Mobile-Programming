package com.example.muhammetmucahit.notifications;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;

/**
 * Created by Muhammet Mucahit on 8/18/2017.
 */
// Gelismis hali ilk hali MainActivity de ;)

public class NotificationActivity extends AppCompatActivity {

    Context context = this;
    Button btn_createNotification, btn_deleteNotification;
    NotificationManager notificationManager;
    NotificationCompat.Builder builder;
    int numMessage = 0;
    final String myBlog = "http://google.com";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(myBlog));
        final PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);

        final Bitmap icon = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
        final Uri alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);

        final NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();
        String[] events = new String[3];
        events[0] = new String("1) Message for Implicit Intent");
        events[1] = new String("2) Message for Implicit Intent");
        events[2] = new String("3) Message for Implicit Intent");
        inboxStyle.setBigContentTitle("Detail");
        for (String event : events){
            inboxStyle.addLine(event);
        }

        final NotificationCompat.Action action = new NotificationCompat.Action.Builder(R.mipmap.ic_launcher, "Previous", pendingIntent).build();

        btn_createNotification = (Button) findViewById(R.id.btn_createNotification);
        btn_deleteNotification = (Button) findViewById(R.id.btn_deleteNotification);

        btn_createNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                builder = (NotificationCompat.Builder) new NotificationCompat.Builder(context)
                        .setContentTitle("Better Notification")
                        .setContentText("Description")
                        .setLargeIcon(icon)
                        .setSmallIcon(R.mipmap.ic_launcher_round)
                        .setSound(alarmSound)
                        .setContentIntent(pendingIntent)
                        .addAction(action)
                        .setNumber(++numMessage)
                        .setVibrate(new long[]{100, 100, 100, 100, 5000})
                        .setStyle(inboxStyle)
                        .setTicker(getResources().getString(R.string.notification_title));

                notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                notificationManager.notify(1, builder.build());

            }
        });
    }
}
