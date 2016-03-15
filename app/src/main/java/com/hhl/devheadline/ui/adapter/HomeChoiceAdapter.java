package com.hhl.devheadline.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hhl.devheadline.R;

/**
 * Created by HanHailong on 16/3/16.
 */
public class HomeChoiceAdapter extends RecyclerView.Adapter {
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ChoiceViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.view_home_choice_item
                , parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 30;
    }

    public static class ChoiceViewHolder extends RecyclerView.ViewHolder {

        public ChoiceViewHolder(View itemView) {
            super(itemView);
        }
    }
}
