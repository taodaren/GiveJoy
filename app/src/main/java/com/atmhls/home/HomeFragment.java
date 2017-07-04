package com.atmhls.home;

import android.view.View;

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

}
