package com.example.muhammetmucahit.accessingfolderandlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Muhammet Mucahit on 8/18/2017.
 */

public class FileExAdapter extends BaseAdapter {

    Context context;
    ArrayList<FileEx> fileExList = new ArrayList<>();
    LayoutInflater layoutInflater;

    public FileExAdapter(Context context, ArrayList<FileEx> fileExList) {
        this.context = context;
        this.fileExList = fileExList;
    }

    @Override
    public int getCount() {
        return fileExList.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        layoutInflater = LayoutInflater.from(context);
        View cell = layoutInflater.inflate(R.layout.cell, null);
        ImageView imageView = cell.findViewById(R.id.imageView);
        TextView textView_title = cell.findViewById(R.id.textView_title);
        FileEx fileEx = fileExList.get(i);
        textView_title.setText(fileEx.getName());
        if("png".toUpperCase().equals(fileEx.getExtension().toUpperCase())){
            imageView.setBackgroundResource(R.mipmap.ic_launcher);
        } else if("jpeg".toUpperCase().equals(fileEx.getExtension().toUpperCase())){
            imageView.setBackgroundResource(R.mipmap.ic_launcher);
        } else if("pdf".toUpperCase().equals(fileEx.getExtension().toUpperCase())){
            imageView.setBackgroundResource(R.mipmap.ic_launcher);
        } else if("txt".toUpperCase().equals(fileEx.getExtension().toUpperCase())){
            imageView.setBackgroundResource(R.mipmap.ic_launcher);
        } else {
            if(fileEx.isFolder){
                imageView.setBackgroundResource(R.mipmap.ic_launcher_round); // farkli resimler olacak iclerinde hepsi ic_launcher oldu.
            } else {
                imageView.setBackgroundResource(R.mipmap.ic_launcher);
            }
        }
        return cell;
    }
}
