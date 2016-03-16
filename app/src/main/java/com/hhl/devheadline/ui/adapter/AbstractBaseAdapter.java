package com.hhl.devheadline.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

/**
 * //TODO 简单封装 {@link android.support.v7.widget.RecyclerView.Adapter}
 * 防止冗余代码
 * Created by HanHailong on 16/3/16.
 */
public abstract class AbstractBaseAdapter extends RecyclerView.Adapter {

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
