package com.hhl.devheadline.ui.activity;

import android.os.Bundle;

import com.hhl.devheadline.R;
import com.hhl.devheadline.presenter.BasePresenter;
import com.hhl.devheadline.presenter.FeedbackPresenter;
import com.hhl.devheadline.ui.iview.IFeedbackView;

/**
 * 商务合作
 */
public class BusinessCoopActivity extends BaseActivity implements IFeedbackView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    protected int getContentView() {
        return R.layout.activity_business_coop;
    }

    @Override
    protected BasePresenter getPresenter() {
        return new FeedbackPresenter(this);
    }
}
