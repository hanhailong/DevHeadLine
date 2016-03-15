package com.hhl.devheadline;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by HanHailong on 16/3/15.
 */
public class DevHeadLineApplication extends Application {

    private static DevHeadLineApplication mInstance;

    @Override
    public void onCreate() {
        super.onCreate();

        Fresco.initialize(this);
        mInstance = this;
    }

    /**
     * 获取唯一Application
     *
     * @return
     */
    public static DevHeadLineApplication getInstance() {
        return mInstance;
    }
}
