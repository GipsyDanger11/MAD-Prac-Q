package com.example.a35;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    Button btnClockwise, btnAntiClockwise;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        btnClockwise = findViewById(R.id.btnClockwise);
        btnAntiClockwise = findViewById(R.id.btnAntiClockwise);

        btnClockwise.setOnClickListener(v -> {
            RotateAnimation rotate = new RotateAnimation(
                    0, 360,
                    Animation.RELATIVE_TO_SELF, 0.5f,
                    Animation.RELATIVE_TO_SELF, 0.5f);
            rotate.setDuration(1000);
            imageView.startAnimation(rotate);
        });

        btnAntiClockwise.setOnClickListener(v -> {
            RotateAnimation rotate = new RotateAnimation(
                    360, 0,
                    Animation.RELATIVE_TO_SELF, 0.5f,
                    Animation.RELATIVE_TO_SELF, 0.5f);
            rotate.setDuration(1000);
            imageView.startAnimation(rotate);
        });
    }
}
