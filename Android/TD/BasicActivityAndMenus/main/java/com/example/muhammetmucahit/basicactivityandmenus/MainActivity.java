package com.example.muhammetmucahit.basicactivityandmenus;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.SubMenu;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.net.URISyntaxException;

public class MainActivity extends AppCompatActivity {

    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                MainActivity.this.setTitle("Snackbar was pressed.");
                            }
                        }).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;

//        MenuItem menuItem1 = menu.add("File");
//        menuItem1.setIcon(R.mipmap.ic_launcher);
//        menuItem1.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
//        menuItem1.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
//            @Override
//            public boolean onMenuItemClick(MenuItem menuItem) {
//                Toast.makeText(context, menuItem.getTitle(), Toast.LENGTH_SHORT).show();
//                return true;
//            }
//        });
//
//        MenuItem menuItem2 = menu.add("Help");
//        menuItem2.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
//            @Override
//            public boolean onMenuItemClick(MenuItem menuItem) {
//                AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);
//                alertDialog.setMessage(menuItem.getTitle());
//                alertDialog.setTitle("Selected Item");
//                alertDialog.setPositiveButton("Okay", null);
//                alertDialog.show();
//                return true;
//            }
//        });

        // ==============================================================================================
//        menu.add(0, 1, 1, "Add").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
//            @Override
//            public boolean onMenuItemClick(MenuItem menuItem) {
//                Toast.makeText(context, menuItem.getTitle(), Toast.LENGTH_SHORT).show();
//                return true;
//            }
//        });
//        try {
//            menu.add(0, 2, 3, "Edit").setIntent(Intent.parseUri("http://google.com", 1));
//        } catch (URISyntaxException e) {
//            e.printStackTrace();
//        }
//        menu.add(0, 3, 2, "Delete");
//
//        menu.add(1, 4, 4, "Copy");
//        menu.add(1, 5, 5, "Paste");
//        menu.add(1, 6, 6, "Exit");

        // ==============================================================================================

//        SubMenu fileMenu =  menu.addSubMenu("File");
//        fileMenu.add(0, 1, 1, "Add");
//        fileMenu.add(0, Menu.FIRST, 0, "Save");
//        fileMenu.add(0, Menu.FIRST + 1, 0, "Open");
//        SubMenu editMenu =  menu.addSubMenu("Edit");
//        editMenu.add(1, 1, 1, "Delete");

        // ==============================================================================================



        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        menu.setGroupVisible(1, false);
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
