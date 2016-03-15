package com.hhl.devheadline.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.hhl.devheadline.R;
import com.hhl.devheadline.presenter.SettingPresenter;
import com.hhl.devheadline.ui.iview.ISettingView;

public class SettingActivity extends BaseActivity<SettingPresenter> implements ISettingView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_setting;
    }

    @Override
    protected SettingPresenter getPresenter() {
        return new SettingPresenter(this);
    }

    /**
     * @param context
     */
    public static void launch(Context context) {
        Intent intent = new Intent(context, SettingActivity.class);
        context.startActivity(intent);
    }
}
