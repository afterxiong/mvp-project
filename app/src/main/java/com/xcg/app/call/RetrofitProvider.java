package com.xcg.app.call;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by xiongchengguang on 2018/6/7.
 */

public class RetrofitProvider {
    private static final String BASE_URL = "https://api.douban.com";
    private static final long TIMEOUT = 30;
    private Retrofit retrofit;

    private RetrofitProvider() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(initClient())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    private OkHttpClient initClient() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(TIMEOUT, TimeUnit.SECONDS);
        builder.readTimeout(TIMEOUT, TimeUnit.SECONDS);
        return builder.build();
    }

    private static class RetrofitHolder {
        private static RetrofitProvider holder = new RetrofitProvider();
    }

    public static RetrofitProvider get() {
        return RetrofitHolder.holder;
    }

    public <T> T getApiService(Class<T> t) {
        return retrofit.create(t);
    }
}
