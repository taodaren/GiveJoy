package com.atmhls.enter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.atmhls.givejoy.R;
import com.atmhls.global.BaseFragment;

/**
 * 邀请入驻
 */

public class EnterFragment extends BaseFragment {

    @Override
    public View initView() {
        View inflate = View.inflate(getContext(), R.layout.fragment_enter, null);
        setWebView(inflate);
        return inflate;
    }

    private void setWebView(View inflate) {
        WebView webView = (WebView) inflate.findViewById(R.id.web_enter);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://www.baidu.com/");
    }

    /**
     * 在 onActivityCreated 方法中初始化 Toolbar
     */
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setToolbar(R.id.toolbar_enter, R.string.enter_name, View.GONE);
    }

}
