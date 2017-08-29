package com.example.muhammetmucahit.mythirdapplication;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText first, second;
    Button collect;
    TextView sum;
    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        first = (EditText) findViewById(R.id.edtTxt_first);
        second = (EditText) findViewById(R.id.edtTxt_second);
        collect = (Button) findViewById(R.id.btn_Collect);
        sum = (TextView) findViewById(R.id.txtVw_Sum);

        collect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int firstInt = Integer.parseInt(first.getText().toString());
                int secondInt = Integer.parseInt(second.getText().toString());
                int sumInt = firstInt + secondInt;
                sum.setText("Sum: " + sumInt);
                Toast toast = Toast.makeText(context, "Result: " + sumInt, Toast.LENGTH_SHORT);
                toast.show();

                // Custom Toast

                LayoutInflater li = LayoutInflater.from(context);
                View layout = li.inflate(R.layout.custom_toast, null);

                ImageView image = (ImageView) layout.findViewById(R.id.image);
                image.setImageResource(R.mipmap.ic_launcher);

                TextView text = (TextView) layout.findViewById(R.id.text);
                text.setText("Result: " + sumInt);

                Toast toast2 = new Toast(context);
                toast2.setGravity(Gravity.CENTER_HORIZONTAL, 500, 500);
                toast2.setDuration(Toast.LENGTH_LONG);
                toast2.setView(layout);
                toast2.show();
            }
        });
    }
}
