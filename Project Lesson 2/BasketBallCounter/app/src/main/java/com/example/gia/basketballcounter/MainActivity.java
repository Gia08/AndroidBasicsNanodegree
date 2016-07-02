package com.example.gia.basketballcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Definition of buttons for Team A
    Button btnScoreA_plusone;
    Button btnScoreA_plustwo;
    Button btnScoreA_plusthree;

    // Definition of buttons for Team B
    Button btnScoreB_plusone;
    Button btnScoreB_plustwo;
    Button btnScoreB_plusthree;

    // Definition for reset button
    Button btnReset;

    // Global Variables for score counters
    int counterA;
    int counterB;

    // Definition of text view to display the score counters
    TextView textCounterA;
    TextView textCounterB;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialization of components for Team A

        btnScoreA_plusone = (Button)findViewById(R.id.btnScoreA_plusone);
        btnScoreA_plustwo = (Button)findViewById(R.id.btnScoreA_plustwo);
        btnScoreA_plusthree = (Button)findViewById(R.id.btnScoreA_plusthree);

        counterA =0;

        textCounterA = (TextView) findViewById(R.id.textScoreA);

        // Initialization of components for Team A

        btnScoreB_plusone = (Button)findViewById(R.id.btnScoreB_plusone);
        btnScoreB_plustwo = (Button)findViewById(R.id.btnScoreB_plustwo);
        btnScoreB_plusthree = (Button)findViewById(R.id.btnScoreB_plusthree);

        counterB =0;

        textCounterB = (TextView) findViewById(R.id.textScoreB);

        // Initialization for Reset button
        btnReset = (Button)findViewById(R.id.buttonReset);


    }

    public void ScoreA_plusone(View v){
        counterA = counterA + 1;
        textCounterA.setText(counterA + "");
    }

    public void ScoreA_plustwo(View v){
        counterA = counterA + 2;
        textCounterA.setText(counterA + "");
    }

    public void ScoreA_plusthree(View v){
        counterA = counterA + 3;
        textCounterA.setText(counterA + "");
    }

    public void ScoreB_plusone(View v){
        counterB = counterB + 1;
        textCounterB.setText(counterB + "");
    }

    public void ScoreB_plustwo(View v){
        counterB = counterB + 2;
        textCounterB.setText(counterB + "");
    }

    public void ScoreB_plusthree(View v){
        counterB = counterB + 3;
        textCounterB.setText(counterB + "");
    }

    public void reset(View v){
        counterA = 0;
        counterB = 0;
        textCounterA.setText(counterB + "");
        textCounterB.setText(counterB + "");
    }

}
