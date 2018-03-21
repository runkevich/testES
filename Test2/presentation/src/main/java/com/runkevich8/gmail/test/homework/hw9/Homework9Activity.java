package com.runkevich8.gmail.test.homework.hw9;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.runkevich8.gmail.test.R;
import com.runkevich8.gmail.test.databinding.ActivityHw9Binding;

public class Homework9Activity extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        User user = new  User("Katya","Runkevich","22",
                "http://www.freeiconspng.com/uploads/spongebob-and-patrick-png-6.png",
                true);

        ActivityHw9Binding activityHw9Binding =
                DataBindingUtil.setContentView(this, R.layout.activity_hw9);
        activityHw9Binding.setUser(user);

        activityHw9Binding.colorImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User user1 =new  User("Katya","Runkevich","22",
                        "http://www.freeiconspng.com/uploads/spongebob-and-patrick-png-6.png",
                        false);
                activityHw9Binding.setUser(user1);
            }
        });

    }
}
