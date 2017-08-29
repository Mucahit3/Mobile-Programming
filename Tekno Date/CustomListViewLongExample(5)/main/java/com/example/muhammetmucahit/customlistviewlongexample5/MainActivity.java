package com.example.muhammetmucahit.customlistviewlongexample5;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Context context = this;
    CheckBox checkBox_1;
    EditText editText_name;
    Button btn_save, btn_delete, btn_remove, btn_goToSecondActivity;
    String text;
    MySharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        btn_save.setOnClickListener(this);
        btn_delete.setOnClickListener(this);
        btn_remove.setOnClickListener(this);
        btn_goToSecondActivity.setOnClickListener(this);
    }

    public void init(){
        checkBox_1 = (CheckBox) findViewById(R.id.checkBox_1);
        editText_name = (EditText) findViewById(R.id.editText_name);
        btn_save = (Button) findViewById(R.id.btn_save);
        btn_delete = (Button) findViewById(R.id.btn_delete);
        btn_remove = (Button) findViewById(R.id.btn_remove);
        btn_goToSecondActivity = (Button) findViewById(R.id.btn_goToSecondActivity);
        sharedPreferences = new MySharedPreferences();
    }

    public void onClick(View view){
        switch (view.getId()){
            case R.id.btn_save:
                if(checkBox_1.isChecked()){
                    text = editText_name.getText().toString();
                    sharedPreferences.save(context, text);
                    Toast.makeText(context, "It is saved", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btn_delete:
                if(checkBox_1.isChecked()){
                    sharedPreferences.clear(context);
                    Toast.makeText(context, "It is deleted", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btn_remove:
                if(checkBox_1.isChecked()){
                    sharedPreferences.delete(context);
                }
                break;
            case R.id.btn_goToSecondActivity:
                Intent intent = new Intent(context, SecondActivity.class);
                startActivity(intent);
                break;

        }
    }
}
