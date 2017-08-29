package com.example.muhammetmucahit.intentconcept;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Muhammet Mucahit on 8/16/2017.
 */

public class SecondActivity extends AppCompatActivity {

    Context context = this;
    TextView txtVw_welcome;
    Button btn_gowebsite;
    Button btn_back;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        Intent get_intent = getIntent();

        txtVw_welcome = (TextView) findViewById(R.id.txtVw_welcome);
        txtVw_welcome.setText("Welcome : " + get_intent.getStringExtra("name") + "\n Your password : " + get_intent.getStringExtra("password"));

        btn_gowebsite = (Button) findViewById(R.id.btn_gowebsite);

        btn_gowebsite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("http://www.google.com"));
                startActivity(i);
            }
        });

        btn_back = (Button) findViewById(R.id.btn_back);

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, MainActivity.class);
                startActivity(i);
            }
        });
    }
}
