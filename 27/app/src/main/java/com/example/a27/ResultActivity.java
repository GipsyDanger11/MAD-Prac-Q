package com.example.a27;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {
    TextView factorialResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        factorialResult = findViewById(R.id.factorialResult);

        String input = getIntent().getStringExtra("number");
        int num = Integer.parseInt(input);
        long fact = factorial(num);
        factorialResult.setText("Factorial of " + num + " is: " + fact);
    }

    private long factorial(int n) {
        long result = 1;
        for (int i = 1; i <= n; i++)
            result *= i;
        return result;
    }
}
