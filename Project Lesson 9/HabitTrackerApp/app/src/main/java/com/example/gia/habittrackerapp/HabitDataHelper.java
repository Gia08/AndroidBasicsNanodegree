package com.example.gia.habittrackerapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Gia on 7/6/2016.
 */
public class HabitDataHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "habitsTracker.db";

    public HabitDataHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(HabitContract.habitContractTable.SQL_CREATE_ENTRY);
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(HabitContract.habitContractTable.SQL_DELETE_TABLE);
        onCreate(db);
    }
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

    // Add New Habit to the Habits Trackers database
    void addNewHabit(Habit habit) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(HabitContract.habitContractTable.HABIT_NAME, habit.getHabitName());
        values.put(HabitContract.habitContractTable.HABIT_COUNTER, habit.getHabitCounter());
        db.insert(HabitContract.habitContractTable.TABLE_NAME, null, values);
        db.close();
    }

    // Get Habit Information
    public Cursor getHabitInformation(String habitName) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(
                HabitContract.habitContractTable.TABLE_NAME,
                HabitContract.habitContractTable.HABIT_COLUMNS,
                HabitContract.habitContractTable.HABIT_NAME + " = ?",
                new String[]{habitName}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();
        return cursor;
    }

    // Increment Habit Counter
    public void incrementHabitCounter(String habitName) {
        Cursor cursor = getHabitInformation(habitName);
        Habit habit = new Habit(cursor.getString(1), cursor.getInt(2));
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(HabitContract.habitContractTable.HABIT_NAME, habit.getHabitName());
        values.put(HabitContract.habitContractTable.HABIT_COUNTER, habit.getHabitCounter() + 1);
        db.update(HabitContract.habitContractTable.TABLE_NAME, values, HabitContract.habitContractTable.HABIT_NAME + " = '" + habitName + "'", null);
    }

}
