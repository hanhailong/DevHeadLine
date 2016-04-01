package com.hhl.devheadline.model.resp;

import com.hhl.devheadline.model.Banner;

import java.util.List;

/**
 * Created by HanHailong on 16/3/16.
 */
public class BannerResp extends BaseResp {

    private List<Banner> data;

    public List<Banner> getData() {
        return data;
    }

    public void setData(List<Banner> data) {
        this.data = data;
    }
}
