package com.xcg.app.base;

import com.socks.library.KLog;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/**
 * Created by xiongchengguang on 2018/6/8.
 */

public abstract class BasePresenter<V extends BaseView> {
    public Reference<V> reference;

    public void attachView(V view) {
        reference = new WeakReference<V>(view);
    }

    protected V getView() {
        return reference.get();
    }

    public boolean isViewAttached() {
        return reference != null && reference.get() != null;
    }

    public void detachView() {
        if (reference != null) {
            reference.clear();
            reference = null;
        }
    }

}
