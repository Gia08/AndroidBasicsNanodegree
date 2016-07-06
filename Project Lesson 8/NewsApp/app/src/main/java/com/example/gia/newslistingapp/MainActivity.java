package com.example.gia.newslistingapp;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnSearch;
    EditText inputSearch;
    String apiKey = "7aa03edc-b8e0-42e2-b48b-f575588b3caf";

    // Check if the user has internet connection
    public boolean isOnline() {
        ConnectivityManager conMgr = (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = conMgr.getActiveNetworkInfo();

        if(netInfo == null || !netInfo.isConnected() || !netInfo.isAvailable()){
            Toast.makeText(MainActivity.this, "No Internet connection!", Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        isOnline();

        btnSearch = (Button) findViewById(R.id.btnSearch);
        inputSearch = (EditText) findViewById(R.id.editInputSearch);

    }


    public void searchNews(View v){
        String input = inputSearch.getText().toString().replace(" ", "+");
        String pageSize = "&page-size=10";
        String url = "https://content.guardianapis.com/search?api-key=" + apiKey;
        url = url + "&show-fields=thumbnail" + pageSize;
        url = url + "&q=" + input;
        Intent myIntent = new Intent(this, ListNews.class);
        myIntent.putExtra("url",url);
        startActivity(myIntent);
    }
}
