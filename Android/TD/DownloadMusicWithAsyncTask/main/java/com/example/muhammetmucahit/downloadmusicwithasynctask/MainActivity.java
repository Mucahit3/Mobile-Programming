package com.example.muhammetmucahit.downloadmusicwithasynctask;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class MainActivity extends AppCompatActivity {

    ProgressDialog progressDialog;
    static final int progressType = 0;
    Context context = this;
    Button btn_downloadMp3;
    static String fileURL = "http://sadecemp3.net/uploads/mp3/e0a95b3d9c45d24fc4b5822b0d280e9c.mp3";
    MediaPlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_downloadMp3 = (Button) findViewById(R.id.btn_downloadMp3);

        btn_downloadMp3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/senmasallah.mp3");
                if(file.exists()){
                    Toast.makeText(context, "The mp3 has been already downloaded", Toast.LENGTH_SHORT).show();
                    listenMusic();

                } else {
                    Toast.makeText(context, "The mp3 doesn't exist! Please download it.", Toast.LENGTH_SHORT).show();
                    new DownloadMusicFromInternet().execute(fileURL);
                }
            }
        });
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id){
            case progressType:
                progressDialog = new ProgressDialog(context);
                progressDialog.setMessage("Mp3 is been downloading, Please wait...");
                progressDialog.setMax(100);
                progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                progressDialog.setCancelable(false);
                progressDialog.show();
                return progressDialog;
            default:
                return null;
        }
    }

    public class DownloadMusicFromInternet extends AsyncTask<String, String, Object> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            showDialog(progressType);
        }

        @Override
        protected Object doInBackground(String[] objects) {
            int number;
            try {
                URL url = new URL(objects[0]);
                URLConnection connection = url.openConnection();
                connection.connect();
                int fileLength = connection.getContentLength();
                InputStream input = new BufferedInputStream(url.openStream(), 10 * 1024);
                OutputStream output = new FileOutputStream(fileURL);
                byte data[] = new byte[1024]; // our buffer
                int sum = 0;
                while ((number = input.read(data)) > 0) {
                    output.write(data, 0, number);
                    sum += number;
                    publishProgress(String.valueOf((sum * 100) / fileLength));
                }
                output.flush();
                output.close();
                input.close();

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Object o) {
            dismissDialog(progressType);
            Toast.makeText(context, "Mp3 downloading was completed, You can listen it.", Toast.LENGTH_SHORT).show();
        }

        @Override
        protected void onProgressUpdate(String[] values) {
            progressDialog.setProgress(Integer.parseInt(values[0]));
        }
    }

    public void listenMusic() {
        Uri myUri = Uri.parse(fileURL);
        player = new MediaPlayer();
        player.setAudioStreamType(AudioManager.STREAM_MUSIC);
        try {
            player.setDataSource(context, myUri);
            player.prepare();
            player.start();
            player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    Toast.makeText(context, "Music finished", Toast.LENGTH_SHORT).show();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
