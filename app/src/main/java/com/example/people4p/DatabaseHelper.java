package com.example.people4p;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;


public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "P4p.db";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table user (id integer primary key autoincrement, name text, " +
                "email text, mobile text, password text)");
        db.execSQL("create table tasks (description text, id integer primary key autoincrement, " +
                "duration integer)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS user");
        db.execSQL("DROP TABLE IF EXISTS tasks");
        onCreate(db);
    }

    // inserting into database
    public boolean insert(String name, String email, String mobile, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("name", name);
        cv.put("email", email);
        cv.put("mobile", mobile);
        cv.put("password", password);
        long ins = db.insert("user", null, cv);
        if(ins == -1) return false;
        else return true;
    }

    public boolean insertTask(String description, Integer duration) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("description", description);
        cv.put("duration", duration);
        long ins = db.insert("tasks", null, cv);
        db.close();
        if(ins == -1) return false;
        else return true;
    }

    public ArrayList<Tasks> getTasks() {
        insertTask("Task1", 50);
        insertTask("Task2", 20);
        insertTask("Task3", 10);
        String[] columns = {
                "description",
                "duration"
        };
        ArrayList<Tasks> tasksList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from tasks", null);
        if(cursor.moveToFirst()) {

            do {
                String description = cursor.getString(cursor.getColumnIndex("description"));
                int duration = cursor.getInt(cursor.getColumnIndex("duration"));
                Tasks task = new Tasks(description, duration);
                tasksList.add(task);
            }while(cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return tasksList;
    }


    public void deletePersonRecord(String desc, Context context) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM tasks WHERE description='"+desc+"'");

    }

    //checking if email already exists
    public boolean checkEmail(String email) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from user where email=?", new String[]{email});
        if(cursor.getCount() > 0) return false;
        else return true;
    }

    //checking email and password
    public boolean matchEmailPass(String email, String pass) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from user where email=? and password=?", new String[]{email, pass});
        if(cursor.getCount() > 0) return true;
        else return false;
    }
}
