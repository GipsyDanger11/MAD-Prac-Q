package com.example.a14;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    RadioButton rbMAD, rbEDE, rbPHP, rbPWP, rbETI;
    RadioGroup genderGroup;
    RadioButton rbMale, rbFemale;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rbMAD = findViewById(R.id.rbMAD);
        rbEDE = findViewById(R.id.rbEDE);
        rbPHP = findViewById(R.id.rbPHP);
        rbPWP = findViewById(R.id.rbPWP);
        rbETI = findViewById(R.id.rbETI);

        genderGroup = findViewById(R.id.genderGroup);
        rbMale = findViewById(R.id.rbMale);
        rbFemale = findViewById(R.id.rbFemale);

        btnSubmit = findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(v -> {
            String selectedSubject = "";
            if (rbMAD.isChecked()) selectedSubject = "MAD";
            if (rbEDE.isChecked()) selectedSubject = "EDE";
            if (rbPHP.isChecked()) selectedSubject = "PHP";
            if (rbPWP.isChecked()) selectedSubject = "PWP";
            if (rbETI.isChecked()) selectedSubject = "ETI";

            int genderId = genderGroup.getCheckedRadioButtonId();
            String selectedGender = "";
            if (genderId != -1) {
                RadioButton selectedGenderBtn = findViewById(genderId);
                selectedGender = selectedGenderBtn.getText().toString();
            }

            if (!selectedSubject.isEmpty() && !selectedGender.isEmpty()) {
                String message = "Subject: " + selectedSubject + "\nGender: " + selectedGender;
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(MainActivity.this, "Please select subject and gender", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
