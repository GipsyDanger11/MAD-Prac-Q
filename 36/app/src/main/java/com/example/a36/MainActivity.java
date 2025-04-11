package com.example.a36;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    Button btnZoomIn, btnZoomOut;
    float scale = 1f; // Initial scale

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        btnZoomIn = findViewById(R.id.btnZoomIn);
        btnZoomOut = findViewById(R.id.btnZoomOut);

        btnZoomIn.setOnClickListener(v -> {
            if (scale < 3f) { // limit max zoom
                scale += 0.2f;
                imageView.setScaleX(scale);
                imageView.setScaleY(scale);
            }
        });

        btnZoomOut.setOnClickListener(v -> {
            if (scale > 0.5f) { // limit min zoom
                scale -= 0.2f;
                imageView.setScaleX(scale);
                imageView.setScaleY(scale);
            }
        });
    }
}

