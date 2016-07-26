package com.cat14.mobilemall.mvp.presenter.impl;

import android.content.Context;

import com.cat14.mobilemall.mvp.presenter.MvpPresenter;
import com.cat14.mobilemall.mvp.view.MvpView;

/**
 * 实现绑定View
 */
public abstract class MvpBasePresenter<V extends MvpView> implements MvpPresenter<V> {

    private Context context;
    private V view;

    public MvpBasePresenter(Context context) {
        this.context = context;
    }

    public Context getContext() {
        return context;
    }

    public V getView() {
        return view;
    }

    @Override
    public void attachView(V view) {
        this.view = view;
    }

    @Override
    public void dettachView() {
        this.view = null;
    }
}
