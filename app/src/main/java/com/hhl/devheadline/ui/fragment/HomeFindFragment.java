package com.hhl.devheadline.ui.fragment;

import android.view.View;

import com.hhl.devheadline.R;
import com.hhl.devheadline.presenter.HomeFindPresenter;
import com.hhl.devheadline.ui.iview.IHomeFindView;

/**
 * Created by HanHailong on 16/3/15.
 */
public class HomeFindFragment extends BaseFragment<HomeFindPresenter> implements IHomeFindView {
    @Override
    protected int getContentView() {
        return R.layout.fragment_home_find;
    }

    @Override
    protected HomeFindPresenter getPresenter() {
        return new HomeFindPresenter(this);
    }

    @Override
    protected void init(View view) {

    }
}
