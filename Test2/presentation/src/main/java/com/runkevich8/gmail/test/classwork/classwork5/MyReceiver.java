package com.runkevich8.gmail.test.classwork.classwork5;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

//сюда будут прилетать события, на которрые мы подписались

public class MyReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        intent.getAction();

        Log.e("OLA","MESSAGE");

    }
}
