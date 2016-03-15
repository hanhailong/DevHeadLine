package com.hhl.devheadline.ui.activity;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.hhl.devheadline.R;
import com.hhl.devheadline.presenter.BasePresenter;
import com.hhl.devheadline.ui.fragment.BaseFragment;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * The parent Activity of all activitys
 * Created by HanHailong on 16/3/14.
 */
public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements BaseFragment.OnFragmentInteractionListener {

    @Nullable
    @Bind(R.id.toolbar)
    protected Toolbar mToolbar;

    protected P mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentView());
        ButterKnife.bind(this);
        initPresenter();
        if (isNeedToolbar()) {
            initToolbar();
        }
    }

    /**
     * init presenter
     */
    private void initPresenter() {
        mPresenter = getPresenter();

        if (mPresenter == null) {
            throw new IllegalArgumentException("Presenter must not be null");
        }
    }

    /**
     * init toolbar
     */
    private void initToolbar() {
        if (mToolbar == null) {
            throw new IllegalArgumentException("Toolbar must not be null");
        }
        setSupportActionBar(mToolbar);
    }

    /**
     * get layout of activity
     *
     * @return
     */
    protected abstract int getContentView();

    /**
     * get the presenter class
     *
     * @return
     */
    protected abstract P getPresenter();

    /**
     * is or need toolbar
     *
     * @return
     */
    protected boolean isNeedToolbar() {
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            //不建议用finish
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
