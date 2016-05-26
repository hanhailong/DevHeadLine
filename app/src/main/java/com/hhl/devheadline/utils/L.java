package com.hhl.devheadline.utils;

import android.util.Log;

import com.hhl.devheadline.BuildConfig;

/**
 * 日志工具类
 * Created by HanHailong on 16/5/26.
 */

public class L {

    private static final boolean DEBUG = BuildConfig.DEBUG;

    public static void e(String tag, String msg) {
        if (DEBUG) {
            Log.e(tag, msg);
        }
    }

    public static void d(String tag, String msg) {
        if (DEBUG) {
            Log.d(tag, msg);
        }
    }

    public static void w(String tag, String msg) {
        if (DEBUG) {
            Log.e(tag, msg);
        }
    }

    public static void i(String tag, String msg) {
        if (DEBUG) {
            Log.e(tag, msg);
        }
    }

    public static void v(String tag, String msg) {
        if (DEBUG) {
            Log.e(tag, msg);
        }
    }
}
