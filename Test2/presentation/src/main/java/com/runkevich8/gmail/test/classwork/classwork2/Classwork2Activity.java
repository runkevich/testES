package com.runkevich8.gmail.test.classwork.classwork2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.runkevich8.gmail.test.R;


public class Classwork2Activity extends AppCompatActivity {

    public static final String KEY_TEXT = "KEY_TEXT";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classwork2);

        String text = getIntent().getStringExtra(KEY_TEXT);

       // Singleton singleton = Singleton.getInstance();

        if (text.contains("Hello")){
            Log.e("FFF","contain");
        }else {
            Log.e("Noo", "no contain");
        }
    }
}
