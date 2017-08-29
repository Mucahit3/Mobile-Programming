package com.example.muhammetmucahit.sharedpreferences2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Muhammet Mucahit on 8/18/2017.
 */

public class LoginActivity extends AppCompatActivity {

    Context context = this;
    EditText editText_name, editText_password;
    CheckBox checkBox_remember;
    Button btn_login;
    MySharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        init();

        // beni hatirla isaretlenmisse
        if(sharedPreferences.getValueBoolean(context, "remember")){
            editText_name.setText(sharedPreferences.getValue(context, "username"));
            editText_password.setText(sharedPreferences.getValue(context, "password"));
            checkBox_remember.setChecked(sharedPreferences.getValueBoolean(context, "remember"));
        }

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(editText_name.getText().toString().equals(getString(R.string.test_username)) && editText_password.getText().toString().equals(getString(R.string.test_password))){
                    Intent intent = new Intent(context, MainActivity.class);
                    startActivity(intent);
                    if(checkBox_remember.isChecked()){
                        sharedPreferences.save(context, "username", editText_name.getText().toString());
                        sharedPreferences.save(context, "password", editText_password.getText().toString());
                    }
                    else{
                        sharedPreferences.save(context, "username", "");
                        sharedPreferences.save(context, "password", "");
                    }
                    sharedPreferences.saveBoolean(context, "remember", checkBox_remember.isChecked());
                }
                else
                    Toast.makeText(context, getString(R.string.login_error), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void init() {

        editText_name = (EditText) findViewById(R.id.editText_name);
        editText_password = (EditText) findViewById(R.id.editText_password);
        checkBox_remember = (CheckBox) findViewById(R.id.checkBox_remember);
        btn_login = (Button) findViewById(R.id.btn_login);
        sharedPreferences = new MySharedPreferences();
    }
}
