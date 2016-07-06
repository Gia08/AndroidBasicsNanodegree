package com.example.gia.habittrackerapp;

import android.provider.BaseColumns;

/**
 * Created by Gia on 7/6/2016.
 */
public final class HabitContract {

    public HabitContract(){}

    public static abstract class habitContractTable implements BaseColumns {
        public static final String TABLE_NAME = "habitsTracker";
        public static final String HABIT_ID = "habitID";
        public static final String HABIT_NAME = "habitName";
        public static final String HABIT_COUNTER = "habitCounter";

        private static final String TEXT_TYPE = " TEXT NOT NULL";
        private static final String INTEGER_TYPE = " INTEGER DEFAULT 0";
        private static final String COMMA_SEP = ",";

        static final String[] HABIT_COLUMNS = {
                _ID,
                HABIT_NAME,
                HABIT_COUNTER
        };


        // Set the create sentence
        public static final String SQL_CREATE_ENTRY=
                "CREATE TABLE " + habitContractTable.TABLE_NAME + " (" +
                        habitContractTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                        habitContractTable.HABIT_ID + TEXT_TYPE + COMMA_SEP +
                        habitContractTable.HABIT_NAME + TEXT_TYPE + COMMA_SEP +
                        habitContractTable.HABIT_COUNTER +  INTEGER_TYPE + " )";

        // Set the drop table sentence
        public static final String SQL_DELETE_TABLE =
                "DROP TABLE IF EXISTS " + habitContractTable.TABLE_NAME;

    }

}
