package ca.massageinhome.massagein;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class BookingActivity extends AppCompatActivity {

    String date_time = "";
    int mYear;
    int mMonth;
    int mDay;

    int mHour;
    int mMinute;

    int selection=0;

    TextView startdatetime,enddatetime;
    Button min60,min75,min90;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        startdatetime = findViewById(R.id.startdatetime);
        enddatetime = findViewById(R.id.enddatetime);

        min60 = findViewById(R.id.min60);
        min75 = findViewById(R.id.min75);
        min90 = findViewById(R.id.min90);

        min60.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                if(selection == 0)
                {
                    min60.setBackgroundResource(R.drawable.round_white);
                    min60.setTextColor(Color.BLACK);
                    selection=1;
                }
                else if(selection == 1)
                {
                    min60.setBackgroundResource(R.drawable.round_circle);
                    min60.setTextColor(Color.WHITE);
                    selection=0;
                }
                else if(selection == 2)
                {
                    min60.setBackgroundResource(R.drawable.round_white);
                    min60.setTextColor(Color.BLACK);
                    selection=1;

                    min75.setBackgroundResource(R.drawable.round_circle);
                    min75.setTextColor(Color.WHITE);
                }
                else if(selection == 3)
                {
                    min60.setBackgroundResource(R.drawable.round_white);
                    min60.setTextColor(Color.BLACK);
                    selection=1;

                    min90.setBackgroundResource(R.drawable.round_circle);
                    min90.setTextColor(Color.WHITE);

                }
            }
        });

        min75.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(selection == 0)
                {
                    min75.setBackgroundResource(R.drawable.round_white);
                    min75.setTextColor(Color.BLACK);
                    selection=2;
                }
                else if(selection == 1)
                {
                    min75.setBackgroundResource(R.drawable.round_white);
                    min75.setTextColor(Color.BLACK);
                    selection=2;

                    min60.setBackgroundResource(R.drawable.round_circle);
                    min60.setTextColor(Color.WHITE);

                }
                else if(selection == 2)
                {
                    min75.setBackgroundResource(R.drawable.round_circle);
                    min75.setTextColor(Color.WHITE);
                    selection=0;

                }
                else if(selection == 3)
                {
                    min75.setBackgroundResource(R.drawable.round_white);
                    min75.setTextColor(Color.BLACK);
                    selection=2;

                    min90.setBackgroundResource(R.drawable.round_circle);
                    min90.setTextColor(Color.WHITE);

                }
            }
        });

        min90.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(selection == 0)
                {
                    min90.setBackgroundResource(R.drawable.round_white);
                    min90.setTextColor(Color.BLACK);
                    selection=3;
                }
                else if(selection == 1)
                {
                    min90.setBackgroundResource(R.drawable.round_white);
                    min90.setTextColor(Color.BLACK);
                    selection=3;

                    min60.setBackgroundResource(R.drawable.round_circle);
                    min60.setTextColor(Color.WHITE);

                }
                else if(selection == 2)
                {
                    min90.setBackgroundResource(R.drawable.round_white);
                    min90.setTextColor(Color.BLACK);
                    selection=3;

                    min75.setBackgroundColor(R.drawable.round_circle);
                    min75.setTextColor(Color.WHITE);

                }
                else if(selection == 3)
                {
                    min90.setBackgroundColor(R.drawable.round_circle);
                    min90.setTextColor(Color.WHITE);
                    selection=0;


                }

            }
        });


        startdatetime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePicker(0);
            }
        });

        enddatetime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timePicker(1);
            }
        });
    }

    private void datePicker(final int i){

        // Get Current Date
        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year,int monthOfYear, int dayOfMonth) {

                        date_time = dayOfMonth + "-" + (monthOfYear + 1) + "-" + year;
                        //*************Call Time Picker Here ********************
                        timePicker(i);
                    }
                }, mYear, mMonth, mDay);
        datePickerDialog.show();
    }

    private void timePicker(final int i){
        // Get Current Time
        final Calendar c = Calendar.getInstance();
        mHour = c.get(Calendar.HOUR_OF_DAY);
        mMinute = c.get(Calendar.MINUTE);

        // Launch Time Picker Dialog
        final TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {

                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay,int minute) {

                        mHour = hourOfDay;
                        mMinute = minute;

                        if(i==0){
                        startdatetime.setText(hourOfDay + ":" + minute+"  "+date_time);
                    }
                    else{
                            enddatetime.setText(hourOfDay + ":" + minute+"  "+date_time);

                        }
                    }
                }, mHour, mMinute, false);
        timePickerDialog.show();
    }
}
