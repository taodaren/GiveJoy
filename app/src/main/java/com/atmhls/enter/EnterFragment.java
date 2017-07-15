package com.atmhls.enter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.atmhls.givejoy.R;
import com.atmhls.global.BaseFragment;
import com.atmhls.global.I;

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

    private void setWebView(View view) {
        final WebView webView = (WebView) view.findViewById(R.id.web_enter);
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
        webView.loadUrl(I.TAB_ENTER);
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
