package com.hhl.devheadline.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.hhl.devheadline.R;
import com.hhl.devheadline.presenter.FeedbackPresenter;
import com.hhl.devheadline.ui.iview.IFeedbackView;

public class FeedbackActivity extends BaseActivity<FeedbackPresenter> implements IFeedbackView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_feedback;
    }

    @Override
    protected FeedbackPresenter getPresenter() {
        return new FeedbackPresenter(this);
    }

    /**
     * @param context
     */
    public static void launch(Context context) {
        Intent intent = new Intent(context, FeedbackActivity.class);
        context.startActivity(intent);
    }
}
