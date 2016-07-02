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

public class BreakingBadActivity extends AppCompatActivity {

    // Definitions of ImageView variables
    ImageView imageBreakingBadTitle;

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
        setContentView(R.layout.activity_breaking_bad);

        imageBreakingBadTitle = (ImageView) findViewById(R.id.imageBreakingBadTitle);

        Picasso.with(this)
                .load("http://nbc.com.co/wp-content/uploads/2015/10/breaking-bad-season6-750x525.png")
                .into(imageBreakingBadTitle);

        // Initialization of the radio groups
        radioGroupQ1 = (RadioGroup) findViewById(R.id.radioGroupQ1);
        radioGroupQ2 = (RadioGroup) findViewById(R.id.radioGroupQ2);
        radioGroupQ3 = (RadioGroup) findViewById(R.id.radioGroupQ3);
        radioGroupQ4 = (RadioGroup) findViewById(R.id.radioGroupQ4);
        radioGroupQ5 = (RadioGroup) findViewById(R.id.radioGroupQ5);

        // Initialization of the radio buttons
        radioBtnQ1A1 = (RadioButton) findViewById(R.id.radioButtonBBQ1A1);
        radioBtnQ1A2 = (RadioButton) findViewById(R.id.radioButtonBBQ1A2);
        radioBtnQ1A3 = (RadioButton) findViewById(R.id.radioButtonBBQ1A3);
        radioBtnQ1A4 = (RadioButton) findViewById(R.id.radioButtonBBQ1A4);

        radioBtnQ2A1 = (RadioButton) findViewById(R.id.radioButtonBBQ2A1);
        radioBtnQ2A2 = (RadioButton) findViewById(R.id.radioButtonBBQ2A2);
        radioBtnQ2A3 = (RadioButton) findViewById(R.id.radioButtonBBQ2A3);
        radioBtnQ2A4 = (RadioButton) findViewById(R.id.radioButtonBBQ2A4);

        radioBtnQ3A1 = (RadioButton) findViewById(R.id.radioButtonBBQ3A1);
        radioBtnQ3A2 = (RadioButton) findViewById(R.id.radioButtonBBQ3A2);
        radioBtnQ3A3 = (RadioButton) findViewById(R.id.radioButtonBBQ3A3);
        radioBtnQ3A4 = (RadioButton) findViewById(R.id.radioButtonBBQ3A4);

        radioBtnQ4A1 = (RadioButton) findViewById(R.id.radioButtonBBQ4A1);
        radioBtnQ4A2 = (RadioButton) findViewById(R.id.radioButtonBBQ4A2);
        radioBtnQ4A3 = (RadioButton) findViewById(R.id.radioButtonBBQ4A3);
        radioBtnQ4A4 = (RadioButton) findViewById(R.id.radioButtonBBQ4A4);

        radioBtnQ5A1 = (RadioButton) findViewById(R.id.radioButtonBBQ5A1);
        radioBtnQ5A2 = (RadioButton) findViewById(R.id.radioButtonBBQ5A2);
        radioBtnQ5A3 = (RadioButton) findViewById(R.id.radioButtonBBQ5A3);
        radioBtnQ5A4 = (RadioButton) findViewById(R.id.radioButtonBBQ5A4);

        // Initialization of the counter variable
        counterCorrectAnswers = 0;
        submit = true;

        // Initialization of the text view
        Q1 = (TextView) findViewById(R.id.textBreakinBadQ1);
        Q2 = (TextView) findViewById(R.id.textBreakinBadQ2);
        Q3 = (TextView) findViewById(R.id.textBreakinBadQ3);
        Q4 = (TextView) findViewById(R.id.textBreakinBadQ4);
        Q5 = (TextView) findViewById(R.id.textBreakinBadQ5);

        // Initialization of the submit button
        btnSubmit = (Button) findViewById(R.id.buttonSubmitBB);

        // Initialization of results text view
        textResults = (TextView) findViewById(R.id.textResultsBB);
    }

    public void submitAnswerBB(View v){
        if (!submit){
            Q1.setTextColor(Color.BLACK);
            Q2.setTextColor(Color.BLACK);
            Q3.setTextColor(Color.BLACK);
            Q4.setTextColor(Color.BLACK);
            Q5.setTextColor(Color.BLACK);
            btnSubmit.setText("Submit Answers");
            submit = true;
        }
        else{
            int selectedId = radioGroupQ1.getCheckedRadioButtonId();
            if (selectedId == radioBtnQ1A3.getId()){
                counterCorrectAnswers++;
            }
            else{
                Q1.setTextColor(Color.RED);
            }

            selectedId = radioGroupQ2.getCheckedRadioButtonId();
            if (selectedId == radioBtnQ2A4.getId()){
                counterCorrectAnswers++;
            }
            else{
                Q2.setTextColor(Color.RED);
            }

            selectedId = radioGroupQ3.getCheckedRadioButtonId();
            if (selectedId == radioBtnQ3A2.getId()){
                counterCorrectAnswers++;
            }
            else{
                Q3.setTextColor(Color.RED);
            }

            selectedId = radioGroupQ4.getCheckedRadioButtonId();
            if (selectedId == radioBtnQ4A3.getId()){
                counterCorrectAnswers++;
            }
            else{
                Q4.setTextColor(Color.RED);
            }

            selectedId = radioGroupQ5.getCheckedRadioButtonId();
            if (selectedId == radioBtnQ5A1.getId()){
                counterCorrectAnswers++;
            }
            else{
                Q5.setTextColor(Color.RED);
            }
            textResults.setText("Results: "+ counterCorrectAnswers+ " of 5.");
            btnSubmit.setText("Retry");
            submit = false;
        }



    }
}
