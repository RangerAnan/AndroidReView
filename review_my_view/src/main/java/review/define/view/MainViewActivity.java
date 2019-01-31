package review.define.view;

import android.os.Bundle;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.qsmaxmin.qsbase.common.log.L;
import com.qsmaxmin.qsbase.mvp.QsActivity;

@Route(path = "/view/MainViewActivity")
public class MainViewActivity extends QsActivity implements View.OnClickListener {


    @Override
    public int layoutId() {
        return R.layout.view_activity_main;
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        findViewById(R.id.btn_two).setOnClickListener(this);
        findViewById(R.id.btn_one).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.btn_one) {
            L.i(initTag(), "开始阻塞主线程");
            try {
                Thread.sleep(15000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            L.i(initTag(), "结束阻塞主线程");

        } else if (i == R.id.btn_two) {
            L.i(initTag(), "点击第二个按钮");
        }
    }}
