package com.example.a16;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.app.ProgressDialog;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private ProgressDialog pg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        button=findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pg=new ProgressDialog(MainActivity.this);
                pg.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                pg.setTitle("File downloading");
                pg.setProgress(100);
                Thread t=new Thread(()->{
                    int p=0;
                    while(p<=100)
                    {
                        try {
                            pg.setProgress(p);
                            p++;
                            Thread.sleep(100);
                        } catch (Exception e) {
                        }
                    }
                    pg.dismiss();
                });
                t.start();
                pg.show();
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
