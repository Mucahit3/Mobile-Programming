package com.example.muhammetmucahit.listactivity;

import android.app.ListActivity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends ListActivity {

    Context context = this;
    String[] os;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        os = new String[5];
        os[0] = "Linux";
        os[1] = "Pardus";
        os[2] = "Windows";
        os[3] = "Ubuntu";
        os[4] = "MacOs";

        adapter = new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1, android.R.id.text1, os);
        setListAdapter(adapter);

    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {

        //Toast.makeText(context, os[position], Toast.LENGTH_SHORT).show();
        Toast.makeText(context, String.valueOf(l.getItemAtPosition(position)), Toast.LENGTH_SHORT).show();
        super.onListItemClick(l, v, position, id);
    }
}
