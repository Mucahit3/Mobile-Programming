package com.example.muhammetmucahit.fragment;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Context context = this;
    FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager = getFragmentManager();
    }

    public void btn_add_A_click(View v) {
        fragment_a fa = new fragment_a();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.group, fa, "A");
        transaction.commit();
    }

    public void btn_add_B_click(View v) {
        fragment_b fb = new fragment_b();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.group, fb, "B");
        transaction.commit();
    }

    public void btn_delete_A_click(View v) {
        fragment_a fa = (fragment_a) manager.findFragmentByTag("A");
        FragmentTransaction transaction = manager.beginTransaction();

        if(fa != null){
            transaction.remove(fa);
            transaction.attach(fa);
            transaction.commit();
        }
        else
            Toast.makeText(context, "There isn't a fragment.", Toast.LENGTH_SHORT).show();
    }

    public void btn_delete_B_click(View v) {
        fragment_b fb = (fragment_b) manager.findFragmentByTag("B");
        FragmentTransaction transaction = manager.beginTransaction();

        if(fb != null){
            transaction.remove(fb);
            transaction.attach(fb);
            transaction.commit();
        }
        else
            Toast.makeText(context, "There isn't a fragment.", Toast.LENGTH_SHORT).show();
    }

    public void btn_change_A_click(View v) {
        fragment_b fb = new fragment_b();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.group, fb);
        transaction.commit();
    }

    public void btn_change_B_click(View v) {
        fragment_a fa = new fragment_a();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.group, fa);
        transaction.commit();
    }
}
