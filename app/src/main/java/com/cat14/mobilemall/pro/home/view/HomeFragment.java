package com.cat14.mobilemall.pro.home.view;

import android.view.View;
import android.view.ViewGroup;

import com.cat14.mobilemall.MainActivity;
import com.cat14.mobilemall.R;
import com.cat14.mobilemall.libs.menu.SlidingMenu;
import com.cat14.mobilemall.pro.base.view.BaseFragment;
import com.cat14.mobilemall.pro.base.view.navigation.impl.HomeNavigation;
import com.cat14.mobilemall.utils.ToastUtil;

/**
 *
 */
public class HomeFragment extends BaseFragment {

    private MainActivity mainActivity;
    private boolean enable;

    @Override
    public int bindLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    public void initContentView(View contentView) {
        enable = true;
        mainActivity = (MainActivity) getActivity();
        initNavigation(contentView);
    }
    private void initNavigation(View contentView){
        HomeNavigation.Builder builder = new HomeNavigation.Builder(getActivity(),(ViewGroup) contentView);
        builder.setLeftImageRes(R.mipmap.apk_all_top_nav)
                .setCenterTitleRes(R.string.tabbar_home_text)
                .setRightTextRes(R.string.nav_sign_in)
                .setRightImageRes(R.drawable.anim_sign_coin)
                .setLeftOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
//                        setSlidingMenuEnable(enable);
                    }
                })
                .setRightOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ToastUtil.showToast(getContext(),"点击右边");
                    }
                }).create().build();
    }

    private void setSlidingMenuEnable(boolean enable) {
        SlidingMenu slidingMenu = mainActivity.getSlidingMenu();
        if (!enable) {
            slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
            enable = false;
        } else {
            slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_NONE);
            enable = true;
        }
    }
}