package com.review.android.view.button;

import android.graphics.Rect;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.qsmaxmin.qsbase.common.utils.QsHelper;
import com.qsmaxmin.qsbase.common.viewbind.annotation.Bind;
import com.qsmaxmin.qsbase.mvp.QsActivity;
import com.review.android.R;

public class TestButtonShapeActivity extends QsActivity {

    @Bind(R.id.superButton1)
    SuperShapeButton superButton1;

    @Bind(R.id.superButton2)
    SuperShapeButton superButton2;

    @Bind(R.id.superButton3)
    SuperShapeButton superButton3;

    @Bind(R.id.superButton4)
    SuperShapeButton superButton4;


    @Override
    public int layoutId() {
        return R.layout.activity_test_button_shape;
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        superButton1.setRectangleShape(25,
                ContextCompat.getColor(QsHelper.getInstance().getApplication(), R.color.color_white),
                3,
                ContextCompat.getColor(QsHelper.getInstance().getApplication(), R.color.color_red));
        superButton2.setRectangleShape(25,
                ContextCompat.getColor(QsHelper.getInstance().getApplication(), R.color.color_white),
                3,
                ContextCompat.getColor(QsHelper.getInstance().getApplication(), R.color.color_red),
                new Rect(10, 10, 10, 10));
    }
}
