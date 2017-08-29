package com.example.muhammetmucahit.navigationdriveractivity;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Muhammet Mucahit on 8/20/2017.
 */

public class FragmentWindowsPhone extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_windowsphonefragment, container, false);
        return view;
    }
}
