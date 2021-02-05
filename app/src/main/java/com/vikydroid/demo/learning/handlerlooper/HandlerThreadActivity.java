package com.vikydroid.demo.learning.handlerlooper;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;

import com.vikydroid.demo.R;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.List;

import static com.vikydroid.demo.learning.handlerlooper.MyHandler.TASK_A;
import static com.vikydroid.demo.learning.handlerlooper.MyHandler.TASK_B;


public class HandlerThreadActivity extends AppCompatActivity implements LocationListener {
    private static final String TAG = "HandlerThreadActivity";
    public static final int MY_PERMISSIONS_REQUEST_LOCATION = 99;
    LocationManager locationManager;
    MyLooperThread looperThread = new MyLooperThread();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler_thread);
        deviceData();
        checkLocationPermission();
        getSensorsData();
        getBTData();
        getCPUUsage();
    }

    private void deviceData() {
        StringBuilder builder = new StringBuilder();
        builder.append("android : ").append(Build.VERSION.RELEASE);

        Field[] fields = Build.VERSION_CODES.class.getFields();
        for (Field field : fields) {
            String fieldName = field.getName();
            int fieldValue = -1;

            try {
                fieldValue = field.getInt(new Object());
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (NullPointerException e) {
                e.printStackTrace();
            }

            if (fieldValue == Build.VERSION.SDK_INT) {
                builder.append(" : ").append(fieldName).append(" : ");
                builder.append("sdk=").append(fieldValue);
            }
        }


        Log.d(TAG, "OS: " + builder.toString());
        Log.d(TAG, "Display: " + Build.DISPLAY);
        Log.d(TAG, "Host: " + Build.HOST);
        Log.d(TAG, "Display: " + Build.PRODUCT);
        Log.d(TAG, "Display: " + Build.MANUFACTURER);
        Log.d(TAG, "Display: " + Build.BOARD);


        System.out.println("===================================");
        Log.i("TAG", "SERIAL: " + Build.SERIAL);
        Log.i("TAG", "MODEL: " + Build.MODEL);
        Log.i("TAG", "ID: " + Build.ID);
        Log.i("TAG", "Manufacture: " + Build.MANUFACTURER);
        Log.i("TAG", "brand: " + Build.BRAND);
        Log.i("TAG", "type: " + Build.TYPE);
        Log.i("TAG", "user: " + Build.USER);
        Log.i("TAG", "BASE: " + Build.VERSION_CODES.BASE);
        Log.i("TAG", "INCREMENTAL " + Build.VERSION.INCREMENTAL);
        Log.i("TAG", "SDK  " + Build.VERSION.SDK);
        Log.i("TAG", "BOARD: " + Build.BOARD);
        Log.i("TAG", "BRAND " + Build.BRAND);
        Log.i("TAG", "HOST " + Build.HOST);
        Log.i("TAG", "FINGERPRINT: " + Build.FINGERPRINT);
        Log.i("TAG", "Version Code: " + Build.VERSION.RELEASE);
        Log.i("TAG", "Device Name: " + getDeviceName());
    }

    public boolean checkLocationPermission() {
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {

            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.ACCESS_FINE_LOCATION)) {

                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.
                new AlertDialog.Builder(this)
                        .setTitle("title_location_permission")
                        .setMessage("text_location_permission")
                        .setPositiveButton("ok", (dialogInterface, i) -> {
                            //Prompt the user once explanation has been shown
                            ActivityCompat.requestPermissions(this,
                                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                                    MY_PERMISSIONS_REQUEST_LOCATION);
                        })
                        .create()
                        .show();
            } else {
                // No explanation needed, we can request the permission.
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                        MY_PERMISSIONS_REQUEST_LOCATION);
            }
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_LOCATION: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    // permission was granted, yay! Do the
                    // location-related task you need to do.
                    if (ContextCompat.checkSelfPermission(this,
                            Manifest.permission.ACCESS_FINE_LOCATION)
                            == PackageManager.PERMISSION_GRANTED) {

                        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
                        //Request location updates:
                        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 400, 1, this);
                    }

                } else {

                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.

                }
                return;
            }

        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {

            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 400, 1, this);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {

            locationManager.removeUpdates(this);
        }
    }

    private void getCPUUsage() {
        ProcessBuilder processBuilder;
        String Holder = "";
        String[] DATA = {"/system/bin/cat", "/proc/cpuinfo"};
        InputStream inputStream;
        Process process;
        byte[] byteArry;
        byteArry = new byte[1024];

        try {
            processBuilder = new ProcessBuilder(DATA);

            process = processBuilder.start();

            inputStream = process.getInputStream();

            while (inputStream.read(byteArry) != -1) {

                Holder = Holder + new String(byteArry);
            }

            inputStream.close();

        } catch (IOException ex) {

            ex.printStackTrace();
        }
        Log.e(TAG, "getCPUUsage: " + Holder);
    }

    private void getBTData() {
        BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if (mBluetoothAdapter == null) {
            Log.i("TAG", "Device does not support Bluetooth");
        } else if (!mBluetoothAdapter.isEnabled()) {
            Log.i("TAG", "Bluetooth is not enabled");
        } else {
            Log.i("TAG", "Bluetooth is enabled");
        }
    }

    private void getSensorsData() {
        SensorManager mSensorManager;
        mSensorManager = (SensorManager) ((Context) this).getSystemService(Context.SENSOR_SERVICE);
        List<Sensor> sensorList = mSensorManager.getSensorList(Sensor.TYPE_ALL);
        StringBuilder sensorText = new StringBuilder();

        for (Sensor currentSensor : sensorList) {
            sensorText.append(currentSensor.getName()).append(System.getProperty("line.separator"));
        }
        System.out.println(sensorText);
    }

    public String getDeviceName() {
        String manufacturer = Build.MANUFACTURER;
        String model = Build.MODEL;
        if (model.startsWith(manufacturer)) {
            return capitalize(model);
        }
        return capitalize(manufacturer) + " " + model;
    }

    private String capitalize(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        char[] arr = str.toCharArray();
        boolean capitalizeNext = true;

        StringBuilder phrase = new StringBuilder();
        for (char c : arr) {
            if (capitalizeNext && Character.isLetter(c)) {
                phrase.append(Character.toUpperCase(c));
                capitalizeNext = false;
                continue;
            } else if (Character.isWhitespace(c)) {
                capitalizeNext = true;
            }
            phrase.append(c);
        }

        return phrase.toString();
    }

    public void startThread(View view) {
        looperThread.start();
    }

    public void stopThread(View view) {
        looperThread.looper.quit();
    }

    public void taskA(View view) {
        MyHandler handler = new MyHandler(looperThread.looper);
        Message msg = Message.obtain();
        msg.what = TASK_A;
        handler.sendMessage(msg);

    }

    public void taskB(View view) {
        MyHandler handler = new MyHandler(looperThread.looper);
        Message msg = Message.obtain();
        msg.what = TASK_B;
        handler.sendMessage(msg);
    }

    @Override
    public void onLocationChanged(Location location) {
        Log.e(TAG, "Location: Latitude: " + location.getLatitude() + " Longitude: "
                + location.getLongitude());
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
        Log.e(TAG, "Location: onStatusChanged");
    }

    @Override
    public void onProviderEnabled(String provider) {
        Log.e(TAG, "Location: onProviderEnabled");
    }

    @Override
    public void onProviderDisabled(String provider) {
        Log.e(TAG, "Location: onProviderDisabled");
    }
}