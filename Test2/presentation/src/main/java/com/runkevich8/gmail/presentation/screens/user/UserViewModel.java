package com.runkevich8.gmail.presentation.screens.user;


import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.util.Log;

import com.gmail.runkevich8.domain.entity.UserEntity;
import com.gmail.runkevich8.domain.interactor.GetUserByIdUseCase;
import com.runkevich8.gmail.app.App;
import com.runkevich8.gmail.presentation.base.BaseViewModel;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class UserViewModel extends BaseViewModel {


    @Inject
    public GetUserByIdUseCase getUserByIdUseCase ;
           // new GetUserByIdUseCase(new UIThread(),new UserRepositoryImpl());

    public final ObservableField<String> username = new ObservableField<String>("");
    public final ObservableField<String> profileurl = new ObservableField<String>("");
    public final ObservableInt age = new ObservableInt();
    public final ObservableBoolean gender = new ObservableBoolean();
    public final ObservableBoolean progressVisible = new ObservableBoolean();

    @Override
    public void createInject() {
        App.getAppComponent().inject(this);
    }
    //затем будет его создавать андроид
    public UserViewModel() {

        super();

        progressVisible.set(true);
        getUserByIdUseCase
                .get("id")
                .subscribe(new Observer<UserEntity>() {

                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e("OOOOOOOOOOOOOOOO","onSubscribe");
                        compositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(UserEntity userEntity) {
                        Log.e("OOOOOOOOOOOOOOOO","onNext");

                        username.set(userEntity.getUsername());
                        profileurl.set(userEntity.getProfileUrl());
                        age.set(userEntity.getAge());
                        gender.set(userEntity.isGender());

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("OOOOOOOOOOOOOOOO","onError");
                    }

                    @Override
                    public void onComplete() {
                        Log.e("OOOOOOOOOOOOOOOO","onComplete");
                        progressVisible.set(false);
                    }
                });
    }


}
