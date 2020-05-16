package com.docking.component.arouter;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;

import com.docking.component.core.AppLifecycles;

public final class ArouterConfig implements AppLifecycles {


    @Override
    public void attachBaseContext(@NonNull Context base) {

    }

    @Override
    public void onCreate(@NonNull Application application) {
        Log.w("dkk", "ArouterConfig onCreate");
    }

    @Override
    public void onTerminate(@NonNull Application application) {

    }
}
