package com.example.muhammetmucahit.intentconcept;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Context context = this;
    EditText editText_username, editText_password;
    Button btn_send, btn_clear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        btn_send.setOnClickListener(this);
        btn_clear.setOnClickListener(this);

    }

    public void init(){
        editText_username = (EditText) findViewById(R.id.edtTxt_username);
        editText_password = (EditText) findViewById(R.id.edtTxt_password);
        btn_send = (Button) findViewById(R.id.btn_send);
        btn_clear = (Button) findViewById(R.id.btn_clear);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_send:
                if(editText_username.getText().toString().equalsIgnoreCase("mucahit") && editText_password.getText().toString().equals("1")){
                    Intent i = new Intent(context, SecondActivity.class);
                    i.putExtra("name", editText_username.getText().toString());
                    i.putExtra("password", editText_password.getText().toString());
                    startActivity(i);
                }
                else{
                    Toast.makeText(context, "Invalid username or password", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btn_clear:
                editText_username.setText("");
                editText_password.setText("");
                editText_username.requestFocus();
                break;
        }
    }
}
