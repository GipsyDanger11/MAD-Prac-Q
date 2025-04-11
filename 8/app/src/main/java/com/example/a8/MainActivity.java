package com.example.a8;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AutoCompleteTextView searchBox = findViewById(R.id.search_box);

        // Sample search suggestions
        String[] suggestions = {
                "Mobile Application Development", "Entrepreneurship Development", "PROGRAMMING WITH PYTHON", "EMERGING TRENDS IN COMPUTER AND INFORMATION TECHNOLOGY", " MANAGEMENT",
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_dropdown_item_1line,
                suggestions
        );

        searchBox.setAdapter(adapter);
    }
}