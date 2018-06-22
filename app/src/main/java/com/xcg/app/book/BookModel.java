package com.xcg.app.book;

import com.xcg.app.call.Api;
import com.xcg.app.call.RetrofitProvider;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;

/**
 * Created by xiongchengguang on 2018/6/20.
 */

public class BookModel {
    Api api = RetrofitProvider.get().getApiService(Api.class);

    public void getBookData(final BookPresenter.onResultListener listener) {
        api.getBooks()
                .delay(10, TimeUnit.SECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Consumer<ResponseBody>() {
                    @Override
                    public void accept(ResponseBody responseBody) throws Exception {
                        String string = responseBody.string();
                        listener.result(string);
                    }
                });
    }

    public void getResponseBook(final BookPresenter.OnResponseListener listener) {
        api.getBooks()
                .delay(10, TimeUnit.SECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Consumer<ResponseBody>() {
                    @Override
                    public void accept(ResponseBody responseBody) throws Exception {
                        String string = responseBody.string();
                        listener.checkDestory(string);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        listener.error(throwable);
                    }
                });
    }
}
