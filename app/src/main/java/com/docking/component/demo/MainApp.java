package com.docking.component.demo;

import android.content.Context;

import com.docking.component.core.BaseApplication;

public class MainApp extends BaseApplication {
    public static Context sContext = null;

    @Override
    public void onCreate() {
        super.onCreate();
        sContext = getApplicationContext();
    }

}
