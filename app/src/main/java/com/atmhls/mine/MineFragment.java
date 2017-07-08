package com.atmhls.mine;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.atmhls.givejoy.R;
import com.atmhls.global.BaseFragment;

/**
 * 我的模块
 */

public class MineFragment extends BaseFragment implements View.OnClickListener {

    @Override
    public View initView() {
        View inflate = View.inflate(getContext(), R.layout.fragment_mine, null);
        setClickListener(inflate);
        return inflate;
    }

    /**
     * 在 onActivityCreated 方法中初始化 Toolbar
     */
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setToolbar(R.id.toolbar_mine, R.string.mine_name, View.GONE);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        //显示菜单
        inflater.inflate(R.menu.menu_toolbar, menu);
        //显示需要菜单项，隐藏多余菜单项
        menu.findItem(R.id.menu_qr_code).setVisible(false);
        menu.findItem(R.id.menu_star).setVisible(false);
        menu.findItem(R.id.menu_change).setVisible(true);
        menu.findItem(R.id.menu_more).setVisible(false);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu_change) {
            //弹出对话框切换商家版
            AlertDialog.Builder dialog = new AlertDialog.Builder(getContext());
            dialog.setMessage("是否切换到商家版")
                    .setCancelable(false)
                    .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(mContext, "切换到商家", Toast.LENGTH_SHORT).show();

                        }
                    })
                    .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    })
                    .show();
        }
        return true;
    }

    private void setClickListener(View inflate) {
        inflate.findViewById(R.id.img_avatar).setOnClickListener(this);
        inflate.findViewById(R.id.qian_bao_mine).setOnClickListener(this);
        inflate.findViewById(R.id.yao_qing_ma_mine).setOnClickListener(this);
        inflate.findViewById(R.id.yao_qing_mine).setOnClickListener(this);
        inflate.findViewById(R.id.msg_mine).setOnClickListener(this);
        inflate.findViewById(R.id.zhong_chou_mine).setOnClickListener(this);
        inflate.findViewById(R.id.quan_shu_mine).setOnClickListener(this);
        inflate.findViewById(R.id.quit_mine).setOnClickListener(this);
        inflate.findViewById(R.id.set_mine).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img_avatar:
                Toast.makeText(mContext, "img_avatar", Toast.LENGTH_SHORT).show();
                break;
            case R.id.qian_bao_mine:
                Toast.makeText(mContext, "qian_bao_mine", Toast.LENGTH_SHORT).show();
                break;
            case R.id.yao_qing_ma_mine:
                Toast.makeText(mContext, "yao_qing_ma_mine", Toast.LENGTH_SHORT).show();
                break;
            case R.id.yao_qing_mine:
                Toast.makeText(mContext, "yao_qing_mine", Toast.LENGTH_SHORT).show();
                break;
            case R.id.msg_mine:
                Toast.makeText(mContext, "msg_mine", Toast.LENGTH_SHORT).show();
                break;
            case R.id.zhong_chou_mine:
                Toast.makeText(mContext, "zhong_chou_mine", Toast.LENGTH_SHORT).show();
                break;
            case R.id.quan_shu_mine:
                Toast.makeText(mContext, "quan_shu_mine", Toast.LENGTH_SHORT).show();
                break;
            case R.id.quit_mine:
                Toast.makeText(mContext, "quit_mine", Toast.LENGTH_SHORT).show();
                break;
            case R.id.set_mine:
                Toast.makeText(mContext, "set_mine", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
