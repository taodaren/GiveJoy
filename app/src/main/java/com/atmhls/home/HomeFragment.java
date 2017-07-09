package com.atmhls.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.atmhls.givejoy.R;
import com.atmhls.global.BaseFragment;

/**
 * 首页模块
 */

public class HomeFragment extends BaseFragment {

    @Override
    public View initView() {
        View inflate = View.inflate(getContext(), R.layout.fragment_home, null);
        return inflate;
    }

    /**
     * 在 onActivityCreated 方法中初始化 Toolbar
     */
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setToolbar(R.id.toolbar_home, R.string.home_name, View.VISIBLE);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        //显示菜单
        inflater.inflate(R.menu.menu_toolbar, menu);
        //显示需要菜单项，隐藏多余菜单项
        menu.findItem(R.id.menu_qr_code).setVisible(true);
        menu.findItem(R.id.menu_star).setVisible(false);
        menu.findItem(R.id.menu_change).setVisible(false);
        menu.findItem(R.id.menu_more).setVisible(false);
        menu.findItem(R.id.menu_register).setVisible(false);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu_qr_code) {
            Toast.makeText(mContext, "跳转到二维码", Toast.LENGTH_SHORT).show();
        }
        return true;
    }

}
