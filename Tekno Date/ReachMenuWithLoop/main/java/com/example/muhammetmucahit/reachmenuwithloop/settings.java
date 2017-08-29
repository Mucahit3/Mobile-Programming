package com.example.muhammetmucahit.reachmenuwithloop;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Muhammet Mucahit on 8/17/2017.
 */

public class settings extends AppCompatActivity {

    Context context = this;

    public boolean onCreateOptionsMenu(Menu menu) {
        ArrayList<String> menuItem = new ArrayList<>();
        menuItem.add("File");
        menuItem.add("Edit");
        menuItem.add("Window");
        menuItem.add("Help");
        menuItem.add("About");

        for (String t : menuItem){
            MenuItem item = menu.add(t);
            item.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem menuItem1) {
                    Toast.makeText(context, menuItem1.getTitle(), Toast.LENGTH_SHORT).show();
                    return true;
                }
            });
        }

        return super.onCreateOptionsMenu(menu);
    }

}
