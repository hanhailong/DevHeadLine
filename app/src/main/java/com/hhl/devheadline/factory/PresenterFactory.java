package com.hhl.devheadline.factory;

import com.hhl.devheadline.presenter.BasePresenter;
import com.hhl.devheadline.ui.iview.IBaseView;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

/**
 * presenter工厂
 * Created by jia.wei on 16/3/17.
 */
public class PresenterFactory<V extends IBaseView, P extends BasePresenter<V>> {

    private Reference<V> mViewRef;
    private V mView;
    Map<String , BasePresenter> mPresenters = null;

    public PresenterFactory(V view) {
        mPresenters = new HashMap<>();

        mViewRef = new WeakReference<V>(view);
        mView = mViewRef.get();
    }

    /**
     * 创建presenter
     * @param classes Presenter.class
     */
    @SafeVarargs
    public final void createPresenter(Class<P>... classes) {
        for (Class clz : classes) {
            try {
                if (clz != null) {
                    Constructor[] constructors = clz.getConstructors();
                    BasePresenter presenter = (BasePresenter) constructors[0].newInstance(mView);
                    mPresenters.put(clz.getName(), presenter);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 获取presenter
     * @param className Presenter.class.getName()
     * @return BasePresenter的实例
     */
    public BasePresenter getPresenter(String className) {
        BasePresenter presenter = null;

        if (mPresenters != null) {
            presenter = mPresenters.get(className);
        }
        return presenter;
    }

    /**
     * 解除presenterFactory与view的关联
     */
    public void detachView() {
        if (mViewRef != null) {
            mViewRef.clear();
            mViewRef = null;
        }
    }

}
