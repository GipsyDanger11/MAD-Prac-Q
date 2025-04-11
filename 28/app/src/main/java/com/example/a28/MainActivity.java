package com.example.a28;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText nameInput, rollInput;
    TextView display;
    Button insertBtn, showBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameInput = findViewById(R.id.nameInput);
        rollInput = findViewById(R.id.rollInput);
        display = findViewById(R.id.display);
        insertBtn = findViewById(R.id.insertBtn);
        showBtn = findViewById(R.id.showBtn);

        insertBtn.setOnClickListener(v -> {
            String name = nameInput.getText().toString().trim();
            String roll = rollInput.getText().toString().trim();

            if (name.isEmpty() || roll.isEmpty()) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                return;
            }

            ContentValues values = new ContentValues();
            values.put(StudentContract.StudentEntry.COLUMN_NAME, name);
            values.put(StudentContract.StudentEntry.COLUMN_ROLL, roll);
            Uri uri = getContentResolver().insert(StudentContract.StudentEntry.CONTENT_URI, values);

            if (uri != null) {
                Toast.makeText(this, "Inserted", Toast.LENGTH_SHORT).show();
                nameInput.setText("");
                rollInput.setText("");
            } else {
                Toast.makeText(this, "Insert failed", Toast.LENGTH_SHORT).show();
            }
        });

        showBtn.setOnClickListener(v -> {
            Cursor cursor = getContentResolver().query(StudentContract.StudentEntry.CONTENT_URI, null, null, null, null);
            StringBuilder builder = new StringBuilder();
            if (cursor != null) {
                while (cursor.moveToNext()) {
                    String name = cursor.getString(cursor.getColumnIndexOrThrow(StudentContract.StudentEntry.COLUMN_NAME));
                    String roll = cursor.getString(cursor.getColumnIndexOrThrow(StudentContract.StudentEntry.COLUMN_ROLL));
                    builder.append("Name: ").append(name).append("\nRoll: ").append(roll).append("\n\n");
                }
                cursor.close();
            }
            display.setText(builder.toString());
        });
    }
}
