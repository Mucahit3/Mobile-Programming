package com.example.muhammetmucahit.datepicker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    Button btn_changeDate;
    TextView txtVw_date;
    DatePicker dtPckr_result;
    StringBuilder result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_changeDate = (Button) findViewById(R.id.btn_changeDate);
        txtVw_date = (TextView) findViewById(R.id.txtVw_date);
        dtPckr_result = (DatePicker) findViewById(R.id.dtPckr_result);
        result = new StringBuilder();

        btn_changeDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.delete(0, result.length());
                Calendar now = Calendar.getInstance();
                int year = now.get(Calendar.YEAR);
                int month = now.get(Calendar.MONTH);
                int day = now.get(Calendar.DAY_OF_MONTH);
//                result.append(day).append("/").append(month).append("/").append(year);
//                txtVw_date.setText(result);

//                dtPckr_result.init(year, month, day, null);

                dtPckr_result.init(year, month, day, new DatePicker.OnDateChangedListener() {
                    @Override
                    public void onDateChanged(DatePicker datePicker, int i, int i1, int i2) {
                        result.delete(0, result.length());
                        result.append(i).append("/").append(i1).append("/").append(i2);
                        txtVw_date.setText(result);
                    }
                });

            }
        });
    }
}
