package com.delta.abstraction;

import android.util.Log;

/**
 * Created by Muhammet Mucahit on 8/4/2017.
 */

public class Fan extends Device {

    public Fan() {
        setName("Fan");
    }

    @Override
    public void turnOn(){
        Log.e(getName(), "The Fan is open now!");
        isON = true;
    }

    @Override
    public void turnOff(){
        Log.e(getName(), "The Fan is close now!");
        isON = false;
    }

    @Override
    public void breakDevice() {
        Log.e(getName(), "The fan is broken now!");
    }
}
