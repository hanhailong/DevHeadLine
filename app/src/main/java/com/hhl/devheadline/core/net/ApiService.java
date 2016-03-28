package com.hhl.devheadline.core.net;

import com.hhl.devheadline.model.resp.ArticleResp;
import com.hhl.devheadline.model.resp.BannerResp;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by HanHailong on 16/3/16.
 */
public interface ApiService {

    /**
     * 获取Banner列表
     */
    @GET("banner?app_key=u1ntgkc99st7sdhqjo5p&timestamp=1458135621&signature=de53ae34c31ce857ea881102a100c7fb2d76aa36")
    Observable<BannerResp> loadBannerList();

    @GET("dailies/latest?app_key=u1ntgkc99st7sdhqjo5p&timestamp=1458230053&signature=0eeb89c7d2355de81c007d74869d9567e39210f2")
    Observable<ArticleResp> loadArticleList();
}
