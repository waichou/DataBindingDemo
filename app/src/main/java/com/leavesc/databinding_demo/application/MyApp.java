package com.leavesc.databinding_demo.application;

import android.app.Application;
import android.content.Context;

/**
 * @author zhouwei
 * @date 2018/10/7
 * @time 16:01
 * @desc
 */
public class MyApp extends Application {

    public static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();

        mContext = getApplicationContext();
    }
}
