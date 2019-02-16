package com.review.android.view.button;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;

/**
 * Created by fcl on 19.2.15
 * desc: 代码设置Button的背景
 */

public class SuperShapeButton extends AppCompatButton {

    public SuperShapeButton(Context context) {
        super(context);
        init(context);
    }

    public SuperShapeButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public SuperShapeButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }


    private void init(Context context) {

    }


    /**
     * 设置圆角矩形
     */
    public void setRectangleShape(int cornerRadius, int color, int strokeWidth, int strokeColor) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(cornerRadius);
        setBaseShapeConfig(gradientDrawable, GradientDrawable.RECTANGLE, color, strokeWidth, strokeColor);
    }

    /**
     * 设置圆角矩形
     */
    public void setRectangleShape(int cornerRadius, int color, int strokeWidth, int strokeColor, Rect rect) {

        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setBounds(rect);
        gradientDrawable.setCornerRadius(cornerRadius);

        setBaseShapeConfig(gradientDrawable, GradientDrawable.RECTANGLE, color, strokeWidth, strokeColor);

    }

    /**
     * 设置圆形背景（包括椭圆）
     */
    public void setOvalShape(int width, int height, int color, int strokeWidth, int strokeColor) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setSize(width, height);
        setBaseShapeConfig(gradientDrawable, GradientDrawable.OVAL, color, strokeWidth, strokeColor);
    }

    /**
     * 设置圆形背景（包括椭圆）
     */
    public void setOvalShape(int width, int height, int color, int strokeWidth, int strokeColor, Rect rect) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setSize(width, height);
        gradientDrawable.setBounds(rect);
        setBaseShapeConfig(gradientDrawable, GradientDrawable.OVAL, color, strokeWidth, strokeColor);
    }


    /**
     * 设置基本参数
     */
    private void setBaseShapeConfig(GradientDrawable gradientDrawable, int shape, int color, int strokeWidth, int strokeColor) {
        //形状
        gradientDrawable.setShape(shape);
        //颜色
        gradientDrawable.setColor(color);
        //边框宽度与颜色
        gradientDrawable.setStroke(strokeWidth, strokeColor);
        //设置成背景
        setShapeDrawable(gradientDrawable);
    }

    /**
     * 设置shape背景
     */
    public void setShapeDrawable(GradientDrawable gradientDrawable) {
        setBackground(gradientDrawable);
    }

    public void setSelectorDrawable(StateListDrawable stateListDrawable) {
        setBackground(stateListDrawable);
    }
}
