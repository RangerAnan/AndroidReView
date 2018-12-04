package review.define.view;

import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.qsmaxmin.qsbase.mvp.QsActivity;

@Route(path = "/view/MainViewActivity")
public class MainViewActivity extends QsActivity {


    @Override
    public int layoutId() {
        return R.layout.view_activity_main;
    }

    @Override
    public void initData(Bundle savedInstanceState) {

    }
}
