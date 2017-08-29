package com.example.muhammetmucahit.dualintent;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Context context = this;
    EditText edtTxt_firstNumber;
    EditText edtTxt_secondNumber;
    TextView txtVw_result;
    Button btn_send;
    Bundle resultBundle;
    Intent intent;
    Intent data;
    static final int Contact_Request = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtTxt_firstNumber = (EditText) findViewById(R.id.edtTxt_firstNumber);
        edtTxt_secondNumber = (EditText) findViewById(R.id.edtTxt_secondNumber);
        btn_send = (Button) findViewById(R.id.btn_send);
        txtVw_result = (TextView) findViewById(R.id.txtVw_result);
        resultBundle = getIntent().getExtras();

        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(context, SecondActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("number1", edtTxt_firstNumber.getText().toString());
                bundle.putString("number2", edtTxt_secondNumber.getText().toString());
                intent.putExtras(bundle);
                startActivityForResult(intent, Contact_Request);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == Contact_Request && resultCode == RESULT_OK){
            txtVw_result.setText(String.valueOf(data.getIntExtra("result", -1)));
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
