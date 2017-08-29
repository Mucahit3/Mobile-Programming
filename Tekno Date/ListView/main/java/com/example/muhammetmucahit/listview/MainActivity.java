package com.example.muhammetmucahit.listview;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Context context = this;
    final static String[] fruits = {"apple", "orange", "peach", "melon", "raspberry"};
    ListView listView_fruits;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView_fruits = (ListView) findViewById(R.id.listView_fruits);
        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1, android.R.id.text1, fruits);


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(context,  R.layout.list_fruit, fruits);
        listView_fruits.setAdapter(adapter);

        listView_fruits.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                AlertDialog.Builder dialog = new AlertDialog.Builder(context);
//                dialog.setMessage(fruits[i]).setCancelable(false).setPositiveButton("Okay", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        dialogInterface.dismiss();
//                    }
//                }).show();
                Toast.makeText(context, String.valueOf(adapterView.getItemAtPosition(i)), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
