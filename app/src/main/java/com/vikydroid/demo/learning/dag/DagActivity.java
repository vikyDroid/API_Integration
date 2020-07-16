package com.vikydroid.demo.learning.dag;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.vikydroid.demo.App;
import com.vikydroid.demo.R;
import com.vikydroid.demo.learning.dag.car.Car;
import com.vikydroid.demo.learning.dag.d2.ActivityComponent;
import com.vikydroid.demo.learning.dag.d2.DieselEngineModule;
import com.vikydroid.demo.learning.dag.d2.DriverModule;
//import com.vikydroid.demo.learning.dag.d2.DaggerActivityComponent;

import javax.inject.Inject;

public class DagActivity extends AppCompatActivity {
    @Inject
    Car car1, car2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dag);

        ActivityComponent component = ((App) getApplication()).getAppComponent()
                .getActivityComponentFactory().create(100, 1400);

        component.inject(this);

        car1.start();
        car2.start();
    }
}