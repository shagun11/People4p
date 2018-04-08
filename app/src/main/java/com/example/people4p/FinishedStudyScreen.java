package com.example.people4p;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Toast;

public class FinishedStudyScreen extends Activity {

    public android.widget.RatingBar ratingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finished_study_screen);
        // Initialize RatingBar
        ratingBar = (android.widget.RatingBar) findViewById(R.id.ratingBar);
    }

    /**
     * Display rating by calling getRating() method.
     * @param view
     */
    public void rateMe(View view){

        Toast.makeText(getApplicationContext(),
                String.valueOf(ratingBar.getRating()), Toast.LENGTH_LONG).show();
    }

}
