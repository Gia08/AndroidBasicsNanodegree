package com.example.gia.habittrackerapp;

/**
 * Created by Gia on 7/6/2016.
 */
public class Habit {

    private String habitID;
    private String habitName;
    private int habitCounter;

    public Habit(){

    }

    public Habit(String habitName, int habitCounter){
        this.habitName = habitName;
        this.habitCounter = habitCounter;
    }

    public String getHabitID() {
        return habitID;
    }

    public void setHabitID(String habitID) {
        this.habitID = habitID;
    }

    public String getHabitName() {
        return habitName;
    }

    public void setHabitName(String habitName) {
        this.habitName = habitName;
    }

    public int getHabitCounter() {
        return habitCounter;
    }

    public void setHabitCounter(int habitCounter) {
        this.habitCounter = habitCounter;
    }

    @Override
    public String toString() {
        String outResult = "";
        outResult = "Habit Name = " + getHabitName() + "\n";
        outResult = "Times per day = " + getHabitCounter() + "\n";
        return outResult;
    }
}
