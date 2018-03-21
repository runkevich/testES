package com.runkevich8.gmail.test.classwork.classwork1;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.runkevich8.gmail.test.R;
import com.runkevich8.gmail.test.classwork.classwork2.Classwork2Activity;
import com.runkevich8.gmail.test.classwork.classwork2.Singleton;

public class Classwork1Activity extends AppCompatActivity{

    private static final String TAG = Classwork1Activity.class.getSimpleName();
    private Button button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classwork1);


        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Singleton singleton = Singleton.getInstance();
                singleton.text = "Hoooooooooooooooo";

                Intent intent = new Intent(Classwork1Activity.this,
                        Classwork2Activity.class);
                intent.putExtra(Classwork2Activity.KEY_TEXT,"Hello-Hello!");



                startActivity(intent);
               // finish(); удаляет историю после открытия новой активити
               //   onBackPressed(); //1 способ возврата или finish()

            }
        });

        Log.e(TAG, "onCreate()");
    }



    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG, "onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(TAG, "onPause()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e(TAG, "onStart()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(TAG, "onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy()");
    }
}
