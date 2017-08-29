package com.delta.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Muhammet Mucahit on 8/4/2017.
 */

public class SecondActivity extends Activity {

    public static final int DETAIL_REQUEST = 1;
    private Button mButton = null;
    private Button mDetailButton = null;
    private TextView mSelectedView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        mSelectedView = (TextView) findViewById(R.id.userSelection);

        mButton = (Button) findViewById(R.id.goFirstActivty);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(), FirstActivity.class);
                startActivity(i);
            }
        });

        mDetailButton = (Button) findViewById(R.id.goDetailActivity);
        mDetailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(), DetailActivity.class);
                i.putExtra("KeyForSending", "Some data from SecondActivity");
                startActivityForResult(i,DETAIL_REQUEST);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode == RESULT_OK && requestCode == DETAIL_REQUEST){
            if(data.hasExtra("KeyForReturning")){
                String myValue = data.getExtras().getString("KeyForReturning");
                mSelectedView.setText(myValue);
            }
        }
    }
}
