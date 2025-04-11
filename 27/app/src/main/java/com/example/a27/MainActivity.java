package com.example.a27;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText inputNumber;
    Button nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inputNumber = findViewById(R.id.inputNumber);
        nextButton = findViewById(R.id.nextButton);

        nextButton.setOnClickListener(v -> {
            String num = inputNumber.getText().toString();
            Intent intent = new Intent(MainActivity.this, ResultActivity.class);
            intent.putExtra("number", num);
            startActivity(intent);
        });
    }
}
