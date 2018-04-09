package com.example.people4p;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;

public class ProfileEdit extends AppCompatActivity {

    private EditText nameInput;
    private EditText schoolInput;
    private EditText majorInput;
    private EditText emailInput;
    private EditText phonenumberInput;
    private SharedPreferences prefs;
//    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_edit);

        prefs = getSharedPreferences("MY_DATA", MODE_PRIVATE);
        String name = prefs.getString("MY_NAME", "");
        String school = prefs.getString("MY_SCHOOL", "");
        String major = prefs.getString("MY_MAJOR", "");
        String email = prefs.getString("MY_EMAIL", "");
        int phonenumber = prefs.getInt("MY_PHONE", 0);


//        button = (Button)findViewById(R.id.saveButton);
        nameInput = (EditText)findViewById(R.id.input_name);
        schoolInput = (EditText)findViewById(R.id.input_school);
        majorInput = (EditText)findViewById(R.id.input_major);
        emailInput = (EditText)findViewById(R.id.input_email);
        phonenumberInput = (EditText)findViewById(R.id.input_phone);
//
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String name = nameInput.getText().toString();
//                String school = schoolInput.getText().toString();
//                String major = majorInput.getText().toString();
//                String email = emailInput.getText().toString();
//                int phonenumber = Integer.parseInt(phonenumberInput.getText().toString());
//            }
//        });
        nameInput.setText(name);
        schoolInput.setText(school);
        majorInput.setText(major);
        emailInput.setText(email);
        phonenumberInput.setText(phonenumber+"");
    }

    public void saveProfile(View view) {
        String name = nameInput.getText().toString();
        String school = schoolInput.getText().toString();
        String major = majorInput.getText().toString();
        String email = emailInput.getText().toString();
        int phonenumber = Integer.parseInt(phonenumberInput.getText().toString());

        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("MY_NAME", name);
        editor.putString("MY_SCHOOL", school);
        editor.putString("MY_MAJOR", major);
        editor.putString("MY_EMAIL", email);
        editor.putInt("MY_PHONE", phonenumber);
        editor.apply();

        startActivity(new Intent(getApplicationContext(), MainActivity.class));

    }
}
