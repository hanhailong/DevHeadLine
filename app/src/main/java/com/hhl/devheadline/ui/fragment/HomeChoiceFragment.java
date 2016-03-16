package com.hhl.devheadline.ui.fragment;

import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.hhl.devheadline.R;
import com.hhl.devheadline.presenter.HomeChoicePresenter;
import com.hhl.devheadline.ui.adapter.HomeChoiceAdapter;
import com.hhl.devheadline.ui.iview.IHomeChoiceView;
import com.hhl.devheadline.ui.view.DHLSwipeRefreshLayout;

import butterknife.Bind;

/**
 * Created by HanHailong on 16/3/15.
 */
public class HomeChoiceFragment extends BaseFragment<HomeChoicePresenter> implements IHomeChoiceView {

    @Bind(R.id.swipe_refresh_layout)
    DHLSwipeRefreshLayout mSwipeRefreshLayout;
    @Bind(R.id.recyclerview)
    RecyclerView mRecyclerView;

    @Override
    protected int getContentView() {
        return R.layout.fragment_home_choice;
    }

    @Override
    protected HomeChoicePresenter getPresenter() {
        return new HomeChoicePresenter(this);
    }

    @Override
    protected void init(View view) {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setAdapter(new HomeChoiceAdapter());

        //TODO
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //TODO
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mSwipeRefreshLayout.setRefreshing(false);
                    }
                }, 2000);
            }
        });
    }
}
