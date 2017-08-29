package com.example.muhammetmucahit.mysecondapplication;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by Muhammet Mucahit on 8/15/2017.
 */

public class NumbersActivity extends AppCompatActivity {

    TextView number;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.numbers);
        number = (TextView) findViewById(R.id.txtVw_number);

        Resources res = this.getResources();
        int num[] = res.getIntArray(R.array.numbers);
        int sum = 0;

        for (int i = 0; i < num.length; i++)
            sum += num[i];

        number.setText(String.valueOf(sum));
    }
}
