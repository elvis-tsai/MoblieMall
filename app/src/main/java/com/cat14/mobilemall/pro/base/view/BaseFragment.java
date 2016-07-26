package com.cat14.mobilemall.pro.base.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cat14.mobilemall.mvp.view.impl.MvpBaseFragment;
import com.cat14.mobilemall.pro.base.presenter.BasePresenter;

/**
 *
 */
public abstract class BaseFragment<P extends BasePresenter, V extends BaseView> extends MvpBaseFragment<P, V> {

    // 缓存视图
    private View contentView;
    private boolean isInit;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (contentView == null) {
            contentView = inflater.inflate(bindLayoutId(), container, false);
            initContentView(contentView);
        }

        ViewGroup parent = (ViewGroup) contentView.getParent();
        if (parent != null) {
            parent.removeView(contentView);
        }
        return contentView;
    }


    public View getContentView() {
        return contentView;
    }

    public void initData(){}

    @Override
    public P bindPresenter() {
        return null;
    }

    @Override
    public V bindView() {
        return null;
    }

    public abstract int bindLayoutId();
    public abstract void initContentView(View contentView);
}
