package com.example.a10;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.view.View;
import android.widget.Toast;
import android.widget.EditText;
import android.widget.Button;
public class MainActivity extends AppCompatActivity {
private EditText editText,editText2;
private Button button,button1,button2,button3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        editText=findViewById(R.id.firstNumberInput);
        editText2=findViewById(R.id.secondNumberInput);
        button=findViewById(R.id.buttonAdd);
        button1=findViewById(R.id.buttonSubtract);
        button2=findViewById(R.id.buttonMultiply);
        button3=findViewById(R.id.buttonDivide);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a=Integer.parseInt(editText.getText().toString());
                int b=Integer.parseInt(editText2.getText().toString());
                int c=a+b;
                Toast.makeText(MainActivity.this,"Addition: "+c,Toast.LENGTH_LONG).show();
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a=Integer.parseInt(editText.getText().toString());
                int b=Integer.parseInt(editText2.getText().toString());
                int c=a-b;
                Toast.makeText(MainActivity.this,"Subtraction: "+c,Toast.LENGTH_LONG).show();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a=Integer.parseInt(editText.getText().toString());
                int b=Integer.parseInt(editText2.getText().toString());
                int c=a*b;
                Toast.makeText(MainActivity.this,"Multiplication: "+c,Toast.LENGTH_LONG).show();
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a=Integer.parseInt(editText.getText().toString());
                int b=Integer.parseInt(editText2.getText().toString());
                int c=a/b;
                Toast.makeText(MainActivity.this,"Division: "+c,Toast.LENGTH_LONG).show();
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}