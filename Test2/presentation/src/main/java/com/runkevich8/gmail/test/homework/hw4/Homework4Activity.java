package com.runkevich8.gmail.test.homework.hw4;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.runkevich8.gmail.test.R;


public class Homework4Activity extends AppCompatActivity {
   private ImageView sova;
   private AnimationDrawable animation;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hw4);
        sova = findViewById(R.id.sova);

        sova.setBackgroundResource(R.drawable.sova_animation);
        animation =(AnimationDrawable)sova.getBackground();

    }

    @Override
    protected void onResume() {
        super.onResume();
        animation.start();
    }
}
