package com.example.muhammetmucahit.systemservices_vibrateclass;

import android.content.Context;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn_vibrate1, btn_vibrate2, btn_vibrate3;
    Vibrator vibrator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        btn_vibrate1 = (Button) findViewById(R.id.btn_vibrate1);
        btn_vibrate2 = (Button) findViewById(R.id.btn_vibrate2);
        btn_vibrate3 = (Button) findViewById(R.id.btn_vibrate3);

        btn_vibrate1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vibrator.vibrate(500);
            }
        });
        btn_vibrate2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int action = motionEvent.getAction();
                if(action == MotionEvent.ACTION_DOWN)
                    vibrator.vibrate(1000);
                else if(action == MotionEvent.ACTION_UP)
                    vibrator.cancel();
                return true;
            }
        });

        btn_vibrate3.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int action = motionEvent.getAction();
                if(action == MotionEvent.ACTION_DOWN){
                    long[] pat = {100, 100, 100, 100, 500};
                    vibrator.vibrate(pat, 0);
                }
                return true;
            }
        });
    }
}
