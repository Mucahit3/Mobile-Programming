package com.example.muhammetmucahit.playingmedia;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.CollapsibleActionView;
import android.view.View;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    Context context = this;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Uri myUri = Uri.parse(Environment.getExternalStorageDirectory().getAbsolutePath() + "/senmasallah.mp3");
//        mediaPlayer = MediaPlayer.create(context, R.raw.asd);
        mediaPlayer = MediaPlayer.create(context, myUri);
    }

    public void btnPlay(View v) {
        try {
            mediaPlayer.prepare();
            mediaPlayer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void btnStop(View v){
        mediaPlayer.pause();
    }
}
