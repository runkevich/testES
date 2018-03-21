package com.gmail.runkevich8.domain.interactor;


import com.gmail.runkevich8.domain.entity.UserEntity;
import com.gmail.runkevich8.domain.executor.PostExecutionThread;
import com.gmail.runkevich8.domain.repository.UserRepository;

import javax.inject.Inject;

import io.reactivex.Observable;

public class GetUserByIdUseCase extends BaseUseCase{

    private UserRepository userRepository;

    @Inject
    public GetUserByIdUseCase(PostExecutionThread postExecuteionThread,
                              UserRepository userRepository) {
        super(postExecuteionThread);
        this.userRepository = userRepository;
    }

    //в usecase один публичный метод, если два ,то уже неправильно

    public Observable<UserEntity> get (String id){

                //эти метода решают кто в каком потоке будет запускаться
               return  userRepository
                       .get(id)
                .subscribeOn(threadExecuteion)           //в каком потоке выполнится
                .observeOn(postExecuteionThread) ;       // observeOn ---- в каком потоке получить результат

    }
}
