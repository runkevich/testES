package com.runkevich8.gmail.test.homework.hw7;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.runkevich8.gmail.test.R;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;

public class Homework7Activity extends AppCompatActivity implements PublishContract{

    public PublishSubject<Integer> publishSubject =PublishSubject.create(); //почта - умеет получать событие
    private int count = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hw7);

        findViewById(R.id.buttonFrgment_hw7).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                publishSubject.onNext(count);
                count++;
            }
        });

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.containerFragment_hw7, OneFragmentHw7.getInstance());
        fragmentTransaction.commit();
    }


    @Override
    public Observable<Integer> getObservable() {
        return publishSubject;
    }
}
