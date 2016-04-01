package com.hhl.devheadline.presenter;

import com.hhl.devheadline.core.net.ApiService;
import com.hhl.devheadline.core.net.RetrofitFactory;
import com.hhl.devheadline.ui.iview.IBaseView;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/**
 * the base presenter of all presenters
 * if you use a presenter,it must be extends {@link BasePresenter}
 * Created by HanHailong on 16/3/15.
 */
public abstract class BasePresenter<V extends IBaseView> {

    private Reference<V> mViewRef;
    protected V mView;

    protected static final ApiService mApiService = RetrofitFactory.getApiService();

    public BasePresenter(V view) {
        mViewRef = new WeakReference<V>(view);
        this.mView = mViewRef.get();
    }

    /**
     * 解除presenter与view的关联
     */
    public void detachView() {
        if (mViewRef != null) {
            mViewRef.clear();
            mViewRef = null;
        }
    }

}
