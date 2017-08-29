package com.example.muhammetmucahit.videoview;

import android.app.ProgressDialog;
import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.CountDownTimer;
import android.os.Environment;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    Context context = this;
    VideoView videoView_watchVideo;
    ProgressDialog progressDialog;
    MediaController mediaController;
    int position = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (mediaController == null) {
            mediaController = new MediaController(context);
        }

        videoView_watchVideo = (VideoView) findViewById(R.id.videoView_watchVideo);
        progressDialog = new ProgressDialog(context);
        progressDialog.setTitle("Android VideoView Loading");
        progressDialog.setMessage("Loading");
        progressDialog.setCancelable(false);
        progressDialog.show();

        videoView_watchVideo.setMediaController(mediaController);
        videoView_watchVideo.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.asd));
        videoView_watchVideo.requestFocus();

        videoView_watchVideo.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                progressDialog.dismiss();
                videoView_watchVideo.seekTo(position);
                if (position == 0){
                    videoView_watchVideo.start();
                }
                else {
                    videoView_watchVideo.pause();
                }
            }
        });
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        outState.putInt("position", videoView_watchVideo.getCurrentPosition());
        videoView_watchVideo.pause();
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        position = savedInstanceState.getInt("position");
        videoView_watchVideo.seekTo(position);
    }
}
