package com.example.muhammetmucahit.customlistviewlongexample5;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by Muhammet Mucahit on 8/17/2017.
 */

public class SecondActivity extends AppCompatActivity {

    Context context = this;
    TextView textView_text;
    MySharedPreferences sharedPreferences;
    String gotValue;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);

        textView_text = (TextView) findViewById(R.id.textView_text);
        sharedPreferences = new MySharedPreferences();

        gotValue = sharedPreferences.getValue(context);
        textView_text.setText(gotValue);
    }
}
