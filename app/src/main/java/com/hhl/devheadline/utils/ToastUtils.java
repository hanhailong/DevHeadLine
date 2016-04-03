package com.hhl.devheadline.utils;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.StringRes;
import android.widget.Toast;

import com.hhl.devheadline.DevHeadLineApplication;

/**
 * Toast工具类，可以在任何线程都可以Toast的工具类
 * Created by HanHailong on 16/4/4.
 */
public class ToastUtils {

    /**
     * Toast
     *
     * @param content
     */
    public static void toast(final String content) {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(DevHeadLineApplication.getInstance(), content, Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * Toast
     *
     * @param id
     */
    public static void toast(@StringRes int id) {
        toast(DevHeadLineApplication.getInstance().getResources().getString(id));
    }
}
