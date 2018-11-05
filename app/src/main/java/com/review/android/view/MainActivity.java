package com.review.android.view;

import android.os.Bundle;
import android.view.View;
import com.qsmaxmin.qsbase.common.utils.QsHelper;
import com.qsmaxmin.qsbase.common.viewbind.annotation.OnClick;
import com.qsmaxmin.qsbase.mvp.QsActivity;
import com.review.android.R;
import com.review.android.ipc.AIDLTestActivity;

public class MainActivity extends QsActivity {


    @Override
    public int layoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initData(Bundle bundle) {

    }

    @Override
    @OnClick(R.id.btn_aidl)
    public void onViewClick(View view) {
        switch (view.getId()) {
            case R.id.btn_aidl:
                QsHelper.getInstance().intent2Activity(AIDLTestActivity.class);
                break;
            default:
                break;
        }
    }
}
