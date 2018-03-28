
package com.example.mahe.lab5q31;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.Calendar;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends Activity implements

        AdapterView.OnItemSelectedListener {

int f=0;
    String[] src = { "MUMBAI", "BANGALORE", "KOLKATA", "HYDERABAD", "DELHI",  };

    // String[] dest = { "BANKOK", "CHINA", "SINGAPORE", "NYC", "MUMBAI",  };

    public static final String EXTRA_MESSAGE = "com.example.lab5q1.MESSAGE";
    public static final String EXTRA_MESSAGE2 = "com.example.lab5q1.MESSAGE2";
    public static final String EXTRA_MESSAGE3 = "com.example.lab5q1.MESSAGE3";
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Getting the instance of Spinner and applying OnItemSelectedListener on it
        Spinner spin = (Spinner) findViewById(R.id.spinner);
        spin.setOnItemSelectedListener(this);
        // Spinner spin2 = (Spinner) findViewById(R.id.spinner2);
        // spin2.setOnItemSelectedListener(this);

        //Creating the ArrayAdapter instance having the country list
        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,src);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // ArrayAdapter a = new ArrayAdapter(this,android.R.layout.simple_spinner_item,dest);
        // a.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        //spin.setAdapter(a);
        spin.setAdapter(aa);
        ToggleButton t=(ToggleButton)findViewById(R.id.toggleButton);
        t.setTextOn("General");
        t.setTextOff("Tatkal");
        t.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    f = 1;
                }
                else
                    {
                        TimePicker timepicker = (TimePicker) findViewById(R.id.timePicker);
                        int hour = timepicker.getHour();
                        timepicker.setIs24HourView(true);
                        if (hour <=11)
                        {
                            Context context = getApplicationContext();
                            int duration = Toast.LENGTH_LONG;
                            Toast toast = Toast.makeText(context,"available only after 11pm", duration);
                            toast.show();
                            f=0;
                        }
                }
            }
        });


    }


    //Performing action onItemSelected and onNothing selected
    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position,long id) {
        Toast.makeText(getApplicationContext(),src[position] ,Toast.LENGTH_LONG).show();

    }


    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub

    }
    public void onClick(View view)
    {
        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

// set current date into datepicker
        DatePicker datepicker = (DatePicker) findViewById(R.id.datePicker);
        datepicker.init(year, month, day, null);
        TimePicker timepicker=(TimePicker)findViewById(R.id.timePicker);
        //Calendar c = Calendar.getInstance();
        timepicker.setHour(c.get(Calendar.HOUR));
        timepicker.setMinute(c.get(Calendar.MINUTE));
    }
    //@android.support.annotation.RequiresApi(api = Build.VERSION_CODES.M)
    public void onClick1(View view)
    {
        if(f==1)
        {
            DatePicker datePicker = (DatePicker) findViewById(R.id.datePicker);
            TimePicker timepicker = (TimePicker) findViewById(R.id.timePicker);
            timepicker.setIs24HourView(true);
            int minute = timepicker.getMinute();
             int hour = timepicker.getHour();
            String time = Integer.toString(hour) + ":" + Integer.toString(minute);
            Intent intent1 = new Intent(this, newpage.class);
            intent1.putExtra(EXTRA_MESSAGE2, time);


            int day = datePicker.getDayOfMonth();
            int month = datePicker.getMonth() + 1;
            int year = datePicker.getYear();
            String message = day + "," + month + "," + year;
            intent1.putExtra(EXTRA_MESSAGE, message);


            Spinner spin = (Spinner) findViewById(R.id.spinner);
            String s = spin.getItemAtPosition(spin.getSelectedItemPosition()).toString();
            intent1.putExtra(EXTRA_MESSAGE3, s);
            startActivity(intent1);
        }

        }

    }



