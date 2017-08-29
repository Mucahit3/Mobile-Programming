package com.example.muhammetmucahit.alertdialog2;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Context context = this;
    Button btn_show;
    TextView txtVw_showValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_show = (Button) findViewById(R.id.btn_show);
        txtVw_showValue = (TextView) findViewById(R.id.txtVw_showValue);
        btn_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Diger Layouttaki degerlere burdan erisebilmek icin tanimliyoruz.
                LayoutInflater li = LayoutInflater.from(context);
                View settingsView = li.inflate(R.layout.settings, null);
                final EditText edtTxt_enter = (EditText) settingsView.findViewById(R.id.edtTxt_enter);
                TextView txtVw_result = (TextView) settingsView.findViewById(R.id.txtVw_result);

                txtVw_result.setTextSize(25);
                txtVw_result.setText("Show AlertDialog");
                final AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);
                alertDialog.setView(settingsView)
                        .setMessage("To exit press Yes")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                txtVw_showValue.setText(edtTxt_enter.getText().toString());
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        }).show();
            }
        });
    }
}
