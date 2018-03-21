package com.runkevich8.gmail.test.homework.hw6;

import android.content.Context;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class DownloaderData {

        public  void download(String urlAdress,Context context) {

            try {
                URL url = new URL(urlAdress);

                HttpURLConnection connection = (HttpURLConnection) url.openConnection();

                int responseCode = connection.getResponseCode();
                if (responseCode == HttpURLConnection.HTTP_OK) {
                    File file = new File(context.getFilesDir(),"FirstFile.json");

                    try (InputStream streamIn = connection.getInputStream();
                         FileOutputStream streamOut = new FileOutputStream(file)) {

                        byte[] buffer = new byte[2048];
                        int read;
                        while ((read = streamIn.read(buffer)) != -1) {
                            streamOut.write(buffer, 0, read);
                        }
                    }
                } else {
                    return;
                }
            } catch (IOException e) {
                e.getMessage();
                return;
            }
        }
}

