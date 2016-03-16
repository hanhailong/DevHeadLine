package com.hhl.devheadline.presenter;

import com.hhl.devheadline.model.resp.BannerResp;
import com.hhl.devheadline.ui.iview.IHomeChoiceView;

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
                .filter(new Func1<BannerResp, Boolean>() {
                    @Override
                    public Boolean call(BannerResp bannerResp) {
                        return bannerResp.getData() != null && bannerResp.getData().size() > 0;
                    }
                })
                .subscribe(new Subscriber<BannerResp>() {
                    @Override
                    public void onCompleted() {
                        mView.loadComplete();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.loadError(e);
                    }

                    @Override
                    public void onNext(BannerResp bannerResp) {
                        mView.fillBannerData(bannerResp.getData());
                    }
                });
    }
}
