package com.example.muhammetmucahit.intentwithbundle;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Muhammet Mucahit on 8/16/2017.
 */

public class SecondActivity extends AppCompatActivity {

    Context context = this;
    TextView txtVw_phoneNumber;
    Button btn_call;
    Bundle datas;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        txtVw_phoneNumber = (TextView) findViewById(R.id.txtVw_phonenumber);
        btn_call = (Button) findViewById(R.id.btn_call);

        datas = getIntent().getExtras();

        txtVw_phoneNumber.setText(datas.getString("phoneNumber"));

        btn_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!txtVw_phoneNumber.getText().toString().equals("")) {
                    Intent i = new Intent(Intent.ACTION_CALL);
                    i.setData(Uri.parse("tel:" + txtVw_phoneNumber.getText().toString()));
                    if (ActivityCompat.checkSelfPermission(context, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                        return;
                    }
                    startActivity(i);
                }
            }
        });
    }
}
