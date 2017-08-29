package com.delta.abstraction;

import java.util.ArrayList;

/**
 * Created by Muhammet Mucahit on 8/4/2017.
 */

public class Switch {

    public ArrayList<Switchable> switchableItems = new ArrayList<Switchable>();

    public void wireUp(Switchable thing){
        switchableItems.add(thing);
    }

    public void wireDown(Switchable thing){
        switchableItems.remove(thing);
    }

    public void flipSwitchUp(){
        for(Switchable thing : switchableItems)
            thing.turnOn();
    }

    public void flipSwitchDown(){
        for(Switchable thing : switchableItems)
            thing.turnOff();
    }

}
