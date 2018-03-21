package com.runkevich8.gmail.test.classwork.classwork5;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;


public class MyIntentService extends IntentService {

    public static final String KEY_LINK = "KEY_LINK";

    //работает до тех пор пока есть какие-то задания
    public MyIntentService() {
        super("MyIntentService");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("OOO", "IntentService onDestroy()");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {

        String link = intent.getStringExtra(KEY_LINK);

        Log.e("AAA","IntentService " + link);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e){}

    }
    //всегда в отдеьном потоке подключается
    //с помощью BroadcastReceiver можно показать процент скачки фильмов
}
