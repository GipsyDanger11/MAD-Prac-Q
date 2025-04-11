package com.example.a12;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText editName, editRoll;
    AutoCompleteTextView autoCourse;
    Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editName = findViewById(R.id.editName);
        editRoll = findViewById(R.id.editRoll);
        autoCourse = findViewById(R.id.autoCourse);
        btnRegister = findViewById(R.id.btnRegister);

        String[] courses = {"CO", "IF", "IE"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, courses);
        autoCourse.setAdapter(adapter);

        btnRegister.setOnClickListener(v -> {
            String name = editName.getText().toString().trim();
            String roll = editRoll.getText().toString().trim();
            String course = autoCourse.getText().toString().trim();

            if (name.isEmpty() || roll.isEmpty() || course.isEmpty()) {
                Toast.makeText(MainActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            } else {
                String message = "Name: " + name + "\nRoll No: " + roll + "\nCourse: " + course;
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();
            }
        });
    }
}
