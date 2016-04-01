package com.hhl.devheadline.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.hhl.devheadline.R;
import com.hhl.devheadline.presenter.LaunchPresenter;
import com.hhl.devheadline.ui.iview.ILaunchView;

public class LaunchActivity extends BaseActivity<LaunchPresenter> implements ILaunchView {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter.launchToMain();
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_launch;
    }

    @Override
    protected LaunchPresenter getPresenter() {
        return new LaunchPresenter(this);
    }

    @Override
    protected boolean isNeedToolbar() {
        return false;
    }

    @Override
    public void goMain() {
        MainActivity.launch(LaunchActivity.this);
        finish();
    }
}
