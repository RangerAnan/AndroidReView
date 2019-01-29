package com.review.android.main;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.alibaba.android.arouter.launcher.ARouter;
import com.qsmaxmin.qsbase.common.aspect.ThreadPoint;
import com.qsmaxmin.qsbase.common.aspect.ThreadType;
import com.qsmaxmin.qsbase.common.utils.QsHelper;
import com.qsmaxmin.qsbase.common.viewbind.annotation.OnClick;
import com.qsmaxmin.qsbase.mvp.QsActivity;
import com.review.android.R;
import com.qsmaxmin.qsbase.aop.TestAnnoTrace;
import com.review.android.ipc.aidl.AIDLTestActivity;
import com.review.android.ipc.contentprovider.BookProviderActivity;
import com.review.android.media.fingerprint.FingerPrintActivity;
import com.review.android.view.event.TestScrollActivity;
import com.review.android.webview.WebViewActivity;

public class MainActivity extends QsActivity {


    @Override
    public int layoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initData(Bundle bundle) {

    }

    @Override
    @OnClick({R.id.btn_aidl, R.id.btn_fingerPrint, R.id.btn_provider, R.id.btn_scroll, R.id.btn_view_module
            , R.id.btn_webview, R.id.btn_aspect})
    public void onViewClick(View view) {
        switch (view.getId()) {
            case R.id.btn_aidl:
                QsHelper.getInstance().intent2Activity(AIDLTestActivity.class);
                break;
            case R.id.btn_fingerPrint:
                QsHelper.getInstance().intent2Activity(FingerPrintActivity.class);
                break;
            case R.id.btn_provider:
                QsHelper.getInstance().intent2Activity(BookProviderActivity.class);
                break;
            case R.id.btn_scroll:
                QsHelper.getInstance().intent2Activity(TestScrollActivity.class);
                break;
            case R.id.btn_view_module:
                ARouter.getInstance().build("/view/MainViewActivity").navigation();
                break;
            case R.id.btn_webview:
//                ARouter.getInstance().build("/view/WebViewActivity").navigation();
                QsHelper.getInstance().intent2Activity(WebViewActivity.class);
                break;
            case R.id.btn_aspect:
                Log.i(initTag(), "threadName:" + Thread.currentThread().getName());
                calcSum();
                break;
            default:
                break;
        }
    }

    public void calcSum() {
        int sum = 0;
        for (int i = 0; i < 10000; i++) {
            sum = sum + i;
        }
        Log.i(initTag(), "--calcSum--sum:" + sum + ";" + Thread.currentThread().getName());
    }
}
