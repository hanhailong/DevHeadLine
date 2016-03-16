package com.hhl.devheadline.ui.fragment;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.hhl.devheadline.R;
import com.hhl.devheadline.presenter.NavSharePresenter;
import com.hhl.devheadline.ui.activity.MainActivity;
import com.hhl.devheadline.ui.iview.INavShareView;
import com.hhl.devheadline.ui.view.DHLSwipeRefreshLayout;

import butterknife.Bind;

/**
 * A fragment with a Google +1 button.
 * Activities that contain this fragment must implement the
 * {@link ShareFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ShareFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ShareFragment extends BaseFragment<NavSharePresenter> implements INavShareView {

    @Bind(R.id.toolbar)
    Toolbar mToolbar;

    //TODO 将下拉刷新封装一下
    @Bind(R.id.swipe_refresh_layout)
    DHLSwipeRefreshLayout mSwipeRefreshLayout;

    @Bind(R.id.recyclerview)
    RecyclerView mRecyclerView;

    public static ShareFragment newInstance() {
        ShareFragment fragment = new ShareFragment();
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
        return R.layout.fragment_share;
    }

    @Override
    protected NavSharePresenter getPresenter() {
        return new NavSharePresenter(this);
    }

    @Override
    protected void init(View view) {
        mToolbar.setTitle(R.string.nav_share);
        mToolbar.setNavigationIcon(R.drawable.ic_menu_white_24dp);
        mToolbar.inflateMenu(R.menu.menu_add_share);
        mToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
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

    }

}
