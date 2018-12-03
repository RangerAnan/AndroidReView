package com.review.android.view.principle;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.qsmaxmin.qsbase.common.log.L;

/**
 * Created by fcl on 18.12.1
 * desc:
 */

public class TestPrincipleView extends View {

    private String tag = "TestPrincipleView";

    public TestPrincipleView(Context context) {
        super(context);
    }

    public TestPrincipleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public TestPrincipleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        //获取宽度 测量模式与大小
        int widthMeasureSpecMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthMeasureSpecSize = MeasureSpec.getSize(widthMeasureSpec);

        //获取高度的测量模式与大小
        int heightMeasureSpecMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightMeasureSpecSize = MeasureSpec.getSize(heightMeasureSpec);


    }
}
