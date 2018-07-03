package com.example.people4p;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.EditText;
import butterknife.BindView;

public class TaskActivity extends AppCompatActivity {
    DatabaseHelper dbHelper;
    EditText description;
    EditText dur;
//    @BindView(R.id.input_desc) EditText _desc;
//    @BindView(R.id.input_duration) EditText _duration;
//    @BindView(R.id.btn_task) EditText _add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);
        dbHelper = new DatabaseHelper(this);
        description = (EditText)findViewById(R.id.input_desc);
        dur = (EditText)findViewById(R.id.input_duration);
        Button mbutton = (Button)findViewById(R.id.btn_task);
        mbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String desc = description.getText().toString();
                int duration = Integer.parseInt(dur.getText().toString());
                dbHelper.insertTask(String.valueOf(desc), duration);
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }

        });

    }

}
