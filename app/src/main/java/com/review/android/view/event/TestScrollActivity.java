package com.review.android.view.event;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;

import com.qsmaxmin.qsbase.common.log.L;
import com.qsmaxmin.qsbase.mvp.QsActivity;
import com.review.android.R;


/**
 * 一.事件传递过程
 * Activity的dispatchTouchEvent --> ViewGroup的dispatchTouchEvent --> ViewGroup的onInterceptTouchEvent -->
 */
public class TestScrollActivity extends QsActivity {


    @Override
    public int layoutId() {
        return R.layout.activity_test_scroll;
    }

    @Override
    public void initData(Bundle bundle) {

    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        L.i(initTag(), "dispatchTouchEvent--start:");
        boolean b = super.dispatchTouchEvent(ev);
        L.i(initTag(), "dispatchTouchEvent--end:" + b);
        return b;
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        boolean b = super.onTouchEvent(event);
        L.i(initTag(), "onTouchEvent--event:" + b);
        return b;
    }
}
