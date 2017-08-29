package com.example.muhammetmucahit.customlistviewlongexample5;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Muhammet Mucahit on 8/17/2017.
 */

public class MySharedPreferences {

    static final String PREF_NAME = "File";
    static final String PREF_KEY = "Key";

    public void save(Context context, String text){
        SharedPreferences settings = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString(PREF_KEY, text);
        editor.commit();
    }

    public String getValue(Context context){
        SharedPreferences settings = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        String text = settings.getString(PREF_KEY, null);
        return text;
    }

    public void clear(Context context){
        SharedPreferences settings = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.clear();
        editor.commit();
    }

    public void delete(Context context){
        SharedPreferences settings = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.remove(PREF_KEY);
        editor.commit();
    }
}
