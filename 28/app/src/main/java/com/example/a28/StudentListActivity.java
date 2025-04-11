package com.example.a28;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class StudentListActivity extends AppCompatActivity {
    TextView studentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_list);

        studentList = findViewById(R.id.studentList);

        Cursor cursor = getContentResolver().query(
                StudentContract.StudentEntry.CONTENT_URI ,null, null, null, null
        );

        StringBuilder builder = new StringBuilder();
        if (cursor != null) {
            while (cursor.moveToNext()) {
                builder.append("ID: ").append(cursor.getInt(0))
                        .append(", Name: ").append(cursor.getString(1))
                        .append("\n");
            }
            cursor.close();
        }

        studentList.setText(builder.toString());
    }
}
