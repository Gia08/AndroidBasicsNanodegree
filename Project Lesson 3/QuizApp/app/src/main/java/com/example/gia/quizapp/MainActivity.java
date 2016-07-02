package com.example.gia.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    // Definition of category's buttons
    Button btnBreakingBad;
    Button btnGameOfThrones;
    Button btnHIMYM;

    // Definition of category's images
    ImageView imageBreakingBad;
    ImageView imageGameOfThrones;
    ImageView imageHIMYM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialization of the ImageView components
        imageBreakingBad = (ImageView) findViewById(R.id.imageBreakingBad);

        Picasso.with(this)
                .load("http://artescritorio.com/wp-content/uploads/2014/08/Breaking_bad_wallpaper-800x416.jpg")
                .resize(100, 100)
                .into(imageBreakingBad);

        imageGameOfThrones = (ImageView) findViewById(R.id.imageGameOfThrones);

        Picasso.with(this)
                .load("https://psarips.com/wp-content/uploads/2015/05/GOT.jpg")
                .resize(100, 100)
                .into(imageGameOfThrones);

        imageHIMYM = (ImageView) findViewById(R.id.imageHIMYM);

        Picasso.with(this)
                .load("http://cafeycabaret.com/wp-content/uploads/2016/03/19cucharaditasdehowimetyourmother-cafeycabaret2.jpg")
                .resize(100, 100)
                .into(imageHIMYM);

        // Initialization of the buttons
        btnBreakingBad = (Button)findViewById(R.id.btnBreakingBad);
        btnGameOfThrones = (Button)findViewById(R.id.btnGameOfThrones);
        btnHIMYM = (Button)findViewById(R.id.btnHIMYM);

    }

    public void gotoBreakingBadQuiz(View v){
        Intent intent = new Intent(this, BreakingBadActivity.class);
        startActivity(intent);
    }

    public void gotoGameOfThronesQuiz(View v){
        Intent intent = new Intent(this, GameOfThronesActivity.class);
        startActivity(intent);
    }

    public void gotoHIMYMQuiz(View v){
        Intent intent = new Intent(this, HIMYMActivity.class);
        startActivity(intent);
    }
}
