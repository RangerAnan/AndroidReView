package com.review.android.view.event;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.LinearLayout;
import android.widget.Scroller;

import com.qsmaxmin.qsbase.common.log.L;
import com.review.android.R;

/**
 * Created by fcl on 18.11.17
 * desc:
 * <p>
 * 1.getX与translationX的区别
 * <p>
 * 2.ViewGroup中onInterceptTouchEvent拦截后，才会调用onTouchEvent.
 */

public class TestEventView extends LinearLayout {


    private Context context;
    private String tag = "TestEventView";

    /**
     * 设备识别的滑动最小距离
     */
    private int mTouchSlop;

    /**
     * 弹性滑动
     */
    private Scroller mScroller;

    public TestEventView(Context context) {
        super(context);
        init(context);
    }

    public TestEventView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public TestEventView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        this.context = context;
        mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        L.i(tag, "init--mTouchSlop:" + mTouchSlop);
        mScroller = new Scroller(context);
        setOrientation(LinearLayout.VERTICAL);

        initView(context);
    }

    private void initView(Context context) {
        View inflate = View.inflate(context, R.layout.view_test_event, null);
        View btn = inflate.findViewById(R.id.btn);


        addView(inflate);
    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        L.i(tag, "dispatchTouchEvent--start:");
        boolean b = super.dispatchTouchEvent(ev);
        L.i(tag, "dispatchTouchEvent--end:" + b);
        return b;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        boolean b = super.onInterceptTouchEvent(ev);
        L.i(tag, "onInterceptTouchEvent--event:" + b);
        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        boolean b = super.onTouchEvent(event);
        L.i(tag, "onTouchEvent--event:" + b);
        return false;
    }

    /**
     * 缓慢滚动指定位置
     */
    private void smoothScrollTo(int destX, int destY) {
        int scaleX = getScrollX();
        int deltaX = destX - scaleX;
        //其实位置-滑动距离
        mScroller.startScroll(scaleX, 0, deltaX, 0);
        //重绘
        invalidate();
    }


    /**
     * 该方法中在View中是个空实现，在draw方法中调用
     */
    @Override
    public void computeScroll() {
        if (mScroller.computeScrollOffset()) {  //滑动是否结束
            scrollTo(mScroller.getCurrX(), mScroller.getCurrY());
            postInvalidate();
        }
    }
}
