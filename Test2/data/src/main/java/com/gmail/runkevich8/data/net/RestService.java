package com.gmail.runkevich8.data.net;

import com.gmail.runkevich8.data.entity.User;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import retrofit2.http.Path;

@Singleton
public class RestService {

    private RestApi restApi;

    @Inject
    public RestService(RestApi restApi){
        this.restApi = restApi;
    }

    public Observable<List<User>> loadUsers(){
        return restApi.loadUsers();
    }

    public Observable<User> loadUserById(@Path("id") String id){
        return  restApi.loadUserById(id);
    }

}
