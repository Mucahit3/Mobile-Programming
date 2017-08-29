package com.delta.objects;

import java.util.ArrayList;

/**
 * Created by Muhammet Mucahit on 8/3/2017.
 */

public class ComedianBot extends JokeBot {

    public ComedianBot(String aName){
        super(null);
        setName(aName);
        jokesIKnow = JokeWriter.getJokeListTwo();
    }

    @Override
    protected void sayJoke(Joke aJoke) {
        talk(aJoke.getJokeSetup() + "---" + aJoke.getJokePunchline());
    }

    public void performShow(){
        talk("Good evening everyone, my name is " + getName());
        talk("Why don't I tell you some of my favorite jokes?");

        for (Joke oneJoke : jokesIKnow){
            sayJoke(oneJoke);
        }

        talk("Thanks everyone, Good Night!");
    }
}
