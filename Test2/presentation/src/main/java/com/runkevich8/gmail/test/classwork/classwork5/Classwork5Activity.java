package com.runkevich8.gmail.test.classwork.classwork5;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.runkevich8.gmail.test.R;

public class Classwork5Activity extends AppCompatActivity{

    private static  final  String TAG = Classwork5Activity.class.getSimpleName();

    private static  final  String ACTION_MY_MESSAGE = "com.runkevich8.gmail.test.classwork.classwork5.ACTION_MY_MESSAGE";
    private Button button;
    private LocalBroadcastManager broadcastManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classwork5);

        broadcastManager = LocalBroadcastManager.getInstance(this);

        button = findViewById(R.id.buttonCW5);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(ACTION_MY_MESSAGE);
               // intent.setAction(ACTION_MY_MESSAGE);

                broadcastManager.sendBroadcast(intent);

            }
        });

    }

    private BroadcastReceiver myReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            Log.e("OOOOOOOOOOOOOOOOO","MY MESSAGE FROM ACTIVITY");

//            boolean isAirplaneModeOn = intent.getBooleanExtra("state",
//                    false);
//            if (isAirplaneModeOn){
//                Log.e("OOOOOOOOOOOOOOOOO","MESSAGE FROM ACTIVITY ON");
//            } else {
//                Log.e("OOOOOOOOOOOOOOOOO","MESSAGE FROM ACTIVITY OFF");
//            }

        }
    };

    @Override
    protected void onStart() {
        super.onStart();

        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ACTION_MY_MESSAGE);

        broadcastManager.registerReceiver(myReceiver, intentFilter);

        Intent intent = new Intent(this,
                MyService.class);
        startService(intent);

        //_________________IntentService__________________________________________________________________
        Intent intent2 = new Intent(this,
                MyIntentService.class); // задание для intentService (пример : скачка фильмов по очереди)
        intent2.putExtra(MyIntentService.KEY_LINK, "http://film1");
        startService(intent2);

        Intent intent3 = new Intent(this,
                MyIntentService.class);
        intent3.putExtra(MyIntentService.KEY_LINK, "http://film2");
        startService(intent3);

        Intent intent4 = new Intent(this,
                MyIntentService.class);
        intent4.putExtra(MyIntentService.KEY_LINK, "http://film3");
        startService(intent4);

        //bindService() - привязка

        //Какие способы запуска сервиса? -  startService - умирает толкьое после stopService,
        // bindService - живет до тех пор ,пока есть подписчики


        //важный - взаимодействие напрямую с пользователем
        // и неважный сервис - сервис, который может работать на фоне

        //подключается по умолчанию в UI потоке,можно и в другом,но не стоит

    }

    @Override
    protected void onStop() {
        super.onStop();
        broadcastManager.unregisterReceiver(myReceiver);

        stopService(new Intent(this,
                MyService.class));
    }
}
