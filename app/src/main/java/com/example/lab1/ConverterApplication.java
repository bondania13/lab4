package com.example.lab1;

import android.app.Application;

import timber.log.Timber;

public class ConverterApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        if (BuildConfig.DEBUG) {
        Timber.plant(new Timber.DebugTree());
    }}
}
