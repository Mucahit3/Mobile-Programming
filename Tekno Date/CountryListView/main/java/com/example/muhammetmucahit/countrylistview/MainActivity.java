package com.example.muhammetmucahit.countrylistview;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Context context = this;
    Spinner spinner_countries;
    ListView listView_cities;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner_countries = (Spinner) findViewById(R.id.spinner_counter);
        listView_cities = (ListView) findViewById(R.id.listView_cities);

        spinner_countries.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String choice = spinner_countries.getItemAtPosition(i).toString();
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1, android.R.id.text1, getCities(choice));
                listView_cities.setAdapter(adapter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    ArrayList<String> getCities(String country){

        ArrayList<String> cities = new ArrayList<>();

        switch (country){
            case "Turkey":
                cities.add("Ankara");
                cities.add("Istanbul");
                cities.add("Erzincan");
                break;
            case "Germany":
                cities.add("Munich");
                cities.add("Berlin");
                cities.add("Duizburg");
                break;
            case "Spain":
                cities.add("Barcelona");
                cities.add("Madrid");
                cities.add("Valencia");
                break;
        }

        return cities;
    }
}
