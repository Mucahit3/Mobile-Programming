package com.example.muhammetmucahit.countdowntimer;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

//    TextView textView;
//    CountDownTimer countDownTimer;
    Button btn_startTimer, btn_stopTimer;
    ProgressBar progressBar;
    MyCountDownTimer myCountDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        textView = (TextView) findViewById(R.id.textView_counter);
//        countDownTimer = new CountDownTimer(10000, 1000) {
//            @Override
//            public void onTick(long l) {
//                textView.setText("Resf of Time : " + l / 1000);
//            }
//
//            @Override
//            public void onFinish() {
//                textView.setText("OK");
//            }
//        }.start();

        setContentView(R.layout.count);

        btn_startTimer = (Button) findViewById(R.id.btn_startTimer);
        btn_stopTimer = (Button) findViewById(R.id.btn_stopTimer);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        myCountDownTimer = new MyCountDownTimer(10000, 1000);

        btn_startTimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myCountDownTimer.start();
            }
        });

        btn_stopTimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myCountDownTimer.cancel();
            }
        });
    }

    public class MyCountDownTimer extends CountDownTimer {

        public MyCountDownTimer(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long l) {
            int progress = (int) (l / 1000);
            progressBar.setProgress((progressBar.getMax() + 1) - progress);
        }

        @Override
        public void onFinish() {
            // finish();
        }
    }
}
