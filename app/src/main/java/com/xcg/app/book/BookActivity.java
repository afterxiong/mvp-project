package com.xcg.app.book;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.xcg.app.R;
import com.xcg.app.base.BaseActivity;

/**
 * Created by xiongchengguang on 2018/6/20.
 */

public class BookActivity extends BaseActivity<BookContract.View, BookPresenter> implements BookContract.View {

    private TextView text;


    @Override
    public int getLayoutId() {
        return R.layout.activity_book;
    }


    @Override
    protected void initView() {
        text = findViewById(R.id.text);
        presenter.getData();
    }

    @Override
    public Toolbar getToolbar() {
        return null;
    }

    @Override
    public BookPresenter createPresenter() {
        return new BookPresenter();
    }

    @Override
    public void loading() {

    }

    @Override
    public void setData(String value) {
        text.setText(value);
    }

}
