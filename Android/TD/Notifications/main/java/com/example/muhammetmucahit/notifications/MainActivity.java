package com.example.muhammetmucahit.notifications;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Context context = this;
    Button btn_createNotification, btn_deleteNotification;
    Notification myNotification;
    NotificationManager notificationManager;
    final String myBlog = "http://google.com";
    static final int NOTIFICATION_ID = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_createNotification = (Button) findViewById(R.id.btn_createNotification);
        btn_deleteNotification = (Button) findViewById(R.id.btn_deleteNotification);
        btn_createNotification.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(myBlog));
                PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);
                myNotification = new Notification.Builder(context).setContentTitle("Mucahit")
                        .setContentText("It's my notification ;)")
                        .setWhen(System.currentTimeMillis())
                        .setContentIntent(pendingIntent)
                        .setDefaults(Notification.DEFAULT_SOUND | Notification.DEFAULT_VIBRATE)
                        .setAutoCancel(true)
                        .setSmallIcon(R.mipmap.ic_launcher).build();

                notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                notificationManager.notify(NOTIFICATION_ID, myNotification);
            }
        });

        btn_deleteNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                notificationManager.cancel(NOTIFICATION_ID);
            }
        });
    }
}
