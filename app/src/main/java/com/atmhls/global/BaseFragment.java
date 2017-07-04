package com.atmhls.global;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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


}
