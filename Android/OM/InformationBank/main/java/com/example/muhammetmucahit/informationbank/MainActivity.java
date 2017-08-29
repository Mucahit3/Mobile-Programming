package com.example.muhammetmucahit.informationbank;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private InformationStore information = new InformationStore();
    private Colors color = new Colors();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView txtVw_information = (TextView) findViewById(R.id.txtVw_information);
        final Button btn_showInformation = (Button) findViewById(R.id.btn_showInformation);
        final RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.lyt_mainRelative);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                txtVw_information.setText(information.getInformation());

                relativeLayout.setBackgroundColor(color.getColor());
                btn_showInformation.setTextColor(color.getColor());
            }
        };

        btn_showInformation.setOnClickListener(listener);

        /*
        String toastMessage = "My first android application :)";
        Toast firstToast = Toast.makeText(this, toastMessage, Toast.LENGTH_LONG);
        firstToast.show();
        */

        //Toast.makeText(this, "My first android application :)", Toast.LENGTH_LONG).show();

        Log.e(TAG, "Muhammet Mucahit Aktepe");

        // Bu yontem de dogru yukaridaki yontem de dogru.
        /*
        btn_showInformation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String information = "Plane goes 50 meters per second.";
                txtVw_information.setText(information);
            }
        });
        */
    }
}
