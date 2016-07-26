package com.cat14.mobilemall.pro.buy.view;

import android.view.View;
import android.view.ViewGroup;

import com.cat14.mobilemall.R;
import com.cat14.mobilemall.pro.base.view.BaseFragment;
import com.cat14.mobilemall.pro.base.view.navigation.impl.AppNavigation;

/**
 *
 */
public class BuyFragment extends BaseFragment {
    @Override
    public int bindLayoutId() {
        return R.layout.fragment_buy;
    }

    @Override
    public void initContentView(View contentView) {
        AppNavigation.Builder builder = new AppNavigation.Builder(getActivity(),(ViewGroup) contentView);
        builder.setCenterTitleRes(R.string.tabbar_cart_text).create().build();
    }
}
