package com.atmhls.givejoy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import me.majiajie.pagerbottomtabstrip.NavigationController;
import me.majiajie.pagerbottomtabstrip.PageBottomTabLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setBottomTab();
    }

    private void setBottomTab() {
        PageBottomTabLayout tab = (PageBottomTabLayout) findViewById(R.id.tab);
        NavigationController navController = tab.material()
                .addItem(R.mipmap.tab_home, "首页")
                .addItem(R.mipmap.tab_category, "附近店铺")
                .addItem(R.mipmap.tab_enter, "邀请入驻")
                .addItem(R.mipmap.tab_mine, "我的")
                .build();
    }
}
