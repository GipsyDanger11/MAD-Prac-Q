package com.example.a30;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    BroadcastReceiver systemReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((TextView) findViewById(R.id.textView)).setText("Listening to system broadcasts...");

        // Define broadcast receiver
        systemReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                String action = intent.getAction();
                switch (action) {
                    case Intent.ACTION_POWER_CONNECTED:
                        Toast.makeText(context, "Power Connected", Toast.LENGTH_SHORT).show();
                        break;
                    case Intent.ACTION_POWER_DISCONNECTED:
                        Toast.makeText(context, "Power Disconnected", Toast.LENGTH_SHORT).show();
                        break;
                    case Intent.ACTION_HEADSET_PLUG:
                        int state = intent.getIntExtra("state", -1);
                        if (state == 1) {
                            Toast.makeText(context, "Headset Plugged", Toast.LENGTH_SHORT).show();
                        } else if (state == 0) {
                            Toast.makeText(context, "Headset Unplugged", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case Intent.ACTION_AIRPLANE_MODE_CHANGED:
                        boolean isOn = intent.getBooleanExtra("state", false);
                        Toast.makeText(context, "Airplane Mode: " + (isOn ? "On" : "Off"), Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        };

        // Register dynamically
        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_POWER_CONNECTED);
        filter.addAction(Intent.ACTION_POWER_DISCONNECTED);
        filter.addAction(Intent.ACTION_HEADSET_PLUG);
        filter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED);

        registerReceiver(systemReceiver, filter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(systemReceiver);
    }
}
