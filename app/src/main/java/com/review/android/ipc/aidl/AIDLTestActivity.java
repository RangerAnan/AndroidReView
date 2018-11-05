package com.review.android.ipc.aidl;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.qsmaxmin.qsbase.common.utils.QsHelper;
import com.qsmaxmin.qsbase.common.viewbind.annotation.Bind;
import com.qsmaxmin.qsbase.common.viewbind.annotation.OnClick;
import com.qsmaxmin.qsbase.mvp.QsActivity;
import com.review.android.IBookAidlInterface;
import com.review.android.R;

import java.util.List;

public class AIDLTestActivity extends QsActivity {

    @Bind(R.id.tv)
    TextView tv;

    private IBookAidlInterface aidlInterface;

    @Override
    public int layoutId() {
        return R.layout.activity_aidl_test;
    }

    @Override
    public void initData(Bundle bundle) {
        //绑定服务
        Intent intent1 = new Intent(getApplicationContext(), AIDLService.class);
        bindService(intent1, serviceConnection, BIND_AUTO_CREATE);
    }


    /**
     * 实现ServiceConnection类，拿到aidl类
     */
    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            //连接binder
            aidlInterface = IBookAidlInterface.Stub.asInterface(service);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            aidlInterface = null;
        }
    };

    @OnClick(R.id.btn)
    @Override
    public void onViewClick(View view) {
        super.onViewClick(view);
        switch (view.getId()) {
            case R.id.btn:
                Book book = new Book(100, "戴维斯王朝");
                Book book2 = new Book(101, "菜根谭");
                try {
                    //将数据传入另一个进程（服务端）
                    aidlInterface.addPerson(book);
                    aidlInterface.addPerson(book2);

                    //test
                    List<Book> bookList = aidlInterface.getBookList();
                    tv.setText(bookList.toString());
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                break;
            default:
                break;
        }
    }
}
