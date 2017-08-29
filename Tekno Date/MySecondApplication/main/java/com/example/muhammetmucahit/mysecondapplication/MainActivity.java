package com.example.muhammetmucahit.mysecondapplication;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView counter;
    private Button increase;
    private Button decrease;
    int count = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();


    }

    public void init(){
        counter = (TextView) findViewById(R.id.txtVw_counter);
        increase = (Button) findViewById(R.id.btn_increase);
        decrease = (Button) findViewById(R.id.btn_decrease);

        // 3. method for OnClickListener with OnClickListener interface
        increase.setOnClickListener(this);
        decrease.setOnClickListener(this);

        // 2. method for OnClickListener
        /*
        increase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ++count;
                counter.setText("Counter: " + count);
            }
        });

        decrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                --count;
                counter.setText("Counter: " + count);
            }
        });
        */
    }

    // 3. method for OnClick Listener with OnClickListener interface
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_increase: {
                ++count; break;
            }
            case R.id.btn_decrease: {
                --count; break;
            }
        }
        counter.setText("Counter: " + count);
    }

    // Other type of OnClick for Buttons
    /*
    public void btnIncrease_Click(View v) {

        switch (v.getId()){
            case R.id.btn_increase: {
                ++count; break;
            }
            case R.id.btn_decrease: {
                --count; break;
            }
        }
        counter.setText("Counter: " + count);
    }
    */
}
