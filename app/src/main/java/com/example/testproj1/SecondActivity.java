package com.example.testproj1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Date;


public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layoutsecond);

        Button button3 = findViewById(R.id.button3);
        CalendarView calendarView1 = findViewById(R.id.calendarView1);
        EditText editText7 = findViewById(R.id.editText7);

        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

        editText7.setText(sdf.format(new Date(calendarView1.getDate())));

        button3.setOnClickListener(v -> {
            Intent intent = new Intent(SecondActivity.this, MainActivity.class);
            startActivity(intent);
        });

        calendarView1.setOnDateChangeListener((view, year, month, dayOfMonth) -> editText7.setText(dayOfMonth + "." + month + "." + year));
    }
}
