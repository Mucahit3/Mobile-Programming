package com.example.muhammetmucahit.mysecondapplication;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Muhammet Mucahit on 8/14/2017.
 */

public class Programmatic extends AppCompatActivity {

    private LinearLayout panel;
    private TextView counter;
    private Button increase;
    int count = 0;
    Context context = this;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
        setContentView(panel);
    }

    public void init(){
        panel = new LinearLayout(context);
        panel.setOrientation(LinearLayout.VERTICAL);

        counter = new TextView(context);
        counter.setText("Counter: 0");
        counter.setTextSize(25);

        increase = new Button(context);
        increase.setText("Increase");
        increase.setAllCaps(false);

        panel.addView(counter);
        panel.addView(increase);

        increase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ++count;
                counter.setText("Counter: " + count);
            }
        });
    }
}
