package com.review.android.main;

import android.os.Bundle;
import android.view.View;

import com.qsmaxmin.qsbase.common.utils.QsHelper;
import com.qsmaxmin.qsbase.common.viewbind.annotation.OnClick;
import com.qsmaxmin.qsbase.mvp.QsActivity;
import com.review.android.R;
import com.review.android.ipc.aidl.AIDLTestActivity;
import com.review.android.ipc.contentprovider.BookProviderActivity;
import com.review.android.media.fingerprint.FingerPrintActivity;
import com.review.android.view.event.TestScrollActivity;

public class MainActivity extends QsActivity {


    @Override
    public int layoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initData(Bundle bundle) {

    }

    @Override
    @OnClick({R.id.btn_aidl, R.id.btn_fingerPrint, R.id.btn_provider, R.id.btn_scroll})
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
            default:
                break;
        }
    }
}
