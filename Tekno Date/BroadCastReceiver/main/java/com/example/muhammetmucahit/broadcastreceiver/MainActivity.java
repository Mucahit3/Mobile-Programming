package com.example.muhammetmucahit.broadcastreceiver;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Context context = this;
    //EditText editText_time;
    //Button btn_broadcastSend;
//    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



//        textView = (TextView) findViewById(R.id.textView);
//        IntentFilter batteryLevel = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
//
//        registerReceiver(receiver, batteryLevel);

//        btn_broadcastSend = (Button) findViewById(R.id.btn_broadcastSend);
//
//        btn_broadcastSend.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent("com.example.muhammetmucahit.TSUNAMI");
//                intent.putExtra("MESSAGE", "Please go outside from your home");
//                sendBroadcast(intent);
//            }
//        });

        //editText_time = (EditText) findViewById(R.id.editText_time);
    }

//    private BroadcastReceiver receiver = new BroadcastReceiver() {
//        @Override
//        public void onReceive(Context context, Intent intent) {
//            int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
//            textView.setText("Battery Level : " + level + "%");
//        }
//    };

//    public void btnStart(View view){
//        int i = Integer.parseInt(editText_time.getText().toString());
//        Intent intent = new Intent(context, MyBroadCastReceiver.class);
//        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 1, intent, 0);
//        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
//        alarmManager.set(AlarmManager.RTC_WAKEUP, java.lang.System.currentTimeMillis() + (i * 1000), pendingIntent);
//        Toast.makeText(context, "Alarm " + i + " saniyeye kuruldu", Toast.LENGTH_SHORT).show();
//    }
}
