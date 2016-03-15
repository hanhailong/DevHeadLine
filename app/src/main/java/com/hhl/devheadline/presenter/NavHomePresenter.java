package com.hhl.devheadline.presenter;

import com.hhl.devheadline.ui.fragment.BaseFragment;
import com.hhl.devheadline.ui.fragment.HomeChoiceFragment;
import com.hhl.devheadline.ui.fragment.HomeFindFragment;
import com.hhl.devheadline.ui.fragment.HomeSubscribeFragment;
import com.hhl.devheadline.ui.iview.INavHomeView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by HanHailong on 16/3/15.
 */
public class NavHomePresenter extends BasePresenter<INavHomeView> {

    public NavHomePresenter(INavHomeView view) {
        super(view);
    }

    List<BaseFragment> mFragmentList = new ArrayList<>();

    private CharSequence[] mTitles = {"精选", "订阅", "发现"};

    public void initTabLayout() {
        mFragmentList.clear();

        mFragmentList.add(new HomeChoiceFragment());
        mFragmentList.add(new HomeSubscribeFragment());
        mFragmentList.add(new HomeFindFragment());

        mView.loadTabData(mFragmentList, Arrays.asList(mTitles));
    }
}
