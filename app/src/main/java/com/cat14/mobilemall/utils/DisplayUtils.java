package com.cat14.mobilemall.utils;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;

/**
 * 展示工具类
 * <p/>
 * 作用：
 * 屏幕测量
 * 像素转换
 */
public class DisplayUtils {

    public static int getDisplayWidth(Activity activity) {
        DisplayMetrics metric = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(metric);
        int width = metric.widthPixels;     // 屏幕宽度（像素）
        return width;
    }

    public static int getDisplayHeight(Activity activity) {
        DisplayMetrics metric = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(metric);
        int height = metric.heightPixels;     // 屏幕高度（像素）
        return height;
    }


    /**
     * 将px值转换为dip或dp值，保证尺寸大小不变
     *
     * @param context 通过上下文获得显示参数中的屏幕密度
     * @param pxValue 需要转换的px值
     * @return
     */
    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }


    /**
     * 将dip或dp值转换为px值，保证尺寸大小不变
     *
     * @param context  通过上下文获得显示参数中的屏幕密度
     * @param dipValue 需要转换的dp值
     * @return
     */
    public static int dip2px(Context context, float dipValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }


    /**
     * 将px值转换为sp值，保证文字大小不变
     *
     * @param context 通过上下文获得显示参数中的屏幕密度
     * @param pxValue 需要转换的px值
     * @return
     */
    public static int px2sp(Context context, float pxValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (pxValue / fontScale + 0.5f);
    }


    /**
     * 将sp值转换为px值，保证文字大小不变
     *
     * @param context 通过上下文获得显示参数中的屏幕密度
     * @param spValue 需要转换的sp值
     * @return
     */
    public static int sp2px(Context context, float spValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale + 0.5f);
    }
}
