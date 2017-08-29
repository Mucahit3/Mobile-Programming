package com.example.muhammetmucahit.intentwithbundle;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Context context = this;
    Bundle bundle;
    Intent intent;
    EditText edtTxt_phoneNumber;
    Button btn_send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtTxt_phoneNumber = (EditText) findViewById(R.id.edtTxt_phoneNumber);
        btn_send = (Button) findViewById(R.id.btn_send);

        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(context, SecondActivity.class);
                bundle = new Bundle();
                bundle.putString("phoneNumber", edtTxt_phoneNumber.getText().toString());
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}
