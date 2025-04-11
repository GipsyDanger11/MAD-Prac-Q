package com.example.a28;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class StudentDbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "student.db";
    private static final int DATABASE_VERSION = 1;

    public StudentDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_TABLE = "CREATE TABLE " + StudentContract.StudentEntry.TABLE_NAME + " (" +
                StudentContract.StudentEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                StudentContract.StudentEntry.COLUMN_NAME + " TEXT, " +
                StudentContract.StudentEntry.COLUMN_ROLL + " TEXT);";
        db.execSQL(SQL_CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
