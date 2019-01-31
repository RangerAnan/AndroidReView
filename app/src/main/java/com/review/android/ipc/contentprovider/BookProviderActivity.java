package com.review.android.ipc.contentprovider;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.qsmaxmin.qsbase.mvp.QsActivity;
import com.review.android.R;
import com.review.android.thirdframework.TestModel;
import com.review.android.thirdframework.eventbus.RangerBus;

public class BookProviderActivity extends QsActivity {


    @Override
    public int layoutId() {
        return R.layout.activity_provider;
    }

    @Override
    public void initData(Bundle bundle) {
        //通过authorities 这个唯一标识来获取uri
        Uri uri = Uri.parse("content://com.review.android.provider");
        getContentResolver().query(uri, null, null, null, null);
        getContentResolver().query(uri, null, null, null, null);
        getContentResolver().query(uri, null, null, null, null);


        RangerBus.getInstance().postEvent(new TestModel("啦啦啦"));
    }
}
