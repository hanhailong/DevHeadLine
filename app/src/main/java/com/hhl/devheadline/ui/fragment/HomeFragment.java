package com.hhl.devheadline.ui.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.hhl.devheadline.R;
import com.hhl.devheadline.presenter.NavHomePresenter;
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

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
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
