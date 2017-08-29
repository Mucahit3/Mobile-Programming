package com.example.muhammetmucahit.informationbank;

import android.graphics.Color;

import java.util.Random;

/**
 * Created by Muhammet Mucahit on 8/14/2017.
 */

public class Colors {

    private String[] color = {
            "#1f428e",
            "#e0d8ce",
            "#0f3485",
            "#072b80",
            "#cf041c",
            "#b5f0fd",
            "#d3ffce",
            "#7fff96",
            "#b976ed",
            "#7fc8ff",
            "#ff49ea",
            "#7bffff",
            "#6b214c",
            "#610dab"
    };

    public int getColor() {
        Random random = new Random();
        int randomNumber = random.nextInt(color.length);
        return Color.parseColor(color[randomNumber]);
    }

}
