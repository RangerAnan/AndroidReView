package com.review.android.webview;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.qsmaxmin.qsbase.common.viewbind.annotation.Bind;
import com.qsmaxmin.qsbase.common.viewbind.annotation.OnClick;
import com.qsmaxmin.qsbase.mvp.QsABActivity;
import com.qsmaxmin.qsbase.mvp.QsActivity;
import com.review.android.R;

/**
 * Created by fcl on 19.1.9
 * desc:
 */

public class WebViewActivity extends QsActivity {

    @Bind(R.id.webView)
    WebView webView;


    @Override
    public int layoutId() {
        return R.layout.activity_webview;
    }


    @Override
    public void initData(Bundle savedInstanceState) {


        webView.loadUrl("https://www.baidu.com/");
    }

//    @Override
//    @OnClick({R.id.tv_title_back})
//    public void onViewClick(View view) {
//        switch (view.getId()) {
//            case R.id.tv_title_back:
//                break;
//            default:
//                break;
//        }
//
//    }
}
