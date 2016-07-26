package com.cat14.mobilemall.mvp.view.impl;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.cat14.mobilemall.mvp.presenter.MvpPresenter;
import com.cat14.mobilemall.mvp.view.MvpView;

/**
 *
 */
public abstract class MvpBaseFragment<P extends MvpPresenter, V extends MvpView> extends Fragment implements MvpView {

    private P presenter;
    private V view;

    /**
     * 创建时绑定
     */
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = bindPresenter();
        if (presenter != null) {
            presenter.attachView(bindView());
        }
    }

    /**
     * 销毁时解绑
     */
    @Override
    public void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            presenter.dettachView();
        }
    }

    /**
     * 绑定具体的实现类
     */
    public abstract P bindPresenter();

    /**
     * 绑定我们具体的V
     */
    public abstract V bindView();
}
