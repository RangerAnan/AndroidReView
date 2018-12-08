package com.review.android.view.principle;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.icu.text.UnicodeSetSpanner;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.review.android.R;

/**
 * Created by fcl on 18.12.8
 * desc: 实现一些不规则的View
 * <p>
 * 1.padding需要自定义View中处理，否则xml中设置的不会生效。
 * <p>
 * 2.对于继承自View的控件，如果不对wrap_content特殊处理，那么效果等同match_parent
 */

public class CircleView extends View {

    private Paint mPaint;
    private int mColor = Color.RED;

    public CircleView(Context context) {
        super(context);
        init(context);
    }

    public CircleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        //解析自定义属性
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CircleView);
        mColor = typedArray.getColor(R.styleable.CircleView_circle_color, Color.RED);
        typedArray.recycle();

        init(context);
    }

    public CircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        //解析自定义属性
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CircleView);
        mColor = typedArray.getColor(R.styleable.CircleView_circle_color, Color.RED);
        typedArray.recycle();

        init(context);
    }


    private void init(Context context) {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(mColor);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int paddingBottom = getPaddingBottom();
        int paddingTop = getPaddingTop();
        int paddingStart = getPaddingStart();
        int paddingEnd = getPaddingEnd();

        int width = getWidth() - paddingStart - paddingEnd;
        int height = getHeight() - paddingTop - paddingBottom;
        int radius = Math.min(width, height) / 2;

        canvas.drawCircle(width / 2 + paddingStart, height / 2 + paddingTop, radius, mPaint);
    }


}
