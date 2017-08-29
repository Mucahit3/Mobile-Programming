package com.example.muhammetmucahit.introduction;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        // Memories of Variables

        byte myByte = 0;           // 0000 0000
        short myShort = 0;         // 0000 0000 0000 0000
        int myInt = 0;             // 0000 0000 0000 0000 0000 0000 0000 0000
        long myLong = 0;           // 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000
        float myFloat = 0.0f;      // 32 bits
        double myDouble = 0.0d;    // 64 bits
        char myChar = '\u0000';    // 16 bits
        boolean myBoolean = false; // 1 bit
        */

        // -------------------------------------------------------------------------------
        // References And Null

        int[] myIntArray = new int[4];

        myIntArray[0] = 2;
        myIntArray[1] = 4;
        myIntArray[2] = 6;
        myIntArray[3] = 8;

        int[] mySecondArray; // null

        mySecondArray = myIntArray;

        myIntArray = null;
    }
}
