package com.example.gia.quizapp;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class GameOfThronesActivity extends AppCompatActivity {

    // Definitions of ImageView variables
    ImageView imageGameOfThronesTitle;

    // Definition for Radios Groups
    RadioGroup radioGroupQ1;
    RadioGroup radioGroupQ2;
    RadioGroup radioGroupQ3;
    RadioGroup radioGroupQ4;
    RadioGroup radioGroupQ5;


    // Definition of radio buttons
    RadioButton radioBtnQ1A1;
    RadioButton radioBtnQ1A2;
    RadioButton radioBtnQ1A3;
    RadioButton radioBtnQ1A4;

    RadioButton radioBtnQ2A1;
    RadioButton radioBtnQ2A2;
    RadioButton radioBtnQ2A3;
    RadioButton radioBtnQ2A4;

    RadioButton radioBtnQ3A1;
    RadioButton radioBtnQ3A2;
    RadioButton radioBtnQ3A3;
    RadioButton radioBtnQ3A4;

    RadioButton radioBtnQ4A1;
    RadioButton radioBtnQ4A2;
    RadioButton radioBtnQ4A3;
    RadioButton radioBtnQ4A4;

    RadioButton radioBtnQ5A1;
    RadioButton radioBtnQ5A2;
    RadioButton radioBtnQ5A3;
    RadioButton radioBtnQ5A4;

    // Definition for the Submit Button
    Button btnSubmit;

    // Definition for the counter variable
    int counterCorrectAnswers;
    boolean submit;

    // Definition of the Questions text views
    TextView Q1;
    TextView Q2;
    TextView Q3;
    TextView Q4;
    TextView Q5;

    // Definition of the text results
    TextView textResults;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_of_thrones);

        imageGameOfThronesTitle = (ImageView) findViewById(R.id.imageGameOfThronesTitle);

        Picasso.with(this)
                .load("http://cdn.playbuzz.com/cdn/2e9936eb-9873-4b4c-85c9-2d83947870d0/50072e6a-b504-41b4-8715-3a70d75469ed.jpg")
                .into(imageGameOfThronesTitle);

        // Initialization of the radio groups
        radioGroupQ1 = (RadioGroup) findViewById(R.id.radioGroupGTQ1);
        radioGroupQ2 = (RadioGroup) findViewById(R.id.radioGroupGTQ2);
        radioGroupQ3 = (RadioGroup) findViewById(R.id.radioGroupGTQ3);
        radioGroupQ4 = (RadioGroup) findViewById(R.id.radioGroupGTQ4);
        radioGroupQ5 = (RadioGroup) findViewById(R.id.radioGroupGTQ5);

        // Initialization of the radio buttons
        radioBtnQ1A1 = (RadioButton) findViewById(R.id.radioButtonGTQ1A1);
        radioBtnQ1A2 = (RadioButton) findViewById(R.id.radioButtonGTQ1A2);
        radioBtnQ1A3 = (RadioButton) findViewById(R.id.radioButtonGTQ1A3);
        radioBtnQ1A4 = (RadioButton) findViewById(R.id.radioButtonGTQ1A4);

        radioBtnQ2A1 = (RadioButton) findViewById(R.id.radioButtonGTQ2A1);
        radioBtnQ2A2 = (RadioButton) findViewById(R.id.radioButtonGTQ2A2);
        radioBtnQ2A3 = (RadioButton) findViewById(R.id.radioButtonGTQ2A3);
        radioBtnQ2A4 = (RadioButton) findViewById(R.id.radioButtonGTQ2A4);

        radioBtnQ3A1 = (RadioButton) findViewById(R.id.radioButtonGTQ3A1);
        radioBtnQ3A2 = (RadioButton) findViewById(R.id.radioButtonGTQ3A2);
        radioBtnQ3A3 = (RadioButton) findViewById(R.id.radioButtonGTQ3A3);
        radioBtnQ3A4 = (RadioButton) findViewById(R.id.radioButtonGTQ3A4);

        radioBtnQ4A1 = (RadioButton) findViewById(R.id.radioButtonGTQ4A1);
        radioBtnQ4A2 = (RadioButton) findViewById(R.id.radioButtonGTQ4A2);
        radioBtnQ4A3 = (RadioButton) findViewById(R.id.radioButtonGTQ4A3);
        radioBtnQ4A4 = (RadioButton) findViewById(R.id.radioButtonGTQ4A4);

        radioBtnQ5A1 = (RadioButton) findViewById(R.id.radioButtonGTQ5A1);
        radioBtnQ5A2 = (RadioButton) findViewById(R.id.radioButtonGTQ5A2);
        radioBtnQ5A3 = (RadioButton) findViewById(R.id.radioButtonGTQ5A3);
        radioBtnQ5A4 = (RadioButton) findViewById(R.id.radioButtonGTQ5A4);

        // Initialization of the counter variable
        counterCorrectAnswers = 0;
        submit = true;

        // Initialization of the text view
        Q1 = (TextView) findViewById(R.id.textGameOfThronesQ1);
        Q2 = (TextView) findViewById(R.id.textGameOfThronesQ2);
        Q3 = (TextView) findViewById(R.id.textGameOfThronesQ3);
        Q4 = (TextView) findViewById(R.id.textGameOfThronesQ4);
        Q5 = (TextView) findViewById(R.id.textGameOfThronesQ5);

        // Initialization of the submit button
        btnSubmit = (Button) findViewById(R.id.buttonSubmitGT);

        // Initialization of results text view
        textResults = (TextView) findViewById(R.id.textResultsGT);
    }

    public void submitAnswerGT(View v) {
        if (!submit) {
            Q1.setTextColor(Color.BLACK);
            Q2.setTextColor(Color.BLACK);
            Q3.setTextColor(Color.BLACK);
            Q4.setTextColor(Color.BLACK);
            Q5.setTextColor(Color.BLACK);
            btnSubmit.setText("Submit Answers");
            textResults.setText("");
            counterCorrectAnswers = 0;
            submit = true;
        } else {
            int selectedId = radioGroupQ1.getCheckedRadioButtonId();
            if (selectedId == radioBtnQ1A4.getId()) {
                counterCorrectAnswers++;
                Q1.setTextColor(Color.GREEN);
            } else {
                Q1.setTextColor(Color.RED);
            }

            selectedId = radioGroupQ2.getCheckedRadioButtonId();
            if (selectedId == radioBtnQ2A3.getId()) {
                counterCorrectAnswers++;
                Q2.setTextColor(Color.GREEN);
            } else {
                Q2.setTextColor(Color.RED);
            }

            selectedId = radioGroupQ3.getCheckedRadioButtonId();
            if (selectedId == radioBtnQ3A4.getId()) {
                counterCorrectAnswers++;
                Q3.setTextColor(Color.GREEN);
            } else {
                Q3.setTextColor(Color.RED);
            }

            selectedId = radioGroupQ4.getCheckedRadioButtonId();
            if (selectedId == radioBtnQ4A1.getId()) {
                counterCorrectAnswers++;
                Q4.setTextColor(Color.GREEN);
            } else {
                Q4.setTextColor(Color.RED);
            }

            selectedId = radioGroupQ5.getCheckedRadioButtonId();
            if (selectedId == radioBtnQ5A2.getId()) {
                counterCorrectAnswers++;
                Q5.setTextColor(Color.GREEN);
            } else {
                Q5.setTextColor(Color.RED);
            }
            textResults.setText("Results: " + counterCorrectAnswers + " of 5.");
            btnSubmit.setText("Retry");
            submit = false;
        }
    }
}
