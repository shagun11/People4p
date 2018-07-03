package com.example.people4p;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ProfileScreen extends AppCompatActivity {
    SharedPreferences prefs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_screen);

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

    public void editProfile(View view) {
        startActivity(new Intent(getApplicationContext(), ProfileEdit.class));
//        Intent intent = new Intent(this, ProfileEdit.class);
//        startActivity(intent);
    }

    public void backToMainScreen(View view) {
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
//        Intent intent = new Intent(this, MainActivity.class);
//        startActivity(intent);
    }
}
