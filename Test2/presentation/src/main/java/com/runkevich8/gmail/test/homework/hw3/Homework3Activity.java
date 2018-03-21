package com.runkevich8.gmail.test.homework.hw3;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.runkevich8.gmail.test.BuildConfig;
import com.runkevich8.gmail.test.R;


public class Homework3Activity extends AppCompatActivity {

    private Button button;
    private EditText editText;
    private ImageView imageView;
    private TextView textView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hw3);

        button = findViewById(R.id.button1_hw3);
        editText= findViewById(R.id.edit_text1_hw3);
        imageView = findViewById(R.id.image_view_hw3);
        textView = findViewById(R.id.textView1_hw3);

        View.OnClickListener btnClick = new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String link = String.valueOf(editText.getText());

                Glide
                        .with(getBaseContext())
                        .load(link)
                        .into(imageView);

                String text;
                text = String.valueOf(BuildConfig.BUILD_TYPE);
                textView.setText(text);
            }
        };

        button.setOnClickListener(btnClick);

    }
}
