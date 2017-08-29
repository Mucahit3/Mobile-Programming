package com.delta.activities;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

/**
 * Created by Muhammet Mucahit on 8/4/2017.
 */

public class DetailActivity extends Activity{

    private Button mReturnButton = null;
    private Spinner mSpinner = null;
    private Button mResumeButton = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Bundle extras = getIntent().getExtras();

        if(extras != null) {
            String detailValue = extras.getString("KeyForSending");
            if(detailValue != null){
                Toast.makeText(this, detailValue, Toast.LENGTH_SHORT).show();
            }
        }

        mSpinner = (Spinner) findViewById(R.id.spinnerSelection);

        mReturnButton = (Button) findViewById(R.id.returnToSecondActivity);
        mReturnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent returnIntent = new Intent();
                String mySelection = mSpinner.getSelectedItem().toString();
                returnIntent.putExtra("KeyForReturning", mySelection);
                setResult(RESULT_OK, returnIntent);
                finish();
            }
        });

        mResumeButton = (Button) findViewById(R.id.performImplicit);
        mResumeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent implicitIntent = null;
                int position = mSpinner.getSelectedItemPosition();

                switch (position){
                    case 0:
                        break;
                    case 1:
                        implicitIntent = new Intent(Intent.ACTION_VIEW,
                                Uri.parse("http://deltaprogram.us"));
                        break;
                    case 2:
                        implicitIntent = new Intent(Intent.ACTION_DIAL,
                                Uri.parse("tel:(+90)5416219448"));
                        break;
                    case 3:
                        implicitIntent = new Intent(Intent.ACTION_VIEW,
                                Uri.parse("geo: 30.2715, -97.742"));
                        break;
                    case 4:
                        implicitIntent = new Intent("android.media.action.IMAGE_CAPTURE");
                        break;
                    case 5:
                        implicitIntent = new Intent(Intent.ACTION_EDIT,
                                Uri.parse("content://contacts/people/1"));
                        break;
                    if(implicitIntent != null){
                        if(isIntentAvailable(implicitIntent) == true){
                            startActivity(implicitIntent);
                        }
                        else{
                            Toast.makeText(view.getContext(), "no application available", Toast.LENGTH_LONG).show();
                        }
                    }

                }
            }
        });
    }

    public boolean isIntentAvailable(Intent intent){
        PackageManager packageManager = getPackageManager();
        List<ResolveInfo> activities = packageManager.queryIntentActivities(intent, 0);
        boolean isIntentSafe = activities.size() > 0;
        return isIntentSafe;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.first, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
