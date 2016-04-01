package com.hhl.devheadline.core.net;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.schedulers.Schedulers;

/**
 * Created by HanHailong on 16/3/16.
 */
public class RetrofitFactory {

    /**
     * 开发者头条BaseUrl
     */
    private static final String host = "http://api.toutiao.io/v2/";

    private static final Gson gson = new GsonBuilder()
            .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ").serializeNulls()
            .create();

    public static ApiService getApiService() {
        return SingletonHolder.apiService;
    }

    /**
     * 采用精通内部类的方式来实现单例
     */
    private static class SingletonHolder {
        static Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(host)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.createWithScheduler(Schedulers.io()))
                .build();

        private static final ApiService apiService = retrofit.create(ApiService.class);
    }
}
