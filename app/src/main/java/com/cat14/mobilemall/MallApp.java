package com.cat14.mobilemall;

import android.app.Application;
import android.content.Context;

/**
 * 全局Application
 */
public class MallApp extends Application {

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }

    public static Context getContext() {
        return context;
    }
}
