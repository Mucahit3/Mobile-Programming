package com.delta.objects;

import android.util.Log;

/**
 * Created by Muhammet Mucahit on 8/3/2017.
 **/

public class Bot {

    public final String creatorName = "Mucahit";
    private String name = "Mahmote";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    protected void talk(String whatToSay){
        Log.e(getName(), String.valueOf(whatToSay));
    }
}
