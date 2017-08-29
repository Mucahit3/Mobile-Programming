package com.example.muhammetmucahit.accessexternalstoragearea;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {
            File directory = Environment.getExternalStorageDirectory();
            Log.i("path", directory.getAbsolutePath());

            File subDirectory = new File(directory.getAbsolutePath() + "/trying");
            subDirectory.mkdirs();

            File file = new File(subDirectory, "file.txt");
            FileOutputStream fos = new FileOutputStream(file);
            OutputStreamWriter osw = new OutputStreamWriter(fos);
            osw.write("This is a try");
            osw.close();
            fos.close();
        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
