package com.cat14.mobilemall;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import com.cat14.mobilemall.libs.indicator.CircleIndicator;
import com.cat14.mobilemall.utils.DisplayUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 引导页面
 */
public class GuideActivity extends Activity implements View.OnClickListener {

    private List<Integer> imageList;
    private List<ImageView> imageViewList;
    private Button btn_guide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);

        initGuideData();        // 初始化数据
        initGuideView();        // 添加ImageView
        initView();             //
    }

    /**
     * 初始化图片数据
     */
    private void initGuideData() {
        imageList = new ArrayList<>();
        imageList.add(R.mipmap.apk_img1);
        imageList.add(R.mipmap.apk_img2);
        imageList.add(R.mipmap.apk_img3);
    }

    /**
     * 初始化每个页面
     */
    private void initGuideView() {
        imageViewList = new ArrayList<>();

        for (int i = 0; i < imageList.size(); i++) {
            ImageView iv = new ImageView(this);
            imageViewList.add(iv);
        }
    }

    /**
     * 初始化分页控件
     */
    private void initView() {
        // 隐藏状态栏
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        btn_guide = (Button) findViewById(R.id.btn_guide);
        btn_guide.setOnClickListener(this);
        ViewPager vp_guide = (ViewPager) findViewById(R.id.vp_guide);
        vp_guide.setAdapter(new GuideAdapter());

        CircleIndicator indicator_guide = (CircleIndicator) findViewById(R.id.indicator_guide);
        indicator_guide.setViewPager(vp_guide);
    }

    @Override
    public void onClick(View view) {
        startActivity(new Intent(GuideActivity.this, MainActivity.class));
        SharedPreferences sp = getSharedPreferences("config", MODE_PRIVATE);
        sp.edit().putBoolean("FirstEnter", false).apply();
        finish();
    }

    /**
     * 定义适配器（填充数据）
     */
    private class GuideAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return imageList.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            // 确定当前分页是不是一个视图
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            // 绑定分页
            ImageView imageView = imageViewList.get(position);
            imageView.setImageResource(imageList.get(position));

            // 根据屏幕适配
            ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(
                    DisplayUtils.getDisplayWidth(GuideActivity.this),
                    DisplayUtils.getDisplayHeight(GuideActivity.this));
            container.addView(imageView, params);
            return imageView;
        }

        @Override
        public void setPrimaryItem(View container, int position, Object object) {
            if (position == imageList.size() -1) {
                btn_guide.setVisibility(View.VISIBLE);
            } else {
                btn_guide.setVisibility(View.GONE);
            }
            super.setPrimaryItem(container, position, object);
        }

        @Override
        public int getItemPosition(Object object) {
            return super.getItemPosition(object);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            // 清理内存
            container.removeView(imageViewList.get(position));
        }
    }
}
