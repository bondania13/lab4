package com.example.lab1;

import android.os.Handler;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

import timber.log.Timber;

public class Timer implements LifecycleObserver {
    private int RunningSec = 0;
    private int ActiveSec = 0;
    private Handler handler = new Handler();
    private Runnable runningTimer = new Runnable() {
        @Override
        public void run() {
            RunningSec++;
            handler.postDelayed(this, 1000);
        }
    };
    private Runnable activeTimer = new Runnable() {
        @Override
        public void run() {
           Timber.i("Active Timer is at %s", ActiveSec);
            ActiveSec++;
            handler.postDelayed(this, 1000);
        }
    };


    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void startRunningTimer() {
        Timber.i("Running Timer started");
        handler.post(runningTimer);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    private void startActiveTimer() {
        Timber.i("Active Timer started");
        handler.post(activeTimer);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    private void stopActiveTimer() {
        handler.removeCallbacks(activeTimer);
        Timber.i("Active Timer stopped");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    private void stopRunningTimer() {
        handler.removeCallbacks(runningTimer);
        Timber.i("Running Timer stopped");
        Timber.i("Running time: %d/%d seconds", ActiveSec, RunningSec);
        Timber.i("App is focus: %.2f%%", ActiveSec*100/(float)RunningSec);
    }
}
