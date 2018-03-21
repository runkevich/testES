package com.runkevich8.gmail.test.classwork.classwork6;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.runkevich8.gmail.test.R;

import java.util.ArrayList;
import java.util.List;

public class Classwork6Activity extends AppCompatActivity{

    private RecyclerView recyclerView;
    private UserAdapter userAdapter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classwork6);

        List<User> userList = new ArrayList<>();
        userList.add(new User("sova_anmation_1.png","User 1","Surname1"));
        userList.add(new User("sova_anmation_1.png","User 2","Surname2"));
        userList.add(new User("sova_anmation_1.png","User 3","Surname3"));
        userList.add(new User("sova_anmation_1.png","User 4","Surname4"));
        userList.add(new User("sova_anmation_1.png","User 5","Surname5"));

        userAdapter = new UserAdapter();
        userAdapter.setItems(userList);
        userAdapter.setListener(new UserAdapter.OnUserClickListener() {
            @Override
            public void onClick(User user, int position) {
                Toast.makeText(Classwork6Activity.this,user.getName()+position,
                        Toast.LENGTH_SHORT).show();
            }
        });

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setAdapter(userAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        //recyclerView.setLayoutManager(new StaggeredGridLayoutManager());
        recyclerView.setHasFixedSize(true);

       // recyclerView.addItemDecoration(); - метод для определния паддингов вокруг элментов

        //RxJava, RxAndroid, RxView, AsyncTask

        // recyclerView.setHasFixedSize(true) - если высота  view(item) всегда одинакова,
        // то используется для оптимизации , быстрее работает recyclerView
    }
}
