package com.example.people4p;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class calendarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
    }


    public void getBack(View view) {
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
    }

//    public void changeScreen(View view) {
//        startActivity(new Intent(getApplicationContext(), AddEventActivity.class));
//    }
}
