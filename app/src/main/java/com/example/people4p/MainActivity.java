package com.example.people4p;

import android.content.Intent;
import android.view.View;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.LinearLayoutManager;
import android.view.Menu;
import android.view.MenuItem;
import java.util.ArrayList;
import java.util.List;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    DatabaseHelper dbHelper;
    List<Tasks> taskList;
    private Toolbar mTopToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dbHelper = new DatabaseHelper(this);
        setContentView(R.layout.activity_main);

        mTopToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(mTopToolbar);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        // use a linear layout manager
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //initializing the productlist
        taskList = new ArrayList<>();
        taskList = dbHelper.getTasks();

        //creating recyclerview adapter
        final TaskAdapter adapter = new TaskAdapter(this, taskList);
        adapter.setOnItemClickListener(new TaskAdapter.OnItemClickListener() {
            @Override
            public void onDeleteClick(int position) {
                taskList.remove(position);
                adapter.notifyItemRemoved(position);
            }
        });

        //setting adapter to recyclerview
        recyclerView.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_nav, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        Intent intent = null;

        //noinspection SimplifiableIfStatement
        if (id == R.id.nav_study) {
            Toast.makeText(MainActivity.this, "Study Action clicked", Toast.LENGTH_LONG).show();
            intent = new Intent(this, StudyActivity.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.nav_profile){
            Toast.makeText(MainActivity.this, "Profile Screen clicked", Toast.LENGTH_LONG).show();
            intent = new Intent(this, ProfileScreen.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.nav_cal) {
            Toast.makeText(MainActivity.this, "Calendar Action clicked", Toast.LENGTH_LONG).show();
            intent = new Intent(this, calendarActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void activityTask(View view) {
        Intent intent = new Intent(MainActivity.this, TaskActivity.class);
        startActivity(intent);
    }
}


