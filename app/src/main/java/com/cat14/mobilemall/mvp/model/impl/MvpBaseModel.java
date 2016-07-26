package com.cat14.mobilemall.mvp.model.impl;

import android.content.Context;

import com.cat14.mobilemall.mvp.model.MvpModel;

/**
 *
 */
public abstract class MvpBaseModel implements MvpModel{

    private Context context;

    public MvpBaseModel(Context context) {
        this.context = context;
    }

    private Context getContext() {
        return context;
    }

}
