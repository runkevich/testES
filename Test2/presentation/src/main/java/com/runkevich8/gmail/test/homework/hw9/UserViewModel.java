package com.runkevich8.gmail.test.homework.hw9;


import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;

import io.reactivex.Observable;

public class UserViewModel {

    public final ObservableField<String> username = new ObservableField<String>("");
    public final ObservableField<String> profileurl = new ObservableField<String>("");
    public final ObservableInt age = new ObservableInt();
    public final ObservableBoolean gender = new ObservableBoolean();
    public final ObservableBoolean progressVisible = new ObservableBoolean();

    private Observable<User> observableUser;

    //@Override //сами сделали - не андроидовский
    public void onResume() {

        observableUser = Observable.just(new User("Katya ","Runkevich","22",
                               "http://www.freeiconspng.com/uploads/spongebob-and-patrick-png-6.png",true));
//        progressVisible.set(true);
//        Observable.create(new ObservableOnSubscribe<UserEntity>() {
//            @Override
//            public void subscribe(ObservableEmitter<UserEntity> emitter) throws Exception {
//                Thread.sleep(2000);
//
//                UserEntity entity =
//                        new UserEntity("Katya Runkevich",22,
//                                "http://www.freeiconspng.com/uploads/spongebob-and-patrick-png-6.png",true);
//                emitter.onNext(entity);//переекинь данне какие-то в UI поток
//
//                emitter.onComplete();//закончили с этими данными
//
//                // emitter.onError(Throwable error);
//            }
//        })
//                //эти метода решают кто в каком потоке будет запускаться
//                .subscribeOn(Schedulers.io())                    //в каком потоке выполнится
//                .observeOn(AndroidSchedulers.mainThread())     // observeOn ---- в каком потоке получить результат
//

//               observableUser.subscribe(new Consumer<UserEntity>() {
//                    @Override
//                    public void accept(UserEntity userEntity) throws Exception {
//                        username.set(userEntity.getUsername());
//                        profileurl.set(userEntity.getProfileUrl());
//                        age.set(userEntity.getAge());
//                        gender.set(userEntity.isGender());
//                    }
//                })
//                .subscribe(new Observer<UserEntity>() {
//
//                    @Override
//                    public void onSubscribe(Disposable d) {
//                        Log.e("OOOOOOOOOOOOOOOO","onSubscribe");
//                        compositeDisposable.add(d);
//                    }
//
//                    @Override
//                    public void onNext(UserEntity userEntity) {
//                        Log.e("OOOOOOOOOOOOOOOO","onNext");
//
//                        username.set(userEntity.getUsername());
//                        profileurl.set(userEntity.getProfileUrl());
//                        age.set(userEntity.getAge());
//                        gender.set(userEntity.isGender());
//
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        Log.e("OOOOOOOOOOOOOOOO","onError");
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        Log.e("OOOOOOOOOOOOOOOO","onComplete");
//                        progressVisible.set(false);
//                    }
//
//                });
    }

//    @Override
//    public void onPause() {
//        super.onPause();
//        compositeDisposable.dispose();
//    }


}
