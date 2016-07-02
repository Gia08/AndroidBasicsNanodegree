package com.example.gia.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class GameOfThronesActivity extends AppCompatActivity {

    // Definitions of ImageView variables
    ImageView imageGameOfThronesTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_of_thrones);

        imageGameOfThronesTitle = (ImageView) findViewById(R.id.imageGameOfThronesTitle);

        Picasso.with(this)
                .load("http://cdn.playbuzz.com/cdn/2e9936eb-9873-4b4c-85c9-2d83947870d0/50072e6a-b504-41b4-8715-3a70d75469ed.jpg")
                .into(imageGameOfThronesTitle);
    }


}
