package com.example.a21;
import android.content.Context;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText editName, editRoll;
    Button btnInsert;
    TextView textViewData;
    MyDatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editName = findViewById(R.id.editName);
        editRoll = findViewById(R.id.editRoll);
        btnInsert = findViewById(R.id.btnInsert);
        textViewData = findViewById(R.id.textViewData);
        dbHelper = new MyDatabaseHelper(this);

        // Keep DB open for App Inspection
        dbHelper.getDbForDebug();

        btnInsert.setOnClickListener(v -> {
            String name = editName.getText().toString();
            String roll = editRoll.getText().toString();

            if (!name.isEmpty() && !roll.isEmpty()) {
                new InsertTask(MainActivity.this, dbHelper, name, roll).execute();
                editName.setText("");
                editRoll.setText("");
            } else {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private static class InsertTask extends AsyncTask<Void, Void, Void> {
        private final MyDatabaseHelper dbHelper;
        private final String name, roll;
        private final Context context;

        InsertTask(Context context, MyDatabaseHelper dbHelper, String name, String roll) {
            this.context = context;
            this.dbHelper = dbHelper;
            this.name = name;
            this.roll = roll;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            dbHelper.insertStudent(name, roll);
            return null;
        }

        @Override
        protected void onPostExecute(Void unused) {
            ((MainActivity) context).displayData();
            Toast.makeText(context, "Inserted Successfully", Toast.LENGTH_SHORT).show();
        }
    }

    private void displayData() {
        Cursor cursor = dbHelper.getAllData();
        StringBuilder builder = new StringBuilder();

        while (cursor.moveToNext()) {
            builder.append("Name: ").append(cursor.getString(1))
                    .append(", Roll: ").append(cursor.getString(2)).append("\n");
        }

        textViewData.setText(builder.toString());
        cursor.close();
    }
}
