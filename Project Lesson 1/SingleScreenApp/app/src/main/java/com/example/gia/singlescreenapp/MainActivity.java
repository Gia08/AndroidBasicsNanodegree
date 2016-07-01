package com.example.gia.singlescreenapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Image View for Hanabi Restaurant Logo
        ImageView hanabiLogo = (ImageView) findViewById(R.id.hanabiLogo);

        Picasso.with(this)
                .load("http://www.sushihanabi.com/images/hanabi-logo.png")
                .into(hanabiLogo);

        // Image View for Hanabi Restaurant Picture
        ImageView hanabiPicture = (ImageView) findViewById(R.id.hanabiPicture);

        Picasso.with(this)
                .load("https://media-cdn.tripadvisor.com/media/photo-s/04/c2/70/9c/hanabi-japanese-restaurant.jpg")
                .into(hanabiPicture);

        TextView linkWebsite = (TextView) findViewById(R.id.textWebsite);
        linkWebsite.setMovementMethod(LinkMovementMethod.getInstance());

    }

}
