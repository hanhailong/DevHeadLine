package com.hhl.devheadline.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.hhl.devheadline.ui.fragment.BaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HanHailong on 16/3/15.
 */
public class HomeAdapter extends FragmentPagerAdapter {

    private List<BaseFragment> mFragmentList = new ArrayList<>();
    private List<CharSequence> mTitleList = new ArrayList<>();

    public HomeAdapter(FragmentManager fm) {
        super(fm);
    }

    public void addDataList(List<BaseFragment> fragments, List<CharSequence> titles) {
        if (fragments != null && titles != null) {
            mFragmentList.clear();
            mTitleList.clear();

            mFragmentList.addAll(fragments);
            mTitleList.addAll(titles);
        }
        notifyDataSetChanged();
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mTitleList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitleList.get(position);
    }

    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }
}
