package com.atmhls.category;

import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.atmhls.givejoy.R;
import com.atmhls.global.BaseFragment;

/**
 * 附近店铺模块
 */

public class CategoryFragment extends BaseFragment {

    @Override
    public View initView() {
        View inflate = View.inflate(getContext(), R.layout.fragment_category, null);
        setWebView(inflate);
        return inflate;
    }

    private void setWebView(View inflate) {
        WebView webView = (WebView) inflate.findViewById(R.id.web_category);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("http://stormzhang.com/posts/");
    }

}
