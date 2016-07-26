package com.cat14.mobilemall.mvp.view.impl;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.cat14.mobilemall.mvp.presenter.MvpPresenter;
import com.cat14.mobilemall.mvp.view.MvpView;

/**
 *
 */
public abstract class MvpBaseActivity<P extends MvpPresenter, V extends MvpView>
        extends AppCompatActivity implements MvpView {

    private P presenter;
    private V view;

    /**
     * 创建Activity添加绑定
     */
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = bindPresenter();
        if (presenter != null) {
            presenter.attachView(bindView());
        }
    }

    /**
     * 销毁Activity时解除绑定
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            presenter.dettachView();
            presenter = null;
        }
    }

    /**
     * 绑定具体实现类
     */
    public abstract P bindPresenter();

    /**
     * 绑定具体实现类
     */
    public abstract V bindView();
}
