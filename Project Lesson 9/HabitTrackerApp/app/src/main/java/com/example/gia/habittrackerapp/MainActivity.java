package com.example.gia.habittrackerapp;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Test if database logistic is working
        HabitDataHelper habitDataHelper = new HabitDataHelper(this);

        // Create the habit tracker database
        Log.v("TEST",HabitContract.habitContractTable.SQL_CREATE_ENTRY);

        // Add three entries to the database

        Habit habitDrinkALitreWater = new Habit("Drink a litre of water per day", 1);
        Habit habitRunning = new Habit("Running 20 minutes per day", 1);
        Habit habitEat = new Habit("Eat 3 times per day", 3);

        habitDataHelper.addNewHabit(habitDrinkALitreWater);
        habitDataHelper.addNewHabit(habitRunning);
        habitDataHelper.addNewHabit(habitEat);

        // Show the habits that I saved in the database.

        Habit resultHabit = new Habit();

        Cursor cursor = habitDataHelper.getHabitInformation("Drink a litre of water per day");

        // This logs are here for testing purpose
        Log.v("TEST", "Habit ID 1");
        resultHabit.setHabitName(cursor.getString(1));
        resultHabit.setHabitCounter(cursor.getInt(2));
        Log.v("TEST", "Habit Name = " + resultHabit.getHabitName());
        Log.v("TEST", "Habit Times per Day = " + cursor.getString(2));

        cursor = habitDataHelper.getHabitInformation("Running 20 minutes per day");

        // This logs are here for testing purpose
        Log.v("TEST", "Habit ID 2");
        Log.v("TEST", "Habit Name = " + cursor.getString(1));
        Log.v("TEST", "Habit Times per Day = " + cursor.getString(2));

        cursor = habitDataHelper.getHabitInformation("Eat 3 times per day");

        // This logs are here for testing purpose
        Log.v("TEST", "Habit ID 3");
        Log.v("TEST", "Habit Name = " + cursor.getString(1));
        Log.v("TEST", "Habit Times per Day = " + cursor.getString(2));

        // Increment Habit Drink a litre of water per day counter
        habitDataHelper.incrementHabitCounter("Drink a litre of water per day");

        cursor = habitDataHelper.getHabitInformation("Drink a litre of water per day");

        // This logs are here for testing purpose
        Log.v("TEST", "Habit ID 1");
        Log.v("TEST", "Habit Name = " + cursor.getString(1));
        Log.v("TEST", "Habit Times per Day = " + cursor.getString(2));


        // Remove all entries
        habitDataHelper.deleteAllEntries();

    }
}
