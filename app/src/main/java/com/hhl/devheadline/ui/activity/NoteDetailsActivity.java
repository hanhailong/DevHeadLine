package com.hhl.devheadline.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.net.http.SslError;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.hhl.devheadline.R;
import com.hhl.devheadline.presenter.NoteDetailsPresenter;
import com.hhl.devheadline.ui.iview.INoteDetailsView;
import com.hhl.devheadline.utils.AppTools;
import com.hhl.devheadline.utils.ToastUtils;

import butterknife.Bind;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2016/3/29.
 */
public class NoteDetailsActivity extends BaseActivity<NoteDetailsPresenter> implements INoteDetailsView {

    private static final String ORIGINAL_URL = "original_url";

    @Bind(R.id.details_bar)
    ProgressBar progressBar;
    @Bind(R.id.details_webview)
    WebView webView;
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.notedetails_llbottom)
    RelativeLayout relativeLayout;
    @Bind(R.id.text_name)
    TextView textView;
    String loadingUrl;
    String title;
    Animation showAnim, dismissAnim;
    float downY = 0, offsetY = 0;

    /**
     * 启动{@link NoteDetailsActivity}
     *
     * @param context
     */
    public static void launch(Context context, String url) {
        Intent intent = new Intent(context, NoteDetailsActivity.class);
        intent.putExtra(ORIGINAL_URL, url);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        setSupportActionBar(toolbar);
        initVIew();
    }

    private void initVIew() {
        Observable.just(getResources().getString(R.string.notedetail_text_name)).map(new Func1<String, SpannableString>() {
            @Override
            public SpannableString call(String s) {
                SpannableString spanabelInfo = new SpannableString(s);
                int lenth = s.indexOf(getResources().getString(R.string.notedetail_hal));
                spanabelInfo.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.colorPrimary)),
                        lenth, lenth + getResources().getString(R.string.notedetail_halgyf).length() + 1,
                        Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                return spanabelInfo;
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).
                subscribe(new Action1<SpannableString>() {
                    @Override
                    public void call(SpannableString spanableInfo) {
                        textView.setText(spanableInfo);
                    }
                });
        showAnim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.bottom_show);
        dismissAnim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.bottom_dismiss);
        WebSettings webSettings = webView.getSettings();
        //先加载文字后加载图片
        if (Build.VERSION.SDK_INT >= 19) {
            webSettings.setLoadsImagesAutomatically(true);
        } else {
            webSettings.setLoadsImagesAutomatically(false);
        }
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDefaultTextEncodingName("UTF-8");
        webSettings.setSupportZoom(false);
        webSettings.setUseWideViewPort(false);
//		webSettings.setBlockNetworkImage(true);
//		if (Build.VERSION.SDK_INT < 19) {
//			webSettings.setLayoutAlgorithm(LayoutAlgorithm.SINGLE_COLUMN);
//		}
        webSettings.setLoadWithOverviewMode(true);
        webView.setWebViewClient(new MyWebViewClient());
        webView.setWebChromeClient(new MyWebChromeClient());
        loadingUrl = getIntent().getStringExtra(ORIGINAL_URL);
        webView.loadUrl(loadingUrl);
        webView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        downY = (int) event.getY();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        int moveY = (int) event.getY();
                        offsetY = moveY - downY;
                        downY = moveY;
                        break;
                    case MotionEvent.ACTION_UP:
                        if (offsetY < 0) {
                            onScrollToBottom();
                        } else {
                            onScrollToTop();
                        }
                        break;
                }
                return false;
            }
        });

    }

    @Override
    protected int getContentView() {
        return R.layout.activity_notedetails;
    }

    @Override
    protected NoteDetailsPresenter getPresenter() {
        return new NoteDetailsPresenter(this);
    }

    class MyWebChromeClient extends WebChromeClient {

        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            if (newProgress == 100) {
                progressBar.setVisibility(View.GONE);
            } else {
                if (progressBar.getVisibility() == View.GONE) {
                    progressBar.setVisibility(View.VISIBLE);
                }
                if (newProgress > progressBar.getProgress()) {
                    progressBar.setProgress(newProgress);
                }
            }
            // TODO Auto-generated method stub
            super.onProgressChanged(view, newProgress);
        }

        @Override
        public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
            result.confirm();
            ToastUtils.toast(message);
            return true;
        }

        @Override
        public boolean onJsConfirm(WebView view, String url, String message, JsResult result) {
            result.confirm();
            return super.onJsConfirm(view, url, message, result);
        }

        @Override
        public boolean onJsPrompt(WebView view, String url, String message, String defaultValue, JsPromptResult result) {
            result.confirm();
            return super.onJsPrompt(view, url, message, message, result);
        }

        @Override
        public void onReceivedTitle(WebView view, String title) {
            super.onReceivedTitle(view, title);
            toolbar.setTitle(AppTools.clipLongText(title));
            // 保存标题
            NoteDetailsActivity.this.title = title;
        }
    }

    public class MyWebViewClient extends WebViewClient {

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            return super.shouldOverrideUrlLoading(view, url);
        }

        @Override
        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
            super.onReceivedError(view, errorCode, description, failingUrl);
        }

        @Override
        public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
            // TODO Auto-generated method stub
            handler.proceed();
            super.onReceivedSslError(view, handler, error);
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            //接触数据绑定
            view.getSettings().setBlockNetworkImage(false);
            //先加载文字在加载图片
            if (!webView.getSettings().getLoadsImagesAutomatically()) {
                webView.getSettings().setLoadsImagesAutomatically(true);
            }
            super.onPageFinished(view, url);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_notedetail_toolsbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    public void onScrollToTop() {
        if (!relativeLayout.isShown()) {
            relativeLayout.clearAnimation();
            relativeLayout.startAnimation(showAnim);
            relativeLayout.setVisibility(View.VISIBLE);
        }
    }

    public void onScrollToBottom() {
        if (relativeLayout.isShown()) {
            relativeLayout.clearAnimation();
            relativeLayout.startAnimation(dismissAnim);
            relativeLayout.setVisibility(View.GONE);
        }
    }
}
