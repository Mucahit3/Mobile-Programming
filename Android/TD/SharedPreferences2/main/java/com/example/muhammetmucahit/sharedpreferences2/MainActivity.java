package com.example.muhammetmucahit.sharedpreferences2;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Context context = this;
    TextView textView_welcome;
    MySharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView_welcome = (TextView) findViewById(R.id.textView_welcome);
        sharedPreferences = new MySharedPreferences();

        String name = sharedPreferences.getValue(context, "username");

        textView_welcome.setText("Welcome " + name);
    }
}
