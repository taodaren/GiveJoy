package com.atmhls.mine;

import android.view.View;

import com.atmhls.givejoy.R;
import com.atmhls.global.BaseFragment;

/**
 * 我的模块
 */

public class MineFragment extends BaseFragment {

    @Override
    public View initView() {
        View inflate = View.inflate(getContext(), R.layout.fragment_mine, null);
        return inflate;
    }

}
