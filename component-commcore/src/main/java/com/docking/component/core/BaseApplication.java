package com.docking.component.core;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.alibaba.android.arouter.launcher.ARouter;

import java.util.List;

public class BaseApplication extends Application {

    private List<AppLifecycles> mModules = null;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.w("dkk", "dkk onCreate");
        init(this);

        //遍历之前获得的集合, 执行每一个 ConfigModule 实现类的某些方法
        if (mModules != null) {
            for (AppLifecycles module : mModules) {
                if (module == null) {
                    continue;
                }
                module.onCreate(this);
            }
        }
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        Log.w("dkk", "dkk attachBaseContext");
        //用反射, 将 AndroidManifest.xml 中带有 ConfigModule 标签的 class 转成对象集合（List<ConfigModule>）
        ManifestParser manifestParser = new ManifestParser(this);
        if (this.mModules == null) {
            this.mModules = manifestParser.parse();
        }
        Log.w("dkk", "dkk mModules = " + mModules);
        if (mModules == null) {
            return;
        }

        for (AppLifecycles module : mModules) {
            if (module == null) {
                continue;
            }
            module.attachBaseContext(this);
        }
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        Log.w("dkk", "dkk onTerminate");
        if (mModules == null) {
            return;
        }
        for (AppLifecycles module : mModules) {
            if (module == null) {
                continue;
            }
            module.onTerminate(this);
        }
    }

    public static void init(Application application) {
        Log.w("dkk", "dkk BuildConfig.DEBUG = " + com.alibaba.android.arouter.BuildConfig.DEBUG);
        if (BuildConfig.DEBUG) {
            ARouter.openLog();     // 打印日志
            ARouter.openDebug();   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        }
        // 尽可能早，推荐在Application中初始化
        ARouter.init(application);
    }

}
