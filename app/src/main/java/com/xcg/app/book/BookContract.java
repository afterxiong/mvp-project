package com.xcg.app.book;

import com.xcg.app.base.BasePresenter;
import com.xcg.app.base.BaseView;

/**
 * Created by xiongchengguang on 2018/6/20.
 */

public interface BookContract {
    public interface View extends BaseView {
        void loading();

        void setData(String value);
    }

    public abstract class Presenter extends BasePresenter<View> {
        abstract void getData();
    }

}
