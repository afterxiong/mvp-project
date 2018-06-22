package com.xcg.app.call;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;

/**
 * Created by xiongchengguang on 2018/6/7.
 */

public interface Api {

    @GET("v2/book/1220562")
    Observable<ResponseBody> getBooks();
}
