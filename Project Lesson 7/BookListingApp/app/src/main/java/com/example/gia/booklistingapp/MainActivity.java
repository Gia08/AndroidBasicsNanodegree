package com.example.gia.booklistingapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button btnSearch;
    EditText inputSearch;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
