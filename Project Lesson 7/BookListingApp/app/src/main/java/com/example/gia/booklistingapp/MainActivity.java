package com.example.gia.booklistingapp;

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

    public void searchBooks(View v){
        String input = inputSearch.getText().toString().replace(" ", "+");
        String url = "https://www.googleapis.com/books/v1/volumes?q=" + input;
        Intent myIntent = new Intent(this, ListBooks.class);
        myIntent.putExtra("url",url);
        startActivity(myIntent);
    }
}
