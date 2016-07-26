package com.cat14.mobilemall.pro.base.view.navigation.impl;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.cat14.mobilemall.R;
import com.cat14.mobilemall.pro.base.view.navigation.INavigation;


/**
 *
 */
public class AppNavigation extends DefaultNavigation<AppNavigation.AppNavigationParams>{

    public AppNavigation(AppNavigationParams p){
        super(p);
    }

    //第三步:实现具体的功能

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
        return R.layout.navigation_default_right;
    }

    @Override
    public void initLeftLayout(View view) {
        ImageView iv_default_left = (ImageView) view.findViewById(R.id.iv_default_left);
        if (getParams().leftImageRes == 0){
            iv_default_left.setVisibility(View.GONE);
        }else {
            iv_default_left.setVisibility(View.VISIBLE);
            iv_default_left.setImageResource(getParams().leftImageRes);
            iv_default_left.setOnClickListener(getParams().leftOnClickListener);
        }
    }

    @Override
    public void initCenterLayout(View view) {
        TextView tv_default_center = (TextView) view.findViewById(R.id.tv_default_center);
        if (getParams().centerTitleRes == 0){
            tv_default_center.setVisibility(View.GONE);
        }else {
            tv_default_center.setVisibility(View.VISIBLE);
            tv_default_center.setText(getString(getParams().centerTitleRes));
        }
    }

    @Override
    public void initRightLayout(View view) {
        ImageView iv_default_right = (ImageView) view.findViewById(R.id.iv_default_right);
        if (getParams().rightImageRes == 0){
            iv_default_right.setVisibility(View.GONE);
        }else {
            iv_default_right.setVisibility(View.VISIBLE);
            iv_default_right.setImageResource(getParams().rightImageRes);
            iv_default_right.setOnClickListener(getParams().rightOnClickListener);
        }
    }

    //第一步:定义builder参数集
    public static class AppNavigationParams extends AbsNavigation.NavigationParams{

        public int leftImageRes;
        public int centerTitleRes;
        public int rightImageRes;

        public View.OnClickListener leftOnClickListener;
        public View.OnClickListener rightOnClickListener;

        public AppNavigationParams(Context context, ViewGroup parent){
            super(context,parent);
        }

    }


    //第二步:构建我们Toolbar
    public static class Builder extends AbsNavigation.Builder{

        private AppNavigationParams p;

        public Builder(Context context,ViewGroup parent){
            super(context,parent);
            this.p = new AppNavigationParams(context,parent);
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
            return new AppNavigation(this.p);
        }
    }

}
