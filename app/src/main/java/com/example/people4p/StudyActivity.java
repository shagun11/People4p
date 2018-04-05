package com.example.people4p;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import java.util.Calendar;


import java.util.concurrent.TimeUnit;

public class StudyActivity extends AppCompatActivity {

    private TextView clockText;
    private TextView timeDoneText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study);
        clockText = (TextView) findViewById(R.id.timer);
        timeDoneText = (TextView) findViewById(R.id.timeDone);
        startTimer();
    }

    private void startTimer() {
        clockText.setText("00:00");

        CountDownTimer timer = new CountDownTimer(10 * 1000 * 60, 1000) {

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
                //@TODO Move to break
            }
        };

        timer.start();

        int hourInt = Calendar.HOUR;
        int minuteInt = Calendar.MINUTE;

        String doneAt = "Done at: " + Integer.toString(hourInt) + ":" + Integer.toString(minuteInt + 10);

        timeDoneText.setText(doneAt);


    }



}
