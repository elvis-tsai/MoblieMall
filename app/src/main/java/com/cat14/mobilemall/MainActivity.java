package com.cat14.mobilemall;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;

import com.cat14.mobilemall.libs.menu.SlidingMenu;
import com.cat14.mobilemall.pro.base.view.BaseActivity;
import com.cat14.mobilemall.pro.buy.view.BuyFragment;
import com.cat14.mobilemall.pro.home.view.HomeFragment;
import com.cat14.mobilemall.pro.mine.view.MineFragment;
import com.cat14.mobilemall.pro.tata.view.TataFragment;
import com.cat14.mobilemall.utils.DisplayUtils;
import com.cat14.mobilemall.utils.SourceUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 主页面
 * <p/>
 * 业务层面：
 * 展示具体内容
 * <p/>
 * 技术层面：
 * SlidingMenu 实现侧边栏
 * FragmentTabHost 实现下方Tab
 */
public class MainActivity extends BaseActivity implements TabHost.OnTabChangeListener {

    private SlidingMenu slidingMenu;
    private List<MenuItem> menuItemList;
    private List<TabItem> tabItemList;
    private FragmentTabHost fragmentTabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initSlidingMenuData();      // 初始化Menu数据
        initSlidingMenu();          // 初始化SlidingMenu
        initSlidingMenuLayout();    // 初始化Menu布局

        initTabItemData();          // 初始化Tab数据
        initTabHost();              // 初始化TabHost

    }

    // -----------------------  FragmentTabHost部分  -------------------------

    private void initTabHost() {
        fragmentTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
        fragmentTabHost.setup(this, getSupportFragmentManager(), android.R.id.tabcontent);
        fragmentTabHost.getTabWidget().setDividerDrawable(null);

        for (int i = 0; i < tabItemList.size(); i++) {
            TabItem tabItem = tabItemList.get(i);
            TabHost.TabSpec tabSpec = fragmentTabHost.
                    newTabSpec(tabItem.getTitleStr()).
                    setIndicator(tabItem.getIndicator());
            fragmentTabHost.addTab(tabSpec, tabItem.fragmentClass, null);
            fragmentTabHost.getTabWidget().setBackgroundColor(Color.WHITE);
            fragmentTabHost.setOnTabChangedListener(this);

            if (i == 0) {
                tabItem.setChecked(true);
            }
        }
    }

    private void initTabItemData() {
        tabItemList = new ArrayList<>();
        tabItemList.add(new TabItem(
                R.mipmap.apk_bottom_ic_first,
                R.mipmap.apk_bottom_ic_first_up,
                R.string.tabbar_home_text,
                HomeFragment.class));
        tabItemList.add(new TabItem(
                R.mipmap.apk_bottom_ic_tata,
                R.mipmap.apk_bottom_ic_tata_up,
                R.string.tabbar_tata_text,
                TataFragment.class));
        tabItemList.add(new TabItem(
                R.mipmap.apk_bottom_ic_buy,
                R.mipmap.apk_bottom_ic_buy_up,
                R.string.tabbar_cart_text,
                BuyFragment.class));
        tabItemList.add(new TabItem(
                R.mipmap.apk_bottom_ic_mine,
                R.mipmap.apk_bottom_ic_mine_up,
                R.string.tabbar_mine_text,
                MineFragment.class));
    }

    @Override
    public void onTabChanged(String s) {
        for (int i = 0; i < tabItemList.size(); i++) {
            TabItem tabItem = tabItemList.get(i);
            if (tabItem.getTitleStr().equals(s)) {
                tabItem.setChecked(true);
            } else {
                tabItem.setChecked(false);
            }

        }
    }

    private class TabItem {
        public int tabImageNormalRes;
        public int tabImagePressRes;
        public int tabTextRes;
        public Class<? extends Fragment> fragmentClass;
        public View view;
        private TextView tv_tab;
        private ImageView iv_tab;

        public TabItem(int tabImageNormalRes, int tabImagePressRes, int tabTextRes, Class<? extends Fragment> fragmentClass) {
            this.tabImageNormalRes = tabImageNormalRes;
            this.tabImagePressRes = tabImagePressRes;
            this.tabTextRes = tabTextRes;
            this.fragmentClass = fragmentClass;
        }

        public String getTitleStr() {
            return SourceUtils.getString(tabTextRes);
        }

        public View getIndicator() {
            view = getLayoutInflater().inflate(R.layout.tab_indicator, null);
            tv_tab = (TextView) view.findViewById(R.id.tv_tab);
            tv_tab.setText(getTitleStr());
            iv_tab = (ImageView) view.findViewById(R.id.iv_tab);
            iv_tab.setImageResource(tabImageNormalRes);
            return view;
        }

        public void setChecked(boolean isChecked) {
            if (isChecked) {
                iv_tab.setImageResource(tabImagePressRes);
                tv_tab.setTextColor(SourceUtils.getColor(R.color.tabbar_text_press_color));
            } else {
                iv_tab.setImageResource(tabImageNormalRes);
                tv_tab.setTextColor(SourceUtils.getColor(R.color.tabbar_text_normal_color));
            }
        }
    }

    // -----------------------  SlidingMenu部分  -------------------------

    private void initSlidingMenuData() {
        menuItemList = new ArrayList<>();
        menuItemList.add(new MenuItem("女装"));
        menuItemList.add(new MenuItem("女装"));
        menuItemList.add(new MenuItem("女装"));
        menuItemList.add(new MenuItem("女装"));
        menuItemList.add(new MenuItem("女装"));

    }

    private void initSlidingMenu() {
        slidingMenu = new SlidingMenu(this);
        slidingMenu.setMode(0);
        slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        slidingMenu.setShadowWidth(DisplayUtils.dip2px(this, 200));
        slidingMenu.setBehindOffset(DisplayUtils.dip2px(this, 200));
        slidingMenu.setFadeDegree(0.3f);
        slidingMenu.setBackgroundColor(getResources().getColor(android.R.color.darker_gray));
        slidingMenu.attachToActivity(this, SlidingMenu.SLIDING_WINDOW);
    }

    private void initSlidingMenuLayout() {
        View menuLayout = getLayoutInflater().inflate(R.layout.menu_layout, null);
        slidingMenu.setMenu(menuLayout);

        ListView lv_menu = (ListView) menuLayout.findViewById(R.id.lv_menu);
        lv_menu.setAdapter(new MenuAdapter());
    }

    private class MenuAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return menuItemList.size();
        }

        @Override
        public Object getItem(int i) {
            return menuItemList.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder holder = null;
            if (view == null) {
                view = getLayoutInflater().inflate(R.layout.menu_item, viewGroup, false);
                holder = new ViewHolder((ViewGroup) view);
                view.setTag(holder);
            } else {
                holder = (ViewHolder) view.getTag();
            }
            holder.tv_menu_title.setText(menuItemList.get(i).menuText);
            return view;
        }

        class ViewHolder {
            TextView tv_menu_title;

            public ViewHolder(ViewGroup contentView) {
                this.tv_menu_title = (TextView) contentView.findViewById(R.id.tv_menu_title);
            }
        }
    }

    private class MenuItem {
        public String menuText;

        public MenuItem(String menuText) {
            this.menuText = menuText;
        }
    }

    // --------------------------- 其他 ----------------------------

    public SlidingMenu getSlidingMenu() {
        return slidingMenu;
    }
}
