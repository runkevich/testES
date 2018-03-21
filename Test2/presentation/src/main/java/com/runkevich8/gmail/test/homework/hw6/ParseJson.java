package com.runkevich8.gmail.test.homework.hw6;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Date;


public class ParseJson {

    private Object object;
    String fileName ;
    Root root;

    public Root parse(Context context){

        try {


            BufferedReader bufferedReader =
                    new BufferedReader(new FileReader(context.getFileStreamPath("FirstFile.json")));

            GsonBuilder builder = new GsonBuilder().
                    registerTypeAdapter(Date.class, new DateGsonConverter());

            Gson gson = builder.create();
            root = gson.fromJson(bufferedReader, Root.class);

            return root;
        } catch (Exception e) {
            System.out.println("Невозможно открыть json error = " + e.toString());
        }
        return null;
    }

}
