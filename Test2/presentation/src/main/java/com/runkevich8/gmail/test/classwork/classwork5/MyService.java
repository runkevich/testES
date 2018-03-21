package com.runkevich8.gmail.test.classwork.classwork5;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;


public class MyService extends Service {

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("Service ","OnCreate()");

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("Service ","OnDestroy()");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e("Service ","onStartCommand()");
        return super.onStartCommand(intent, flags, startId);
    }





    @Nullable
    @Override
    public IBinder onBind(Intent intent) { // подключение! к сервису
        Log.e("Service ","onBind()");
        return null;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.e("Service ","onUnbind()");
        return super.onUnbind(intent);
    }
}
