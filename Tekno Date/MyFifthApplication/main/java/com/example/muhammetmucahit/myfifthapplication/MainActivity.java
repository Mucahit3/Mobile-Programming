package com.example.muhammetmucahit.myfifthapplication;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

//    Switch aSwitch;
//    Button show;
//    TextView result;
//    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        WindowManager wm = (WindowManager) getSystemService(WINDOW_SERVICE);
        Display dsp = wm.getDefaultDisplay();

        if(dsp.getHeight() > dsp.getWidth())
            setContentView(R.layout.activity_main);
        else if(dsp.getHeight() < dsp.getWidth())
            setContentView(R.layout.portrait_landscape);


//        aSwitch = (Switch) findViewById(R.id.aSwitch);
//        show = (Button) findViewById(R.id.btnDisplay);
//        result = (TextView) findViewById(R.id.textView);
//
//        show.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if(aSwitch.isChecked()){
//                    Toast.makeText(context, "Checked", Toast.LENGTH_SHORT).show();
//                }
//                else{
//                    Toast.makeText(context, "Not Checked", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
//
//        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton mySwitch, boolean b) {
//                if(b)
//                    result.setText(aSwitch.getTextOn());
//                else{
//                    result.setText(aSwitch.getTextOff());
//                    //mySwitch.setEnabled(false);
//                }
//
//            }
//        });
    }
}
