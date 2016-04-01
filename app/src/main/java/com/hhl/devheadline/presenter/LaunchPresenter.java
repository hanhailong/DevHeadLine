package com.hhl.devheadline.presenter;

import android.os.Handler;

import com.hhl.devheadline.ui.iview.ILaunchView;

/**
 * Created by HanHailong on 16/3/15.
 */
public class LaunchPresenter extends BasePresenter<ILaunchView> {

    public LaunchPresenter(ILaunchView view) {
        super(view);
    }

    /**
     * 跳转到主页面
     */
    public void launchToMain() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mView.goMain();
            }
        }, 1500);
    }
}
