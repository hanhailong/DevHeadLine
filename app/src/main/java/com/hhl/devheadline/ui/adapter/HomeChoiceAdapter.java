package com.hhl.devheadline.ui.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.hhl.devheadline.R;
import com.hhl.devheadline.model.Article;
import com.hhl.devheadline.ui.activity.NoteDetailsActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by HanHailong on 16/3/16.
 */
public class HomeChoiceAdapter extends RecyclerView.Adapter<HomeChoiceAdapter.ChoiceViewHolder> {

    private final List<Article> dataList = new ArrayList<>();
    private Context context;

    public HomeChoiceAdapter(Context context) {
        this.context = context;
    }

    public void addDataList(List<Article> list) {
        addDataList(list, false);
    }

    public void addDataList(List<Article> list, boolean append) {
        if (list != null) {
            if (!append) {
                dataList.clear();
            }
            dataList.addAll(list);
        }
        notifyDataSetChanged();
    }

    @Override
    public ChoiceViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ChoiceViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.view_home_choice_item
                , parent, false));
    }

    @Override
    public void onBindViewHolder(final ChoiceViewHolder holder, final int position) {
        holder.bindData(dataList.get(position));
        holder.itemView.setClickable(true);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NoteDetailsActivity.launch(context, dataList.get(position).getOriginal_url());
            }
        });

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public static class ChoiceViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.tv_title)
        TextView mTitleTv;
        @Bind(R.id.tv_where)
        TextView mWhereTv;
        @Bind(R.id.tv_comment)
        TextView mCommentTv;
        @Bind(R.id.tv_like)
        TextView mLikeTv;
        @Bind(R.id.sdv_avatar)
        SimpleDraweeView mIconSdv;

        public ChoiceViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bindData(Article article) {
            if (article == null) return;
            try {
                mTitleTv.setText(article.getTitle());
                mWhereTv.setText("选自 " + article.getSubject().getName());
                mIconSdv.setImageURI(Uri.parse(article.getUser().getAvatar()));
                mLikeTv.setText(article.getLike_count() + "");
                mCommentTv.setText(article.getComment_count() + "");
            } catch (Exception e) {
                //TODO 日志处理 ，待优化
            }
        }
    }
}
