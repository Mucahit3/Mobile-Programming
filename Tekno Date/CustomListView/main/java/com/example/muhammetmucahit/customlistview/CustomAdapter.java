package com.example.muhammetmucahit.customlistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Muhammet Mucahit on 8/17/2017.
 */

public class CustomAdapter extends BaseAdapter {

    Context context;
    List<MobileOS> mobile = new ArrayList<>();
    LayoutInflater inflater;

    public CustomAdapter(Context context, List<MobileOS> mobile) {
        this.context = context;
        this.mobile = mobile;
    }

    @Override
    public int getCount() {
        return mobile.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
        //return mobile.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        inflater = LayoutInflater.from(context);

        View row = inflater.inflate(R.layout.row, null);
        TextView textView_logo1 = row.findViewById(R.id.textView_logo1);
        ImageView imageView_logo1 = row.findViewById(R.id.imageView_logo1);
        MobileOS mobileOS = mobile.get(i);
        textView_logo1.setText(mobileOS.getName());
        //textView_logo1.setText(mobile.get(i).getName());

        if(mobileOS.getName().equals("IOS")){
            imageView_logo1.setImageResource(R.mipmap.ic_launcher);
        }else if(mobileOS.getName().equals("WindowsPhone")){
            imageView_logo1.setImageResource(R.mipmap.ic_launcher_round);
        }else if(mobileOS.getName().equals("Blackberry")){
            imageView_logo1.setImageResource(R.mipmap.ic_launcher);
        }else if(mobileOS.getName().equals("Android")){
            imageView_logo1.setImageResource(R.mipmap.ic_launcher_round);
        }

        return row;
    }
}
