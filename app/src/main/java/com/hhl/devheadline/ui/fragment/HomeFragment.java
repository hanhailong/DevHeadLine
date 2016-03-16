package com.hhl.devheadline.ui.fragment;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.hhl.devheadline.R;
import com.hhl.devheadline.presenter.NavHomePresenter;
import com.hhl.devheadline.ui.activity.MainActivity;
import com.hhl.devheadline.ui.adapter.HomeAdapter;
import com.hhl.devheadline.ui.iview.INavHomeView;

import java.util.List;

import butterknife.Bind;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link HomeFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends BaseFragment<NavHomePresenter> implements INavHomeView {

    @Bind(R.id.toolbar)
    Toolbar mToolbar;
    @Bind(R.id.tab_layout)
    TabLayout mTabLayout;
    @Bind(R.id.viewpager)
    ViewPager mViewPager;

    private HomeAdapter mHomeAdapter;

    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    protected int getContentView() {
        return R.layout.fragment_home;
    }

    @Override
    protected NavHomePresenter getPresenter() {
        return new NavHomePresenter(this);
    }

    @Override
    protected void init(View view) {
        mToolbar.setTitle(R.string.app_name);
        mToolbar.inflateMenu(R.menu.menu_home);
        mToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_add:
                        break;
                    case R.id.action_search:
                        break;
                }
                return false;
            }
        });

        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = new Uri.Builder().scheme(MainActivity.SCHEME_OPEN_MENU).build();
                mListener.onFragmentInteraction(uri);
            }
        });

        mHomeAdapter = new HomeAdapter(getChildFragmentManager());
        mViewPager.setAdapter(mHomeAdapter);

        mTabLayout.setupWithViewPager(mViewPager);

        initData();
    }

    private void initData() {
        mPresenter.initTabLayout();
    }


    @Override
    public void loadTabData(List<BaseFragment> list, List<CharSequence> titles) {
        mHomeAdapter.addDataList(list, titles);
    }
}
