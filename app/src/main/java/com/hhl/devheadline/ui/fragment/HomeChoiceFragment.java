package com.hhl.devheadline.ui.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.holder.Holder;
import com.bigkoo.convenientbanner.listener.OnItemClickListener;
import com.facebook.drawee.view.SimpleDraweeView;
import com.hhl.devheadline.R;
import com.hhl.devheadline.model.Article;
import com.hhl.devheadline.model.Banner;
import com.hhl.devheadline.presenter.HomeChoicePresenter;
import com.hhl.devheadline.ui.adapter.HomeChoiceAdapter;
import com.hhl.devheadline.ui.iview.IHomeChoiceView;
import com.hhl.devheadline.ui.view.DHLSwipeRefreshLayout;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import cn.iwgang.familiarrecyclerview.FamiliarRecyclerView;

/**
 * Created by HanHailong on 16/3/15.
 */
public class HomeChoiceFragment extends BaseFragment<HomeChoicePresenter> implements IHomeChoiceView {

    @Bind(R.id.swipe_refresh_layout)
    DHLSwipeRefreshLayout mSwipeRefreshLayout;
    @Bind(R.id.recyclerview)
    FamiliarRecyclerView mRecyclerView;

    private ConvenientBanner<Banner> mBannerV;

    private HomeChoiceAdapter mAdapter;

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

        mBannerV = (ConvenientBanner) View.inflate(getActivity(), R.layout.view_home_banner, null);
        mRecyclerView.addHeaderView(mBannerV);

        mAdapter = new HomeChoiceAdapter(getActivity());
        mRecyclerView.setAdapter(mAdapter);
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

        mPresenter.loadBanners();

        mPresenter.loadArticleDataList();
        mSwipeRefreshLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                mSwipeRefreshLayout.setRefreshing(true);
            }
        }, 100);
    }

    @Override
    public void fillBannerData(List<Banner> list) {

        mBannerV.setPages(new CBViewHolderCreator<BannerViewHolder>() {
            @Override
            public BannerViewHolder createHolder() {
                return new BannerViewHolder();
            }
        }, list).setPageIndicator(new int[]{R.drawable.ic_banner_indicator_unselected
                , R.drawable.ic_banner_indicator_selected})
                .setOnItemClickListener(new OnItemClickListener() {
                    @Override
                    public void onItemClick(int position) {
                        Toast.makeText(getActivity(), "你点击了" + position, Toast.LENGTH_LONG).show();
                    }
                });
    }

    private static class BannerViewHolder implements Holder<Banner> {

        private SimpleDraweeView mImageView;
        private TextView mTextView;

        @Override
        public View createView(Context context) {
            View view = LayoutInflater.from(context).inflate(R.layout.view_banner_item, null);
            mImageView = ButterKnife.findById(view, R.id.sdv_image);
            mTextView = ButterKnife.findById(view, R.id.tv_title);
            return view;
        }

        @Override
        public void UpdateUI(Context context, int position, Banner data) {
            if (data != null) {
                mImageView.setImageURI(Uri.parse(data.getImage()));
                mTextView.setText(data.getTitle());
            }
        }
    }

    @Override
    public void loadError(Throwable e) {
        Toast.makeText(getActivity(), e.toString(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loadComplete() {
        //TODO
        mSwipeRefreshLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                mSwipeRefreshLayout.setRefreshing(false);
            }
        }, 1000);
        ;
    }

    @Override
    public void fillArticleList(List<Article> list) {
        mAdapter.addDataList(list);
    }

    @Override
    public void onResume() {
        super.onResume();
        mBannerV.startTurning(3000);
    }

    @Override
    public void onPause() {
        super.onPause();
        mBannerV.stopTurning();
    }
}
