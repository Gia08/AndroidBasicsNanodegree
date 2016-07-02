package com.example.gia.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class BreakingBadActivity extends AppCompatActivity {

    // Definitions of ImageView variables
    ImageView imageBreakingBadTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breaking_bad);

        imageBreakingBadTitle = (ImageView) findViewById(R.id.imageBreakingBadTitle);

        Picasso.with(this)
                .load("http://nbc.com.co/wp-content/uploads/2015/10/breaking-bad-season6-750x525.png")
                .into(imageBreakingBadTitle);
    }
}
