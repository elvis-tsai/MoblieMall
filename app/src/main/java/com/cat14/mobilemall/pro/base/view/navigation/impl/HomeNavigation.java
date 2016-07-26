package com.cat14.mobilemall.pro.base.view.navigation.impl;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.cat14.mobilemall.R;
import com.cat14.mobilemall.pro.base.view.navigation.INavigation;


/**
 * Home页具体实现
 */
public class HomeNavigation extends DefaultNavigation<HomeNavigation.HomeNavigationParams>{

    public HomeNavigation(HomeNavigationParams p){
        super(p);
    }

    // 定义参数
    public static class HomeNavigationParams extends AbsNavigation.NavigationParams{

        public int leftImageRes;
        public int centerTitleRes;
        public int rightImageRes;
        public int rightTextRes;

        public View.OnClickListener leftOnClickListener;
        public View.OnClickListener rightOnClickListener;

        public HomeNavigationParams(Context context, ViewGroup parent){
            super(context,parent);
        }

    }

    // 设置资源
    public static class Builder extends AbsNavigation.Builder{

        private HomeNavigationParams p;

        public Builder(Context context,ViewGroup parent){
            super(context,parent);
            this.p = new HomeNavigationParams(context,parent);
        }

        public Builder setLeftImageRes(int leftImageRes){
            this.p.leftImageRes = leftImageRes;
            return this;
        }

        public Builder setCenterTitleRes(int centerTitleRes){
            this.p.centerTitleRes = centerTitleRes;
            return this;
        }

        public Builder setRightImageRes(int rightImageRes){
            this.p.rightImageRes = rightImageRes;
            return this;
        }

        public Builder setRightTextRes(int rightTextRes){
            this.p.rightTextRes = rightTextRes;
            return this;
        }

        public Builder setLeftOnClickListener(View.OnClickListener leftOnClickListener){
            this.p.leftOnClickListener = leftOnClickListener;
            return this;
        }

        public Builder setRightOnClickListener(View.OnClickListener rightOnClickListener){
            this.p.rightOnClickListener = rightOnClickListener;
            return this;
        }

        @Override
        public INavigation create() {
            return new HomeNavigation(this.p);
        }
    }

    // -------------------------- 子布局实现 --------------------------------

    @Override
    public int bindLeftLayoutId() {
        return R.layout.navigation_default_left;
    }

    @Override
    public int bindCenterLayoutId() {
        return R.layout.navigation_default_center;
    }

    @Override
    public int bindRightLayoutId() {
        return R.layout.navigation_home_right;
    }

    // ------------------------ 初始化子布局控件------------------------------

    @Override
    public void initLeftLayout(View view) {
        ImageView iv_default_left = (ImageView) view.findViewById(R.id.iv_default_left);
        iv_default_left.setImageResource(getParams().leftImageRes);
        iv_default_left.setOnClickListener(getParams().leftOnClickListener);
    }

    @Override
    public void initCenterLayout(View view) {
        TextView tv_default_center = (TextView) view.findViewById(R.id.tv_default_center);
        tv_default_center.setText(getString(getParams().centerTitleRes));
    }

    @Override
    public void initRightLayout(View view) {
        TextView tv_home_right = (TextView) view.findViewById(R.id.tv_home_right);
        tv_home_right.setText(getString(getParams().rightTextRes));
        ImageView iv_home_right = (ImageView) view.findViewById(R.id.iv_home_right);
        iv_home_right.setBackgroundResource(getParams().rightImageRes);
        view.setOnClickListener(getParams().rightOnClickListener);

        AnimationDrawable animationDrawable = (AnimationDrawable) iv_home_right.getBackground();
        animationDrawable.start();
    }



}
