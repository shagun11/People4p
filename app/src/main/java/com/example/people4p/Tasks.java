package com.example.people4p;

/**
 * Created by shagun11 on 06/04/18.
 */

public class Tasks {
    private String description;
    private int duration;
    public Tasks(String description, int duration) {
        this.description = description;
        this.duration = duration;
    }
    public String getDescription() {
        return description;
    }


    public int getDuration() {
        return duration;
    }

}
