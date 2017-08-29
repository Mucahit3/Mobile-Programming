package com.example.muhammetmucahit.accessingfolderandlist;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.support.v4.content.MimeTypeFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Context context = this;
    ArrayList<FileEx> list = new ArrayList<>();
    ArrayList<FileEx> emptyList = new ArrayList<>();
    GridView gridView;
    Button btn_back, btn_write, btn_read;
    EditText editText_enterValue;
    String PATH = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = (GridView) findViewById(R.id.gridView);
        btn_back = (Button) findViewById(R.id.btn_back);
        btn_read = (Button) findViewById(R.id.btn_read);
        btn_write = (Button) findViewById(R.id.btn_write);
        editText_enterValue = (EditText) findViewById(R.id.editText_enterValue);

        PATH = Environment.getExternalStorageDirectory().getPath();
        list = getFileList(PATH);

        if(list != null && list.size() > 0)
            gridView.setAdapter(new FileExAdapter(context, list));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                FileEx fileEx = list.get(i);
                File file = new File(PATH);
                if(fileEx.isFolder && fileEx.getExtension().equals("")){
                    gridView.setAdapter(new FileExAdapter(context, emptyList));
                }
                if(fileEx.isFolder && getFileList(fileEx.getPath()) != null){
                    PATH += "/" + fileEx.getName();
                    list = getFileList(PATH);
                    if(list != null && list.size() > 0){
                        gridView.setAdapter(new FileExAdapter(context, list));
                        Log.i("NewPath", PATH);
                    }
                } else {
                    PATH += "/" + fileEx.getName();
                    file = new File(PATH);
                    Intent intent = new Intent();
                    intent.setAction(Intent.ACTION_VIEW);
                    MimeTypeMap mime = MimeTypeMap.getSingleton();
                    String extension = file.getName().substring(file.getName().lastIndexOf(".") + 1);
                    String type = mime.getMimeTypeFromExtension(extension);
                    intent.setDataAndType(Uri.fromFile(file), type);
                    startActivity(intent);
                }
            }
        });

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PATH = PATH.substring(0, PATH.lastIndexOf('/'));
                list = getFileList(PATH);
                if(list != null && list.size() > 0){
                    gridView.setAdapter(new FileExAdapter(context, list));
                }
            }
        });

        btn_write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                File folder = new File(PATH + "/MyFolder");
                folder.mkdirs();
                File file = new File(folder + "/file.txt");
                try {
                    file.createNewFile();
                    FileOutputStream fos = new FileOutputStream(file);
                    OutputStreamWriter osw = new OutputStreamWriter(fos);
                    if(!editText_enterValue.getText().toString().isEmpty()){
                        osw.append(editText_enterValue.getText().toString());
                    } else{
                        Toast.makeText(context, "Please enter a value", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    osw.close();
                    fos.close();
                    editText_enterValue.setText("");
                    list = getFileList(PATH);
                    if(list != null && list.size() > 0){
                        gridView.setAdapter(new FileExAdapter(context, list));
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        btn_read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                File folder = new File(PATH + "/MyFolder");
                folder.mkdirs();
                File file = new File(folder + "/file.txt");
                try {
                    FileInputStream fis = new FileInputStream(file);
                    InputStreamReader isr = new InputStreamReader(fis);
                    BufferedReader buffer = new BufferedReader(isr);
                    String line;
                    String output = "";
                    for(;;){
                        line = buffer.readLine();
                        if(line != null){
                            output += null;
                        } else {
                            break;
                        }
                    }
                    editText_enterValue.setText(output);
                    buffer.close();
                    isr.close();
                    fis.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e){
                    e.printStackTrace();
                }
            }
        });
    }

    public ArrayList<FileEx> getFileList(String path){

        ArrayList<FileEx> tempList = new ArrayList<>();
        File file = new File(path); // storage/emulated/0
        Log.i("PathInformation", file.toString());
        if(file.isDirectory()){
            File[] fileArray = file.listFiles();
            Log.i("fileArrayFirst", fileArray[0].toString());
            if(fileArray != null && fileArray.length > 0){
                for (File file_item : fileArray){
                    FileEx tempFex = new FileEx();
                    File tempFile = file_item;
                    tempFex.setName(tempFile.getName());
                    tempFex.setPath(tempFile.getAbsolutePath());
                    tempFex.setFolder(tempFile.isDirectory());
                    if(tempFile.isDirectory())
                        tempFex.setExtension("");
                    else
                        tempFex.setExtension(tempFile.getName().substring(tempFile.getName().lastIndexOf(".") + 1)); //txt

                    tempList.add(tempFex);
                }
                return tempList;
            } else
                return null;
        }

        return null;
    }
}
