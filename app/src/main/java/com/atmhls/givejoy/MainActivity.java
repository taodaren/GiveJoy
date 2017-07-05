package com.atmhls.givejoy;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.atmhls.category.CategoryFragment;
import com.atmhls.enter.EnterFragment;
import com.atmhls.home.HomeFragment;
import com.atmhls.mine.MineFragment;

import me.majiajie.pagerbottomtabstrip.NavigationController;
import me.majiajie.pagerbottomtabstrip.PageBottomTabLayout;
import me.majiajie.pagerbottomtabstrip.listener.OnTabItemSelectedListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setBottomTab();
    }

    /**
     * 设置底部导航栏
     */
    private void setBottomTab() {
        //默认显示首页
        replaceFragment(new HomeFragment());

        //创建 Material 风格导航栏
        PageBottomTabLayout tab = (PageBottomTabLayout) findViewById(R.id.main_tab);
        NavigationController navController = tab.material()
                .addItem(R.mipmap.tab_home, "首页")
                .addItem(R.mipmap.tab_category, "附近店铺")
                .addItem(R.mipmap.tab_enter, "邀请入驻")
                .addItem(R.mipmap.tab_mine, "我的")
                .build();

        //监听导航栏的 Item 选中事件
        navController.addTabItemSelectedListener(new OnTabItemSelectedListener() {
            @Override
            public void onSelected(int index, int old) {
                //选中时触发
                switch (index) {
                    case 0:
                        replaceFragment(new HomeFragment());
                        break;
                    case 1:
                        replaceFragment(new CategoryFragment());
                        break;
                    case 2:
                        replaceFragment(new EnterFragment());
                        break;
                    case 3:
                        replaceFragment(new MineFragment());
                        break;
                }
            }

            @Override
            public void onRepeat(int index) {
                //重复选中时触发

            }
        });
    }

    /**
     * 切换 fragment
     *
     * @param fragment 待切换碎片
     */
    private void replaceFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.main_content, fragment)
                .commit();
    }

}
