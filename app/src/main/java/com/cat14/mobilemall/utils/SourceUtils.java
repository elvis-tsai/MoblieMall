package com.cat14.mobilemall.utils;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;

import com.cat14.mobilemall.MallApp;

/**
 * 资源工具类
 */
public class SourceUtils {

    /**
     * 复用时只需更改这里
     */
    public static Context getContext() {
        return MallApp.getContext();
    }


    // --------------------------------------------------------------

    public static String getString(int id) {
        return getContext().getResources().getString(id);
    }
    public static String[] getStringArray(int id) {
        return getContext().getResources().getStringArray(id);
    }

    public static Drawable getDrawablw(int id) {
        return getContext().getResources().getDrawable(id);
    }

    public static int getColor(int id) {
        return getContext().getResources().getColor(id);
    }

    public static ColorStateList getColorStateList(int id) {
        return getContext().getResources().getColorStateList(id);
    }

    public static int getDimen(int id) {
        // 返回具体像素值
        return getContext().getResources().getDimensionPixelOffset(id);
    }
}
