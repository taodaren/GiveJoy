package com.atmhls.enter;


import android.view.View;

import com.atmhls.givejoy.R;
import com.atmhls.global.BaseFragment;

/**
 * 邀请入驻
 */

public class EnterFragment extends BaseFragment {

    @Override
    public View initView() {
        View inflate = View.inflate(getContext(), R.layout.fragment_enter, null);
        return inflate;
    }

}
