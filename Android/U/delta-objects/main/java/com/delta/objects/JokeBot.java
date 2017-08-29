package com.delta.objects;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Muhammet Mucahit on 8/3/2017.
 */

public class JokeBot extends Bot {

    public static ArrayList<Joke> jokesIKnow = null;

    public JokeBot(ArrayList<Joke> jokes) {
        this.jokesIKnow = jokes;
    }

    protected void sayJoke(Joke aJoke){
        talk(aJoke.getJokeSetup());
        talk(aJoke.getJokePunchline());
    }

    public void tellJoke(){
        Random rand = new Random();
        int randomNum = rand.nextInt(jokesIKnow.size()) + 0;

        Joke myJoke = jokesIKnow.get(randomNum);

        sayJoke(myJoke);
    }
}
