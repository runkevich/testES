package com.gmail.runkevich8.data.repository;


import android.content.Context;

import com.gmail.runkevich8.data.entity.User;
import com.gmail.runkevich8.data.net.RestService;
import com.gmail.runkevich8.domain.entity.UserEntity;
import com.gmail.runkevich8.domain.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.functions.Function;

public class UserRepositoryImpl implements UserRepository{

    private Context context;
    private RestService restService;

    public UserRepositoryImpl(Context context, RestService restService) {
        this.context = context;
        this.restService = restService;
    }

    @Override
    public Observable<UserEntity> get(String id) {

//
//        return   Observable.create(new ObservableOnSubscribe<UserEntity>() {
//            @Override
//           public void subscribe(ObservableEmitter<UserEntity> emitter) throws Exception {
//                Thread.sleep(2000);
//                UserEntity entity =
//                        new UserEntity("Katya Runkevich",22,
//                                "http://www.freeiconspng.com/uploads/spongebob-and-patrick-png-6.png",true);
//                emitter.onNext(entity);//переекинь данне какие-то в UI поток
//                emitter.onComplete();//закончили с этими данными
//
//            }
//        });
        return restService
                .loadUserById(id)
                .map(new Function<User, UserEntity>() {
                    @Override
                    public UserEntity apply(User user) throws Exception {
                        return new UserEntity(user.getUserName(),
                                user.getAge(),
                                user.getProfileUrl());
                    }
                });
    }

    @Override
    public Observable<List<UserEntity>> get() {
       // return Observable.just(new ArrayList<UserEntity>());
        return  restService
                .loadUsers()
                .map(new Function<List<User>, List<UserEntity>>() {
                    @Override
                    public List<UserEntity> apply(List<User> users) throws Exception {

                        List<UserEntity> list = new ArrayList<>();
                        for (User user: users){
                           list.add(new UserEntity(user.getUserName(),
                            user.getAge(),
                            user.getProfileUrl()));
                        }
                        return null;
                    }
                });
    }

    @Override
    public Completable save() {
        return null;
    }

    @Override
    public Completable remove() {
        return null;
    }
}
