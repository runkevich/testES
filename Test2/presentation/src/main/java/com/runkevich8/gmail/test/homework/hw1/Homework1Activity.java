package com.runkevich8.gmail.test.homework.hw1;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.runkevich8.gmail.test.R;

public class Homework1Activity extends AppCompatActivity implements View.OnClickListener {

    private Button button;
    private TextView textView1;
    private TextView textView2;
    private String text1;
    private String text2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hw1);

        button = findViewById(R.id.button2);
        textView1 = findViewById(R.id.textView);
        textView2 = findViewById(R.id.textView2);

        // 1 способ
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text1 = (String) textView1.getText();
                text2 = (String) textView2.getText();
                textView1.setText(text2);
                textView2.setText(text1);
            }
        });
        //2 способ
        textView1.setOnClickListener(this);


        //3 способ
        View.OnClickListener textView2Click = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text1 = (String) textView1.getText();
                text2 = (String) textView2.getText();
                textView1.setText(text2);
                textView2.setText(text1);
            }
        };

        textView2.setOnClickListener(textView2Click);
    }

    @Override
    public void onClick(View view) {
        text1 = (String) textView1.getText();
        text2 = (String) textView2.getText();
        textView1.setText(text2);
        textView2.setText(text1);
    }

}
