package com.example.a37;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    Button btnFadeIn, btnFadeOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        btnFadeIn = findViewById(R.id.btnFadeIn);
        btnFadeOut = findViewById(R.id.btnFadeOut);

        btnFadeIn.setOnClickListener(v -> {
            imageView.animate().alpha(1f).setDuration(500).start();
        });

        btnFadeOut.setOnClickListener(v -> {
            imageView.animate().alpha(0f).setDuration(500).start();
        });
    }
}
