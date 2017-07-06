package com.atmhls.home;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
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
        setHasOptionsMenu(true);

        initTitle(inflate);
        return inflate;
    }

    private void initTitle(View inflate) {
        setToolbar(R.id.toolbar_home);
        //设置标题
        TextView textTitle = (TextView) inflate.findViewById(R.id.title_toolbar);
        textTitle.setVisibility(View.VISIBLE);
        textTitle.setText(R.string.home_name);

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.toolbar, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.qr_code:
                Toast.makeText(mContext, "1245", Toast.LENGTH_SHORT).show();
                break;
            case R.id.five_star:
                Toast.makeText(mContext, "124", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }

}
