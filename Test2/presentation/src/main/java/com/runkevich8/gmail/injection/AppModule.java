package com.runkevich8.gmail.injection;


import android.content.Context;

import com.gmail.runkevich8.data.net.RestApi;
import com.gmail.runkevich8.data.net.RestService;
import com.gmail.runkevich8.data.repository.UserRepositoryImpl;
import com.gmail.runkevich8.domain.executor.PostExecutionThread;
import com.gmail.runkevich8.domain.repository.UserRepository;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.runkevich8.gmail.executor.UIThread;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class AppModule {
    //Модуль - это класс, который предоставляет реализацию зависимостей

    Context context;

    public AppModule(Context context) {
        this.context = context;
    }

    @Provides
    @Singleton
    public Context getContext(){
        return context;
    }

    @Provides
    @Singleton
    public PostExecutionThread getUiThread(){ //1 способ (1=2 - значение одно и то же)
        return new UIThread();
    }

//    2 способ
//    @Binds
//    public abstract PostExecutionThread getUiThread(UIThread uiThread);



    @Provides
    @Singleton
    public UserRepository getUserRepository(Context context,
                                            RestService restService){
        return new UserRepositoryImpl(context,restService);
    }
//______________________________________
    @Provides
    @Singleton
    public Retrofit getRetrofit(Gson gson){

        return  new Retrofit.Builder()
                //.addCallAdapterFactory()
                //.addConverterFactory()
       //         .baseUrl(BuildConfig.APPLICATION_ID)
                .build();
       // .baseUrl(BuildConfig.)
    }

    @Provides
    @Singleton
    public RestApi getRestApi(Retrofit retrofit){

        return retrofit.create(RestApi.class);
    }
//_________________________________________________
    @Provides
    @Singleton
    public Gson getGson(){
        return new GsonBuilder()
                //в этом промежутки можно еще разные методы писать например GsonBuilderData
                .create();
    }

}
