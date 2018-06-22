package com.xcg.app.book;

import com.socks.library.KLog;

/**
 * Created by xiongchengguang on 2018/6/20.
 */

public class BookPresenter extends BookContract.Presenter {

    private BookModel model;

    public BookPresenter() {
        model = new BookModel();
    }

    public abstract class OnResponseListener {
        public void checkDestory(Object obj) {
            if (isViewAttached()) {
                response(obj);
            }else{
                KLog.d("View已经被销毁了");
            }
        }

        public void error(Throwable e){
            e.printStackTrace();
        }

        public abstract void response(Object obj);
    }

    @Override
    public void getData() {
        model.getResponseBook(new OnResponseListener(){

            @Override
            public void response(Object obj) {
                getView().setData((String) obj);
            }
        });
    }
}
