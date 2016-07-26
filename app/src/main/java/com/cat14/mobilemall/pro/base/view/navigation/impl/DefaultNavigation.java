package com.cat14.mobilemall.pro.base.view.navigation.impl;

import android.view.View;
import android.widget.LinearLayout;

import com.cat14.mobilemall.R;


/**
 * 默认ToolBar框架（左中右型）
 */
public abstract class DefaultNavigation<P extends AbsNavigation.NavigationParams> extends AbsNavigation<P>{

    public DefaultNavigation(P params){
        super(params);
    }

    @Override
    public int bindLayoutId() {
        return R.layout.navigation_default;
    }

    @Override
    public void build() {
        super.build();
        //初始化布局
        LinearLayout ll_left = (LinearLayout) findViewById(R.id.ll_left);
        LinearLayout ll_center = (LinearLayout) findViewById(R.id.ll_center);
        LinearLayout ll_right = (LinearLayout) findViewById(R.id.ll_right);

        //绑定子布局
        bindParent(bindLeftLayoutId(),ll_left);
        bindParent(bindCenterLayoutId(),ll_center);
        bindParent(bindRightLayoutId(),ll_right);

        //初始化子布局
        initLeftLayout(ll_left);
        initCenterLayout(ll_center);
        initRightLayout(ll_right);
    }


    // ------------------------ 绑定子布局 ---------------------------

    public abstract int bindLeftLayoutId();

    public abstract int bindCenterLayoutId();

    public abstract int bindRightLayoutId();


    // ------------------------ 初始化子布局 -------------------------

    public abstract void initLeftLayout(View view);

    public abstract void initCenterLayout(View view);

    public abstract void initRightLayout(View view);

}
