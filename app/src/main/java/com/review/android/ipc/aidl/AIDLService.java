package com.review.android.ipc.aidl;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;

import com.qsmaxmin.qsbase.common.log.L;
import com.review.android.IBookAidlInterface;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fcl on 18.11.5
 * desc: 服务端代码，开启了新进程
 */

public class AIDLService extends Service {

    private ArrayList<Book> mBooks;

    /**
     * 创建binder对象，服务端实现接口
     */
    private Binder binder = new IBookAidlInterface.Stub() {
        @Override
        public void addPerson(Book book) throws RemoteException {
            mBooks.add(book);
        }

        @Override
        public List<Book> getBookList() throws RemoteException {
            return mBooks;
        }
    };


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        mBooks = new ArrayList<>();
        L.i("AIDLService", "当前进程为：" + android.os.Process.myPid());
        return binder;
    }

}
