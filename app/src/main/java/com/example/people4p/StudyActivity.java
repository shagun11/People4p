package com.example.people4p;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.Calendar;
import android.content.Intent;
import java.util.Date;
import java.sql.Time;


import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;

public class StudyActivity extends AppCompatActivity {

    private TextView clockText;
    private TextView timeDoneText;
    private Button goToBreakButton;
    private CountDownTimer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study);
        clockText = (TextView) findViewById(R.id.timer);
        timeDoneText = (TextView) findViewById(R.id.timeDone);
        goToBreakButton = (Button) findViewById(R.id.goToBreakButton);
        goToBreakButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                goToBreak();
            }
        });
        startTimer();
    }

    private void startTimer() {
        clockText.setText("00:00");

        timer = new CountDownTimer( 1000 * 60, 1000) {

            @Override
            public void onTick(long millisUntilFinished) {
                Long placeholder = millisUntilFinished;
                Long minutesLong = TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished);
                placeholder -= TimeUnit.MINUTES.toMillis(minutesLong);
                Long secondsLong = TimeUnit.MILLISECONDS.toSeconds(placeholder);

                String Seconds = "";
                String Minutes = "";

                if (secondsLong < 10) {
                    Seconds = "0" + Long.toString(secondsLong);
                } else {
                    Seconds = Long.toString(secondsLong);
                }

                if (minutesLong < 10) {
                    Minutes = "0" + Long.toString(minutesLong);
                } else {
                    Minutes = Long.toString(minutesLong);
                }

                clockText.setText(Minutes + ":" + Seconds);
            }

            @Override
            public void onFinish() {
                clockText.setText("Done!");
            }
        };

        timer.start();

        Date date = new Date();   // given date
        Calendar calendar = GregorianCalendar.getInstance();

        int hourInt = calendar.get(Calendar.HOUR);
        int minuteInt = calendar.get(Calendar.MINUTE);

        String doneAt = "Done at: " + Integer.toString(hourInt) + ":" + Integer.toString(minuteInt + 1);

        timeDoneText.setText(doneAt);


    }

    public void goToBreak() {
        Intent intent = new Intent(this, BreakActivity.class);
        startActivity(intent);
    }



    @Override
    protected void onResume(){
        super.onResume();
        timer.start();
    }
}
