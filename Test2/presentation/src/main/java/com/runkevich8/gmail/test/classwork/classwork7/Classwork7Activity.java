package com.runkevich8.gmail.test.classwork.classwork7;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.runkevich8.gmail.test.R;

public class Classwork7Activity extends AppCompatActivity {

    private boolean isOneVisible = true;
    int valueF = 0;
    private static final String SHARED_PREF_NAME = "Данные из SharedPreferences";
    private static final String KEY_NAME = "name";
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classwork7);


         sharedPreferences = getSharedPreferences("",
                Context.MODE_PRIVATE);
        sharedPreferences.edit().putString(KEY_NAME, "Hello").apply();


        //Варианты хранения данных на телефоне
        //1)getFilesDir(); - в файлике
        //  getCacheDir();
        // 2)в интернете
        // 3)SharedPreference

        //________________________________________________________________

        findViewById(R.id.buttonFrgment).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeFragment();
            }
        });

        if (savedInstanceState == null){
            showFragment(OneFragment.getInstance(),false);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        String text = sharedPreferences.getString(KEY_NAME,"");
        Log.e("AAAAA","text = "+text);
    }

    @Override
    protected void onPause() {
        super.onPause();
        sharedPreferences.edit().putString(KEY_NAME,"HELLO").apply();
    }

    private void changeFragment(){

        if(isOneVisible){
            showFragment(TwoFragment.getInstance(getSupportFragmentManager(),valueF),true);
            isOneVisible = false;
        }else {
            showFragment(OneFragment.getInstance(),true);
            isOneVisible = true;
        }

    }

    private void showFragment(Fragment fragment,boolean addBackStack){

        FragmentManager fragmentManager = getSupportFragmentManager();

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction(); //если не срабатывает одна из операций,
                                                                                        // то ломается и отменяется вся система
        fragmentTransaction.replace(R.id.containerFragment,fragment,fragment.getClass().getSimpleName());

       if (addBackStack) fragmentTransaction.addToBackStack(fragment.getClass().getSimpleName());

        fragmentTransaction.commit();
    }
}
