package com.vikydroid.demo.learning.vpn.uart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.things.pio.PeripheralManager;
import com.google.android.things.pio.UartDevice;
import com.vikydroid.demo.R;

import java.io.IOException;
import java.util.List;

public class UartActivity extends AppCompatActivity {
    private static final String TAG = "UartActivity";
    private static final String UART_DEVICE_NAME = "MyUartDevice";
    private UartDevice mDevice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uart);

        if (!isThingsDevice(this)) {
            Toast.makeText(this, "lllllllllllllllll", Toast.LENGTH_SHORT).show();
            ((TextView) findViewById(R.id.tv_things)).setText("false");
            return;
        }

        PeripheralManager manager = PeripheralManager.getInstance();
        List<String> deviceList = manager.getUartDeviceList();
        if (deviceList.isEmpty()) {
            Log.i(TAG, "No UART port available on this device.");
        } else {
            Log.i(TAG, "List of available devices: " + deviceList);
        }

        //
        try {
            manager = PeripheralManager.getInstance();
            mDevice = manager.openUartDevice(UART_DEVICE_NAME);
        } catch (IOException e) {
            Log.w(TAG, "Unable to access UART device", e);
        }

    }

    public boolean isThingsDevice(Context context) {
        final PackageManager pm = context.getPackageManager();
        return pm.hasSystemFeature(PackageManager.FEATURE_EMBEDDED);
    }

    public void setFlowControlEnabled(UartDevice uart, boolean enable) throws IOException {
        if (enable) {
            // Enable hardware flow control
            uart.setHardwareFlowControl(UartDevice.HW_FLOW_CONTROL_AUTO_RTSCTS);
        } else {
            // Disable flow control
            uart.setHardwareFlowControl(UartDevice.HW_FLOW_CONTROL_NONE);
        }
    }

    public void writeUartData(UartDevice uart) throws IOException {
        byte[] buffer = {};
        int count = uart.write(buffer, buffer.length);
        Log.d(TAG, "Wrote " + count + " bytes to peripheral");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (mDevice != null) {
            try {
                mDevice.close();
                mDevice = null;
            } catch (IOException e) {
                Log.w(TAG, "Unable to close UART device", e);
            }
        }
    }

    public void configureUartFrame(UartDevice uart) throws IOException {
        // Configure the UART port
        uart.setBaudrate(115200);
        uart.setDataSize(8);
        uart.setParity(UartDevice.PARITY_NONE);
        uart.setStopBits(1);
    }
}