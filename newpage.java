package com.example.mahe.lab5q31;

        import android.app.Activity;
        import android.content.Context;
        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.ArrayAdapter;
        import android.widget.ListView;
        import android.widget.TextView;
        import android.widget.Toast;

        import java.util.ArrayList;
        import java.util.List;

public class newpage extends Activity {
    String message;
    String message2;
    String message3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newpage2);
        Intent intent = getIntent();
        message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        message2 = intent.getStringExtra(MainActivity.EXTRA_MESSAGE2);
        message3 = intent.getStringExtra(MainActivity.EXTRA_MESSAGE3);
        // Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.textView);
        TextView textView2 = findViewById(R.id.textView2);
        TextView textView3 = findViewById(R.id.textView3);
        textView.setText(message);
        textView2.setText(message2);
        textView3.setText(message3);


    }

    public void OnClick(View view) {

        String[] acc_date = {"f1", "f2", "f3", "f4", "f5"};
        String[] acc_time = {"f4", "f5", "f6", "f7", "f8"};
        String[] acc_city = {"f9", "f10", "f11", "f12", "f13"};
        int i = message.indexOf(',');
        String s = message.substring(0, i);
        int date = Integer.parseInt(s);
        int j = message2.indexOf(':');
        String s1 = message.substring(0, i);
        int time = Integer.parseInt(s1);
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(context, s + "," + s1 + "," + message3, duration);
        toast.show();
        ListView lv = (ListView) findViewById(R.id.listview);
        ArrayList<String> values = new ArrayList<String>();
        if (date > 0 && date < 5 || time > 1 && time < 6 || (message3.equals("MUMBAI"))) {
            values.add(acc_date[0]);
            values.add(acc_time[0]);
            values.add(acc_city[0]);
        }
        if (date > 5 && date < 10 || time > 6 || time < 12 || (message3.equals("BANGALORE"))) {
            values.add(acc_date[1]);
            values.add(acc_time[1]);
            values.add(acc_city[1]);
        }
        if (date > 10 && date < 15 || time > 12 || time < 18 || (message3.equals("DELHI"))) {
            values.add(acc_date[2]);
            values.add(acc_time[2]);
            values.add(acc_city[2]);
            if (date > 15 ||date < 20 ||time > 18 && time < 24 || (message3.equals("HYDERABAD"))) {
                values.add(acc_date[3]);
                values.add(acc_time[3]);
                values.add(acc_city[3]);
            }

            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, values);


            lv.setAdapter(adapter);


        }
    }
}
