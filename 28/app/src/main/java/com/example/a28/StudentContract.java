package com.example.a28;

import android.net.Uri;
import android.provider.BaseColumns;

public final class StudentContract {
    private StudentContract() {}

    public static final String CONTENT_AUTHORITY = "com.example.a28.provider";
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);
    public static final String PATH_STUDENTS = "students";

    public static class StudentEntry implements BaseColumns {
        public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_CONTENT_URI, PATH_STUDENTS);
        public static final String TABLE_NAME = "students";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_ROLL = "roll";
    }
}
