package com.hhl.devheadline.presenter;

import com.hhl.devheadline.model.Article;
import com.hhl.devheadline.model.Banner;
import com.hhl.devheadline.model.resp.ArticleResp;
import com.hhl.devheadline.model.resp.BannerResp;
import com.hhl.devheadline.ui.iview.IHomeChoiceView;

import java.util.List;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;

/**
 * Created by HanHailong on 16/3/16.
 */
public class HomeChoicePresenter extends BasePresenter<IHomeChoiceView> {

    public HomeChoicePresenter(IHomeChoiceView view) {
        super(view);
    }

    public void loadBanners() {
        mApiService.loadBannerList()
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Func1<BannerResp, List<Banner>>() {
                    @Override
                    public List<Banner> call(BannerResp bannerResp) {
                        return bannerResp.getData();
                    }
                })
                .subscribe(new Subscriber<List<Banner>>() {
                    @Override
                    public void onCompleted() {
                        mView.loadComplete();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.loadError(e);
                    }

                    @Override
                    public void onNext(List<Banner> list) {
                        mView.fillBannerData(list);
                    }
                });
    }

    public void loadArticleDataList() {
        mApiService.loadArticleList()
                .observeOn(AndroidSchedulers.mainThread())
                .filter(new Func1<ArticleResp, Boolean>() {
                    @Override
                    public Boolean call(ArticleResp articleResp) {
                        return articleResp != null &&
                                articleResp.getData() != null &&
                                articleResp.getData().getArticle() != null;
                    }
                })
                .map(new Func1<ArticleResp, ArticleResp.Data>() {
                    @Override
                    public ArticleResp.Data call(ArticleResp articleResp) {
                        return articleResp.getData();
                    }
                })
                .map(new Func1<ArticleResp.Data, List<Article>>() {
                    @Override
                    public List<Article> call(ArticleResp.Data data) {
                        return data.getArticle();
                    }
                })
                .subscribe(new Subscriber<List<Article>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(List<Article> list) {
                        mView.fillArticleList(list);
                    }
                });

    }
}
