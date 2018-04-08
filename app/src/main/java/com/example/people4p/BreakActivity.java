package com.example.people4p;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BreakActivity extends AppCompatActivity {

    //a list to store all the products
    List<BreakItem> productList;

    //the recyclerview
    RecyclerView recyclerView;

    //Clock text for countdown
    TextView clockText;

    //text for done time on break
    TextView doneText;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_break);
        clockText = (TextView) findViewById(R.id.timeLeftText);
        doneText = (TextView) findViewById(R.id.textDoneBreak);
        MakeRecylerStuff();
        startTimer();
        Button EndBreakButton = (Button) findViewById(R.id.EndBreakButton);
        EndBreakButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                goToStudy();
            }
        });
    }

    public void MakeRecylerStuff() {

        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //initializing the productlist
        productList = new ArrayList<>();


        //adding some items to our list
        productList.add(
                new BreakItem(
                        "Inspirational Quote: ",
                        "A dream doesn't become reality through magic; it takes sweat, determination and hard work."
                ));

        productList.add(
                new BreakItem(
                        "Resource: ",
                        "Kenneth Keller Hall offers many facilities to use Linux machines."
                ));

        productList.add(
                new BreakItem(
                        "Need a stress reliever? : ",
                        "https://www.youtube.com/watch?v=XyNlqQId-nk \n"
                ));


        //creating recyclerview adapter
        ProductAdapter adapter = new ProductAdapter(this, productList);

        //setting adapter to recyclerview
        recyclerView.setAdapter(adapter);

    }

    private void startTimer() {
        clockText.setText("00:00");

        CountDownTimer timer = new CountDownTimer( 1000 * 60, 1000) {

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

        doneText.setText(doneAt);


    }

    public void goToStudy() {
        Intent intent = new Intent(this, StudyActivity.class);
        startActivity(intent);
    }

}
