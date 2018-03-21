package com.runkevich8.gmail.test.homework.hw8;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.runkevich8.gmail.test.R;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;

public class OneFragmentHw8 extends Fragment {

    public TextView textView;
    public Observable observable;
    private Disposable disposable;
    private PublishContract publishContract;
    private static final String PARAM_1 = "param1";
    private static final String PARAM_2 = "param2";

    private String mParam1;
    private String mParam2;


    public static OneFragmentHw8 getInstance(String param1, String param2){
        OneFragmentHw8 fragment = new OneFragmentHw8();
        Bundle args = new Bundle();

        args.putString(PARAM_1, param1);
        args.putString(PARAM_2, param2);

        fragment.setArguments(args);
        return fragment;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return getLayoutInflater().inflate(R.layout.fragment_one_hw8,container,false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view,savedInstanceState);
        textView = view.findViewById(R.id.textView_hw8);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
        subscribe();
    }

    private void subscribe(){
        disposable = publishContract
                .getObservable()

                .doOnNext(new Consumer<Long>() {
                    @Override
                    public void accept(Long integer) throws Exception {
                        // нужен для промежуточных действий,не выполняется если ошибка ыходит

                    }
                })
                .filter(new Predicate<Long>() {
                    @Override
                    public boolean test(Long integer) throws Exception {
                        return integer%2==0;
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                //трансформация данных из Int в String
                .map(new Function<Long, String>() {
                    @Override
                    public String apply(Long integer) throws Exception {
                        return String.valueOf(integer);
                    }
                })

                .doOnNext(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {

                    }
                })

                 // .take(8) //можно поставить счетчик по которому завршить подписку
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        textView.setText(s);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        // произойдет ,если все плохо
                        // ,сюда прилетают ошибки
                    }
                });
    }


    @Override
    public void onPause() {
        super.onPause();
             if (disposable != null){
            disposable.dispose(); // метод для отписки
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Activity activity = getActivity();
        if (activity!=null){
            publishContract = (PublishContract) activity;
        }

    }

    @Override
    public void onDetach() {
        super.onDetach();
        publishContract = null;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(PARAM_1);
            mParam2 = getArguments().getString(PARAM_2);
        }
    }

}