package com.gmail.runkevich8.domain.interactor;


import com.gmail.runkevich8.domain.executor.PostExecutionThread;
import com.gmail.runkevich8.domain.executor.ThreadExecutor;

import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;

public abstract class BaseUseCase {

    //мегабазовый класс - поток в котором будем получать результаты в presentation слое
    protected Scheduler postExecuteionThread;

    //поток в котором будем выполнять все сложные запросы(другой поток , не UI)
    protected Scheduler threadExecuteion;

    public BaseUseCase(PostExecutionThread postExecuteionThread){

        this.postExecuteionThread = postExecuteionThread.getScheduler();
        this.threadExecuteion = Schedulers.io();

    }
    //2 способ
    public BaseUseCase(PostExecutionThread postExecuteionThread,ThreadExecutor threadExecuteion){

        this.postExecuteionThread = postExecuteionThread.getScheduler();
        this.threadExecuteion = Schedulers.from(threadExecuteion);

    }

}
