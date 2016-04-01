package com.hhl.devheadline.ui.fragment;

import android.view.View;

import com.hhl.devheadline.R;
import com.hhl.devheadline.presenter.HomeSubscribePresenter;
import com.hhl.devheadline.ui.iview.IHomeSubscribeView;

/**
 * Created by HanHailong on 16/3/15.
 */
public class HomeSubscribeFragment extends BaseFragment<HomeSubscribePresenter> implements IHomeSubscribeView {
    @Override
    protected int getContentView() {
        return R.layout.fragment_home_subscribe;
    }

    @Override
    protected HomeSubscribePresenter getPresenter() {
        return new HomeSubscribePresenter(this);
    }

    @Override
    protected void init(View view) {

    }
}
