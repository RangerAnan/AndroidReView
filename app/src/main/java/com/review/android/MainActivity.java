package com.review.android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.qsmaxmin.qsbase.common.viewbind.annotation.OnClick;
import com.qsmaxmin.qsbase.mvp.QsActivity;

public class MainActivity extends QsActivity {


    @Override
    public int layoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initData(Bundle bundle) {

    }


}
