package com.runkevich8.gmail.test.homework.hw5;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;


public class WifiReceiver extends BroadcastReceiver {

    public WifiReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        boolean isVisible = MyApplication.isActivityVisible();
        // Check if
        // activity
        // is
        // visible
        // or not
        Log.i("Activity is Visible ", "Is activity visible : " + isVisible);

        // If it is visible then trigger the task else do nothing
        if (isVisible == true) {
            ConnectivityManager connectivityManager = (ConnectivityManager) context
                    .getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = connectivityManager
                    .getActiveNetworkInfo();

            // Check internet connection and accrding to state change the
            // text of activity by calling method
            if (networkInfo != null && networkInfo.isConnected()) {

                new Homework5Activity().changeTextStatus(true);
            } else {
                new Homework5Activity().changeTextStatus(false);
            }
        }
    }
}
