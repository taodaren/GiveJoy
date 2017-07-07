package com.atmhls.global;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.atmhls.givejoy.R;

/**
 * Fragment 基类
 */

public abstract class BaseFragment extends Fragment {
    public Context mContext;

    /**
     * 当该类被系统创建的时候回调
     */
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();

        // 加上这句话，menu才会显示出来
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return initView();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    /**
     * 抽象类，由子类实现，实现不同的效果
     */
    public abstract View initView();

    /**
     * 当子类需要联网请求数据的时候，可以重写该方法，该方法中联网请求
     */
    public void initData() {
    }

    /**
     * 设置 Toolbar
     *
     * @param toolbarId      menu_toolbar ID
     * @param title          标题
     * @param cityVisibility 城市选择控件是否显示
     * @return menu_toolbar
     */
    public Toolbar setToolbar(int toolbarId, int title, int cityVisibility) {
        AppCompatActivity appCompatActivity = (AppCompatActivity) getActivity();
        Toolbar toolbar = (Toolbar) appCompatActivity.findViewById(toolbarId);
        appCompatActivity.setSupportActionBar(toolbar);

        //设置标题
        TextView textTitle = (TextView) getActivity().findViewById(R.id.title_toolbar);
        textTitle.setVisibility(View.VISIBLE);
        textTitle.setText(title);

        //城市选择
        RelativeLayout cityLayout = (RelativeLayout) getActivity().findViewById(R.id.layout_city);
        cityLayout.setVisibility(cityVisibility);

        ActionBar actionBar = appCompatActivity.getSupportActionBar();
        if (actionBar != null) {
            //隐藏左上角图标（true 为显示）
            actionBar.setDisplayHomeAsUpEnabled(false);
            //隐藏 Toolbar 自带标题栏
            actionBar.setDisplayShowTitleEnabled(false);
        }
        return toolbar;
    }

}
