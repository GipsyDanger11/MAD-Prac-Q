package com.example.a9;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    BluetoothAdapter bluetoothAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        ToggleButton toggleBluetooth = findViewById(R.id.toggleBluetooth);

        // Set initial toggle state
        if (bluetoothAdapter != null) {
            toggleBluetooth.setChecked(bluetoothAdapter.isEnabled());
        }

        toggleBluetooth.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (bluetoothAdapter == null) {
                Toast.makeText(this, "Bluetooth not supported", Toast.LENGTH_SHORT).show();
                toggleBluetooth.setChecked(false);
                return;
            }

            if (isChecked) {
                // Turn ON Bluetooth
                if (!bluetoothAdapter.isEnabled()) {
                    Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                    startActivity(intent);
                    Toast.makeText(this, "Requesting to turn on Bluetooth...", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Bluetooth already ON", Toast.LENGTH_SHORT).show();
                }
            } else {
                // Turn OFF Bluetooth (with Android 13+ handling)
                if (bluetoothAdapter.isEnabled()) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                        Toast.makeText(this, "Cannot turn off Bluetooth on Android 13+. Opening settings...", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(Settings.ACTION_BLUETOOTH_SETTINGS);
                        startActivity(intent);
                        // reset toggle state to ON after redirect
                        toggleBluetooth.setChecked(true);
                    } else {
                        bluetoothAdapter.disable();
                        Toast.makeText(this, "Bluetooth turned off", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(this, "Bluetooth already OFF", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
