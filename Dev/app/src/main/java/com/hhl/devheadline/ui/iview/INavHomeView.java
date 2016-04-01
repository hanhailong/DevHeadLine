package com.hhl.devheadline.ui.iview;

import com.hhl.devheadline.ui.fragment.BaseFragment;

import java.util.List;

/**
 * Created by HanHailong on 16/3/15.
 */
public interface INavHomeView extends IBaseView {

    void loadTabData(List<BaseFragment> list, List<CharSequence> titles);

}
