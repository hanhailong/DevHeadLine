package com.hhl.devheadline.core.net;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
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

    private static final OkHttpClient OK_HTTP_CLIENT = new OkHttpClient.Builder()
            .addInterceptor(new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    // TODO: (hhl) 拦截返回的结果
                    Response response = chain.proceed(chain.request());

                    // TODO: (hhl) 以后优化

                    return response;
                }
            }).build();

    public static ApiService getApiService() {
        return SingletonHolder.apiService;
    }

    /**
     * 采用精通内部类的方式来实现单例
     */
    private static class SingletonHolder {
        static Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(host)
//                .client(OK_HTTP_CLIENT)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.createWithScheduler(Schedulers.io()))
                .build();

        private static final ApiService apiService = retrofit.create(ApiService.class);
    }
}
