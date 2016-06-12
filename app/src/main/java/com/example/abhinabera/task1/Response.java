package com.example.abhinabera.task1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

/**
 * Created by Abhi Nabera on 6/7/2016.
 */
public class Response extends MainActivity {
    Button back;
    TextView message, date, time;
    DatePicker dp;
    TimePicker tp;
    int month, day, year, hour, minute;
    String name,am_pm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.response);

        back = (Button) findViewById(R.id.back);
        message = (TextView) findViewById(R.id.message);
        date = (TextView) findViewById(R.id.date);
        time = (TextView) findViewById(R.id.time);
        dp = (DatePicker) findViewById(R.id.datePicker);
        tp = (TimePicker) findViewById(R.id.timePicker);
        name = getIntent().getExtras().getString("name");
        message.setText("Thank you " + name + " for your response. Team Spider wishes you all the best for the induction process.");
        month = dp.getMonth() + 1;
        day = dp.getDayOfMonth();
        year = dp.getYear();
        date.setText("Date: " + day + "/" + month + "/" + year);
        hour = tp.getCurrentHour();
        minute = tp.getCurrentMinute();

        if(hour < 12)
        {
            am_pm = "AM";
        }
        else
        {
            am_pm = "PM";
            hour = hour - 12;
        }
        if(minute < 10) {
            time.setText("Time: " + hour + ":0" + minute + ":" + am_pm);
        }
        else time.setText("Time: " + hour + ":" + minute + ":" + am_pm);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(Response.this, MainActivity.class);
                startActivity(i);
            }
        });
    }
}
