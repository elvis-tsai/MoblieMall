package com.cat14.mobilemall.mvp.presenter;

import com.cat14.mobilemall.mvp.view.MvpView;

/**
 * 中介：实现View的绑定和解绑
 */
public interface MvpPresenter<V extends MvpView> {

    void attachView(V view);

    void dettachView();
}
