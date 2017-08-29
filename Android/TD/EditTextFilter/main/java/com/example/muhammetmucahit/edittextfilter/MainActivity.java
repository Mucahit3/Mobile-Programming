package com.example.muhammetmucahit.edittextfilter;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Context context = this;
    EditText editText_filter;
    ListView listView_list;
    ArrayList<String> list = new ArrayList<>();
//    String beforeTextChanged = "", onTextChanged = "", afterTextChanged = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText_filter = (EditText) findViewById(R.id.editText_filter);
        listView_list = (ListView) findViewById(R.id.listView_list);

        list.add("Apple");
        list.add("Samsung");
        list.add("Exper");
        list.add("Casper");
        list.add("HP");
        list.add("Dell");
        list.add("LG");

        listView_list.setAdapter(new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1, android.R.id.text1, list));

        editText_filter.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                ArrayList<String> tempList = new ArrayList<>();

                for (String item : list){
                    if(item.toUpperCase().contains(charSequence.toString().toUpperCase()))
                        tempList.add(item);
                }

                // Olabilir ikisini de dene tarafini sec.
                //if(tempList != null && tempList.size() > 0)
                    listView_list.setAdapter(new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1, android.R.id.text1, tempList));
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

//        editText_filter = (EditText) findViewById(R.id.editText_filter);
//        editText_filter.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//                beforeTextChanged = editText_filter.getText().toString();
//            }
//
//            @Override
//            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//                onTextChanged = charSequence.toString();
//            }
//
//            @Override
//            public void afterTextChanged(Editable editable) {
//                afterTextChanged = editText_filter.getText().toString();
//                Toast.makeText(context, "before : " + beforeTextChanged +
//                        "\n" + "on : " + onTextChanged +
//                        "\n" + "after : " + afterTextChanged, Toast.LENGTH_SHORT).show();
//            }
//        });
    }
}
