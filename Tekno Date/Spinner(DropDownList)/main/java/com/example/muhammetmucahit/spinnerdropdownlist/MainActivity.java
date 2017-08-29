package com.example.muhammetmucahit.spinnerdropdownlist;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Context context = this;
    Spinner spinner_1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner_1 = (Spinner) findViewById(R.id.spinner_1);
        spinner_1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(context, "" +  parent.getItemIdAtPosition(i), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
