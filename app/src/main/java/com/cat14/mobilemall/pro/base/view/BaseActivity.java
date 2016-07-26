package com.cat14.mobilemall.pro.base.view;

import android.app.Activity;
import android.content.Intent;
import android.widget.Toast;

import com.cat14.mobilemall.mvp.view.impl.MvpBaseActivity;
import com.cat14.mobilemall.pro.base.presenter.BasePresenter;

/**
 *
 */
public abstract class BaseActivity<P extends BasePresenter, V extends BaseView> extends MvpBaseActivity<P, V> {

    /**
     * 简化Toast
     */
    protected void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    /**
     * 简化页面跳转
     */
    protected void startActivity(Class<? extends Activity> clz) {
        startActivity(new Intent(BaseActivity.this, clz));
    }

    @Override
    public P bindPresenter() {
        return null;
    }

    @Override
    public V bindView() {
        return null;
    }
}
