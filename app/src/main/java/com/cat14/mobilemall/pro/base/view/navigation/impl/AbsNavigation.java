package com.cat14.mobilemall.pro.base.view.navigation.impl;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import com.cat14.mobilemall.pro.base.view.navigation.INavigation;


/**
 * 抽象实现类
 */
public abstract class AbsNavigation<P extends AbsNavigation.NavigationParams> implements INavigation {

    public static final int DEFAULT_LAYOUT_ID = 0;  // 默认布局0

    private P params;                               // 参数
    private View contentView;                       // 缓存

    public AbsNavigation(P params) {
        this.params = params;
    }


    // Params基类，根据具体子类实现
    public static class NavigationParams {
        public Context context;
        public ViewGroup parent;
        public LayoutInflater inflater;

        public NavigationParams(Context context, ViewGroup parent) {
            this.context = context;
            this.parent = parent;
            this.inflater = LayoutInflater.from(context);
        }
    }

    // Builder类构建UI
    public abstract static class Builder {
        public Builder(Context context, ViewGroup parent) {}

        public abstract INavigation create();
    }

    @Override
    public int bindLayoutId() {
        return DEFAULT_LAYOUT_ID;
    }

    @Override
    public void build() {
        if (contentView == null){
            contentView = bindParent(bindLayoutId(),getParams().parent);
        }
    }

    public View bindParent(int layoutId, ViewGroup parent) {
        if (layoutId == DEFAULT_LAYOUT_ID) {
            return null;
        }
        View layout = getParams().inflater.inflate(layoutId, parent,false);
        return bindParent(layout, parent);
    }

    public View bindParent(View childView, ViewGroup parent) {
        // 子容器只能有一个父容器
        ViewParent viewParent = childView.getParent();
        if (viewParent != null) {
            ViewGroup viewGroup = (ViewGroup) viewParent;
            viewGroup.removeView(childView);
        }
        parent.addView(childView, 0);
        return childView;
    }

    public P getParams() {
        return params;
    }

    public View getContentView() {
        return contentView;
    }

    public View findViewById(int id){
        return contentView.findViewById(id);
    }

    public String getString(int id){
        return params.context.getResources().getString(id);
    }

}
