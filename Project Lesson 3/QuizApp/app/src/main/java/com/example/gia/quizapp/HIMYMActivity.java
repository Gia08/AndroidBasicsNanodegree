package com.example.gia.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class HIMYMActivity extends AppCompatActivity {

    // Definitions of ImageView variables
    ImageView imageHIMYMTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_himym);

        imageHIMYMTitle = (ImageView) findViewById(R.id.imageHIMYMTitle);

        Picasso.with(this)
                .load("http://www.gloo.udp.cl/wp-content/uploads/how-i-met-your-mother-banner.png")
                .into(imageHIMYMTitle);
    }
}
