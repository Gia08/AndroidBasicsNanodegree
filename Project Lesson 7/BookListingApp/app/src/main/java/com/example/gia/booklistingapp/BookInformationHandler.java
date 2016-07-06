package com.example.gia.booklistingapp;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class BookInformationHandler {
    static String stream = null;

    public String getStreamData(String URLString){
        try {
            URL url = new URL(URLString);
            HttpURLConnection URLConnection = (HttpURLConnection) url.openConnection();

            // Set TTL to do the Http URL Connection
            if(URLConnection.getResponseCode()==200) {
                InputStream inputStream = new BufferedInputStream(URLConnection.getInputStream());

                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder inputData = new StringBuilder();

                // Get the information in the bufferedReader and save it in a String Builder
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    inputData.append(line);
                }
                stream = inputData.toString();
                URLConnection.disconnect();
            }
        }
        catch (MalformedURLException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }finally{

        }
        return stream;
    }
}
