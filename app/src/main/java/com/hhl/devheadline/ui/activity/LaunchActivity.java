package com.hhl.devheadline.ui.activity;

import android.os.Bundle;
import android.os.Handler;

import com.hhl.devheadline.R;

public class LaunchActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                MainActivity.launch(LaunchActivity.this);
                finish();
            }
        }, 2000);
    }
}
