//package com.runkevich8.gmail.test.classwork.classwork8;
//
//
//import android.databinding.ObservableBoolean;
//import android.databinding.ObservableField;
//import android.databinding.ObservableInt;
//import android.util.Log;
//
//import com.gmail.runkevich8.domain.entity.UserEntity;
//import com.runkevich8.gmail.presentation.base.BaseViewModel;
//
//import io.reactivex.Observable;
//import io.reactivex.ObservableEmitter;
//import io.reactivex.ObservableOnSubscribe;
//import io.reactivex.Observer;
//import io.reactivex.android.schedulers.AndroidSchedulers;
//import io.reactivex.disposables.Disposable;
//import io.reactivex.schedulers.Schedulers;
//
//public class UserViewModel extends BaseViewModel {
//
//    public final ObservableField<String> username = new ObservableField<String>("");
//    public final ObservableField<String> profileurl = new ObservableField<String>("");
//    public final ObservableInt age = new ObservableInt();
//    public final ObservableBoolean progressVisible = new ObservableBoolean(false);
//
//    @Override //сами сделали - не андроидовский
//    public void onResume() {
//        progressVisible.set(true);
//        Observable.create(new ObservableOnSubscribe<UserEntity>() {
//            @Override
//            public void subscribe(ObservableEmitter<UserEntity> emitter) throws Exception {
//                Thread.sleep(5000);
//
//                UserEntity entity = new UserEntity("my username",20,
//                        "http://www.freeiconspng.com/uploads/spongebob-and-patrick-png-6.png");
//
//                emitter.onNext(entity);//переекинь данне какие-то в UI поток
//                emitter.onComplete();//закончили с этими данными
//
//               // emitter.onError(Throwable error);
//            }
//        })
//                //эти метода решают кто в каком потоке будет запускаться
//                .subscribeOn(Schedulers.io())                    //в каком потоке выполнится
//                .observeOn(AndroidSchedulers.mainThread())     // observeOn ---- в каком потоке получить результат
//
//
//                .subscribe(new Observer<UserEntity>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//                        Log.e("OOOOOOOOOOOOOOOO","onSubscribe");
//                    }
//
//                    @Override
//                    public void onNext(UserEntity userEntity) {
//                        Log.e("OOOOOOOOOOOOOOOO","onNext");
//
//                        username.set(userEntity.getUsername());
//                        profileurl.set(userEntity.getProfileUrl());
//                        age.set(userEntity.getAge());
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
//                });
//
//    }
//}
