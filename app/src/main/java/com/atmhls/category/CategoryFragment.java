package com.atmhls.category;

import android.view.View;

import com.atmhls.givejoy.R;
import com.atmhls.global.BaseFragment;

/**
 * 附近店铺模块
 */

public class CategoryFragment extends BaseFragment {

    @Override
    public View initView() {
        View inflate = View.inflate(getContext(), R.layout.fragment_category, null);
        return inflate;
    }

}
