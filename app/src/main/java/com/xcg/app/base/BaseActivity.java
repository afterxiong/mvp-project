package com.xcg.app.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

/**
 * Created by xiongchengguang on 2018/6/20.
 */

public abstract class BaseActivity<V extends BaseView, P extends BasePresenter<V>> extends AppCompatActivity {
    protected P presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        presenter = createPresenter();
        presenter.attachView((V) this);
        initView();
    }

    protected abstract void initView();

    public abstract int getLayoutId();

    @Override
    protected void onResume() {
        super.onResume();
    }

    public abstract Toolbar getToolbar();

    public void initToolbar(){
        Toolbar toolbar=getToolbar();
        if(toolbar!=null){
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }

    public abstract P createPresenter();
}
