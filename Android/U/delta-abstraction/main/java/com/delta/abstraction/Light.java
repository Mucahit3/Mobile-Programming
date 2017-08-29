package com.delta.abstraction;

import android.util.Log;

/**
 * Created by Muhammet Mucahit on 8/4/2017.
 */

public class Light extends Device {

    public Light() {
        setName("Light");
    }

    @Override
    public void turnOn(){
        Log.e(getName(), "The Light is open now!");
        isON = true;
    }

    @Override
    public void turnOff(){
        Log.e(getName(), "The Light is close now!");
        isON = false;
    }

    @Override
    public void breakDevice() {
        Log.e(getName(), "The Light is broken now!");
    }
}
