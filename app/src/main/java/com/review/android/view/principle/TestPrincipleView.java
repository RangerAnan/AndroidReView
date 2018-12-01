package com.review.android.view.principle;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by fcl on 18.12.1
 * desc:
 */

public class TestPrincipleView extends View {

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
    }
}
