package com.delta.abstraction;

/**
 * Created by Muhammet Mucahit on 8/4/2017.
 */

public abstract class Device implements Switchable{

    private String name;
    public boolean isON;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract void breakDevice();
}
