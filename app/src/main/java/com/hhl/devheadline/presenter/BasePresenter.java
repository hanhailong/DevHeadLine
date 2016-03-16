package com.hhl.devheadline.presenter;

import com.hhl.devheadline.core.net.ApiService;
import com.hhl.devheadline.core.net.RetrofitFactory;
import com.hhl.devheadline.ui.iview.IBaseView;

/**
 * the base presenter of all presenters
 * if you use a presenter,it must be extends {@link BasePresenter}
 * Created by HanHailong on 16/3/15.
 */
public abstract class BasePresenter<V extends IBaseView> {

    protected V mView;

    protected static final ApiService mApiService = RetrofitFactory.getApiService();

    public BasePresenter(V view) {
        this.mView = view;
    }
}
