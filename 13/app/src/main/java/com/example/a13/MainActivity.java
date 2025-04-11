package com.example.a13;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    CheckBox chkMAD, chkEDE, chkPHP, chkPWP, chkETI;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chkMAD = findViewById(R.id.chkMAD);
        chkEDE = findViewById(R.id.chkEDE);
        chkPHP = findViewById(R.id.chkPHP);
        chkPWP = findViewById(R.id.chkPWP);
        chkETI = findViewById(R.id.chkETI);
        btnSubmit = findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(v -> {
            StringBuilder selectedSubjects = new StringBuilder();

            if (chkMAD.isChecked()) selectedSubjects.append("MAD ");
            if (chkEDE.isChecked()) selectedSubjects.append("EDE ");
            if (chkPHP.isChecked()) selectedSubjects.append("PHP ");
            if (chkPWP.isChecked()) selectedSubjects.append("PWP ");
            if (chkETI.isChecked()) selectedSubjects.append("ETI ");

            String result = selectedSubjects.length() > 0
                    ? "Selected: " + selectedSubjects.toString().trim()
                    : "No subject selected";

            Toast.makeText(MainActivity.this, result, Toast.LENGTH_SHORT).show();
        });
    }
}
