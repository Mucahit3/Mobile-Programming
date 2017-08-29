package com.example.muhammetmucahit.informationbank;

import java.util.Random;

/**
 * Created by Muhammet Mucahit on 8/14/2017.
 */

public class InformationStore {

    private String[] information = {
            "Merhaba and Sey words are Arabic.",
            "You can't touch with your right foot to your right foot.",
            "America did first agreement with Ottoman."
    };

    public String getInformation() {
        Random random = new Random();
        int randomNumber = random.nextInt(information.length);
        return information[randomNumber];
    }
}
