package com.runkevich8.gmail.app;

import android.app.Application;

import com.runkevich8.gmail.injection.AppComponent;
import com.runkevich8.gmail.injection.AppModule;
import com.runkevich8.gmail.injection.DaggerAppComponent;


public class App extends Application {

    public static AppComponent getAppComponent() {
        return appComponent;
    }

    private static AppComponent appComponent;

    //класс создается один раз при старте приложения в целом!
    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();

    }
}
