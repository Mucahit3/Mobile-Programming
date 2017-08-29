package com.example.muhammetmucahit.dualintent;

import android.content.Context;
import android.content.Intent;
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
    TextView txtVw_numbers;
    Button btn_sentToMain;
    Bundle numbers;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        txtVw_numbers = (TextView) findViewById(R.id.txtVw_numbers);
        btn_sentToMain = (Button) findViewById(R.id.btn_sendToMain);

        numbers = getIntent().getExtras();
        final int firstNumber = Integer.parseInt(numbers.getString("number1").toString());
        final int secondNumber = Integer.parseInt(numbers.getString("number2").toString());

        txtVw_numbers.setText(firstNumber + " + " + secondNumber);

        btn_sentToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                Bundle resultBundle = new Bundle();
                int sum = firstNumber + secondNumber;
                resultBundle.putInt("result", sum);
                intent.putExtras(resultBundle);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
