package com.example.testproj1;

import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] colorArray = {"#ffffcc", "#80d4ff", "#ffb31a", "#4da6ff", "#ac00e6", "#53c653", "#ffaa80", "#d1d1e0", "#7a7a52", "#bf4040"};
        Random rnd = new Random();

        ToggleButton toggleButton1 = findViewById(R.id.togBut1);
        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        LinearLayout linearLayout1 = findViewById(R.id.linearLayout1);
        Switch switch1 = findViewById(R.id.switch1);
        CheckBox checkBox1 = findViewById(R.id.checkBox1);
        TextView textView1 = findViewById(R.id.textView1);
        EditText editText1 = findViewById(R.id.editText1);

        toggleButton1.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                toggleButton1.setTextColor(Color.parseColor("#3366ff"));
            } else {
                toggleButton1.setTextColor(Color.parseColor("#ff0000"));
            }
        });

        button1.setOnClickListener(v -> linearLayout1.setBackgroundColor(Color.parseColor(colorArray[rnd.nextInt(9)])));

        switch1.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                switch1.setText("туда");
            } else {
                switch1.setText("сюда");
            }
        });

        checkBox1.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (!isChecked) {
                textView1.setVisibility(View.VISIBLE);
                toggleButton1.setVisibility(View.VISIBLE);
                button1.setVisibility(View.VISIBLE);
                switch1.setVisibility(View.VISIBLE);
                editText1.setVisibility(View.VISIBLE);
            } else {
                textView1.setVisibility(View.INVISIBLE);
                toggleButton1.setVisibility(View.INVISIBLE);
                button1.setVisibility(View.INVISIBLE);
                switch1.setVisibility(View.INVISIBLE);
                editText1.setVisibility(View.INVISIBLE);
            }
        });

        button2.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(intent);
        });
    }
}