package com.hhl.devheadline.ui.iview;

import com.hhl.devheadline.model.Banner;

import java.util.List;

/**
 * Created by HanHailong on 16/3/16.
 */
public interface IHomeChoiceView extends IBaseView {

    /**
     * 填充Banner列表数据
     *
     * @param list
     */
    void fillBannerData(List<Banner> list);

    /**
     * 加载失败
     *
     * @param e
     */
    void loadError(Throwable e);

    /**
     * 加载完成
     */
    void loadComplete();

}
