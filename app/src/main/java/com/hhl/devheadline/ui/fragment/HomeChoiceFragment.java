package com.hhl.devheadline.ui.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.hhl.devheadline.R;
import com.hhl.devheadline.presenter.HomeChoicePresenter;
import com.hhl.devheadline.ui.adapter.HomeChoiceAdapter;
import com.hhl.devheadline.ui.iview.IHomeChoiceView;

import butterknife.Bind;

/**
 * Created by HanHailong on 16/3/15.
 */
public class HomeChoiceFragment extends BaseFragment<HomeChoicePresenter> implements IHomeChoiceView {

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
    }
}
