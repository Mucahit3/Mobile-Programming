package com.example.muhammetmucahit.accessinternalfoldersinphone;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.io.File;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Context context = this;
    ListView listView;
    Button btn_list;
    ArrayList<String> folders = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView);
        btn_list = (Button) findViewById(R.id.btn_list);

        btn_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                File[] file = File.listRoots();

                for (File file_item : file){
                    File[] directory = file_item.listFiles();
                    for (File directory_item : directory){
                        folders.add(directory_item.getAbsolutePath());
                    }
                }

                ArrayAdapter<String> adapter = new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1, folders);
                listView.setAdapter(adapter);
            }
        });
    }
}
