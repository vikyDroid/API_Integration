package com.vikydroid.demo.viewmodel;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.vikydroid.demo.learning.service.MyBinderService;

public class BinderServiceVM extends ViewModel {
    private static final String TAG = "BinderServiceVM";
    private MutableLiveData<Boolean> isProgressBarUpdating = new MutableLiveData<>();
    private MutableLiveData<MyBinderService.MyBinder> myBinder = new MutableLiveData<>();

    public MutableLiveData<Boolean> getIsProgressBarUpdating() {
        return isProgressBarUpdating;
    }

    public void setIsProgressBarUpdating(Boolean isProgressBarUpdating) {
        this.isProgressBarUpdating.postValue(isProgressBarUpdating);
    }

    public MutableLiveData<MyBinderService.MyBinder> getMyBinder() {
        return myBinder;
    }

    public ServiceConnection getConnection() {
        return connection;
    }

    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.d(TAG, "onServiceConnected: ");
            myBinder.postValue((MyBinderService.MyBinder) service);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            myBinder.postValue(null);
        }
    };


}
