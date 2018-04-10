package com.example.people4p;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FinishedStudyScreen extends Activity {

    public android.widget.RatingBar ratingBar;
    private Button FinishButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finished_study_screen);
        // Initialize RatingBar
        ratingBar = (android.widget.RatingBar) findViewById(R.id.ratingBar);
        FinishButton = (Button) findViewById(R.id.submit);
        FinishButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                submitPage();
            }
        });
    }

    /**
     * Display rating by calling getRating() method.
     * @param view
     */
    public void rateMe(View view){

        Toast.makeText(getApplicationContext(),
                String.valueOf(ratingBar.getRating()), Toast.LENGTH_LONG).show();
    }

    public void submitPage() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}
