package com.atmhls.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.atmhls.givejoy.R;
import com.atmhls.global.BaseFragment;
import com.atmhls.global.I;
import com.atmhls.global.LoginActivity;

/**
 * 首页模块
 */

public class HomeFragment extends BaseFragment {

    @Override
    public View initView() {
        View inflate = View.inflate(getContext(), R.layout.fragment_home, null);
        setWebView(inflate);
        return inflate;
    }

    private void setWebView(View view) {
        final WebView webView = (WebView) view.findViewById(R.id.web_home);
        webView.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
                //按下返回键并且 webView 界面可以返回
                if ((keyCode == KeyEvent.KEYCODE_BACK) && webView.canGoBack()) {
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            webView.goBack();
                        }
                    });
                    return true;
                }
                return false;
            }
        });
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(I.TAB_HOME);
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
            //模拟测试登陆（借用）
            startActivity(new Intent(getContext(), LoginActivity.class));
        }
        return true;
    }

}
