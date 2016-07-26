package com.cat14.mobilemall;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ImageView;

/**
 * 欢迎界面
 */
public class WelcomeActivity extends Activity {

    private ImageView iv_welcome;
    private boolean firstEnter = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        initView();
        initAnimator();
    }


    /**
     * 属性动画启动
     */
    private void initAnimator() {
        ObjectAnimator animator = ObjectAnimator.ofFloat(iv_welcome, "alpha", 0.2f, 1.0f);
        animator.setDuration(2000);
        animator.start();
        animator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                firstEnter = getSharedPreferences("config", MODE_PRIVATE).getBoolean("FirstEnter", true);
                enterMainActivity();
            }
        });
    }

    /**
     * 初始化视图
     */
    private void initView() {
        // 隐藏状态栏
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        iv_welcome = (ImageView) findViewById(R.id.iv_welcome);
    }

    /**
     * 进入下一个页面
     */
    private void enterMainActivity() {
        if (firstEnter) {
            startActivity(new Intent(WelcomeActivity.this, GuideActivity.class));
            finish();
        } else {
            startActivity(new Intent(WelcomeActivity.this, MainActivity.class));
            finish();
        }

    }
}
