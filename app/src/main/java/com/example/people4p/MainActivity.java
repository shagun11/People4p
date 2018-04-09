package com.example.people4p;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    CalendarView calendarView;
    TextView myDate;
    SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);

        prefs = getSharedPreferences("MY_DATA", MODE_PRIVATE);

        String name = prefs.getString("MY_NAME", "no user name");
        String school = prefs.getString("MY_SCHOOL", "no school name");
        String major = prefs.getString("MY_MAJOR", "no major");
        String email = prefs.getString("MY_EMAIL", "no email");
        int phonenumber = prefs.getInt("MY_PHONE", 0);

        ((TextView)findViewById(R.id.user_name)).setText(name);
        ((TextView)findViewById(R.id.user_school)).setText(school);
        ((TextView)findViewById(R.id.user_major)).setText(major);
        ((TextView)findViewById(R.id.user_email)).setText(email);
        ((TextView)findViewById(R.id.user_phonenumber)).setText(phonenumber+"");

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);

    }

    public void editProfile(View view) {
        startActivity(new Intent(getApplicationContext(), ProfileEdit.class));
//        Intent intent = new Intent(this, ProfileEdit.class);
//        startActivity(intent);
    }

}

