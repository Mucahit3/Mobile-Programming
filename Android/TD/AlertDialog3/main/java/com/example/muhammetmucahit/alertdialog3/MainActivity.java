package com.example.muhammetmucahit.alertdialog3;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ArrayList<String> array = new ArrayList<>();

        final CharSequence items[] = {"Windows", "Pardus", "Macosx", "Linux"};
        boolean checkedItems[] = {false, false, false, false};
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);
        alertDialog.setTitle("What is your choice of Operating System");
        alertDialog.setMultiChoiceItems(items, checkedItems, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                if(b){
                    array.add(items[i].toString());
                    Toast.makeText(context, items[i], Toast.LENGTH_SHORT).show();
                }
                else{
                    array.remove(items[i]);
                }
            }
        });
        alertDialog.setCancelable(false);
        alertDialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(context, "Your choices \n" + array, Toast.LENGTH_SHORT).show();
            }
        }).show();

    }
}
