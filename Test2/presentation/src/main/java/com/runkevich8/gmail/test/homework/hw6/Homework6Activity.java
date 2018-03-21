package com.runkevich8.gmail.test.homework.hw6;


import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.runkevich8.gmail.test.R;

import java.util.ArrayList;
import java.util.List;

public class Homework6Activity extends AppCompatActivity{

    private Button buttonDownloadJson;
    private RecyclerView recyclerViewBus;
    private RootAdapter rootAdapter;
    private Root root ;
    private ProgressBar progressBar;
    private EditText editText;
    private List<Schedule> itemList;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hw6);

        buttonDownloadJson = findViewById(R.id.hw_6_json);
        editText = findViewById(R.id.hw6_edit_text);

        View.OnClickListener hwJsonClick = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              new DownloadWebpageTask().execute("http://kiparo.ru/t/bus_schedule.json");

            }
        };

        buttonDownloadJson.setOnClickListener(hwJsonClick);
        recyclerViewBus = findViewById(R.id.hw6_rv);

        rootAdapter = new RootAdapter();

        recyclerViewBus.setAdapter(rootAdapter);
        recyclerViewBus.setLayoutManager(new LinearLayoutManager(Homework6Activity.this));
        recyclerViewBus.setHasFixedSize(true);

        editText.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                // Когда, юзер изменяет текст он работает

            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
                                          int arg3) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

                findPrice(editable.toString());
            }
        });

    }
    private void findPrice(String name) {

        if (root != null) {
            List<Schedule> schedules = new ArrayList<>();
            for (Schedule sch : root.getSchedule()) {
                String curPrice = String.valueOf(sch.getPrice());
                if (curPrice.toLowerCase().contains(name.toLowerCase())) {
                    schedules.add(sch);
                }
            }
            rootAdapter.setItems(schedules);
        }
    }

    @SuppressLint("StaticFieldLeak")
    class DownloadWebpageTask extends AsyncTask<String, Void, Root> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
           // progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected Root doInBackground(String... strings) {

           DownloaderData downloaderData =  new DownloaderData();
           downloaderData.download(strings[0],Homework6Activity.this);


                ParseJson parseJson = new ParseJson();
                root = parseJson.parse(Homework6Activity.this);


            return root;
        }

        protected void onPostExecute(Root result) {
            super.onPostExecute(result);
            Toast.makeText(Homework6Activity.this, "Загрузка завершена", Toast.LENGTH_SHORT).show();

            if (root != null && root.getSchedule() != null)
                rootAdapter.setItems(root.getSchedule());

        }
    }
}

