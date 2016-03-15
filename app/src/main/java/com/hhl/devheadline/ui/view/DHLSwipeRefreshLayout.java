package com.hhl.devheadline.ui.view;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.AttributeSet;

/**
 * Created by HanHailong on 16/3/15.
 */
public class DHLSwipeRefreshLayout extends SwipeRefreshLayout {

    public DHLSwipeRefreshLayout(Context context) {
        super(context);
        init(context);
    }

    public DHLSwipeRefreshLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        setColorSchemeColors(android.R.color.holo_red_light);
    }
}
