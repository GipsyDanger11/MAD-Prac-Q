package com.example.a22;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.view.View;
import android.widget.CheckBox;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
private CheckBox cb,cb1,cb2;
private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        cb=findViewById(R.id.checkPizza);
        cb1=findViewById(R.id.checkCoffee);
        cb2=findViewById(R.id.checkBurger);
        button=findViewById(R.id.btnOrder);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a=0;
                String b="";
                if(cb.isChecked())
                {
                    a=a+120;
                    b=b+"\nPizza";
                }
                if(cb1.isChecked())
                {
                    a=a+80;
                    b=b+"\nCoffee";
                }
                if(cb2.isChecked())
                {
                    a=a+100;
                    b=b+"\nBurger";
                }
                Toast.makeText(MainActivity.this,"Items: "+b+"\nPrice: "+a,Toast.LENGTH_LONG).show();
            }
        });
    }
}