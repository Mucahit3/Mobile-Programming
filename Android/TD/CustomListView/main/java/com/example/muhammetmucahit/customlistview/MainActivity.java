package com.example.muhammetmucahit.customlistview;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Context context = this;
    List<MobileOS> mobile = new ArrayList<>();
    ListView listView_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mobile.add(new MobileOS("IOS"));
        mobile.add(new MobileOS("Blackberry"));
        mobile.add(new MobileOS("WindowsPhone"));
        mobile.add(new MobileOS("Android"));

        listView_list = (ListView) findViewById(R.id.listView_list);
        CustomAdapter adapter = new CustomAdapter(context, mobile);

        listView_list.setAdapter(adapter);

    }
}
