package com.review.android.ipc.contentprovider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.qsmaxmin.qsbase.common.log.L;

/**
 * Created by fcl on 18.11.10
 * desc:自定义 Provider
 * <p>
 * 1.仅onCreate运行在主线程，其他方法都由外界回调并运行在Binder线程池中
 * 2.清单文件注册，authorities属性设置唯一性
 * 3.抛出异常： Unable to get provider ，未具体验证
 */

public class BookProvider extends ContentProvider {

    private String tag = BookProvider.class.getSimpleName();

    @Override
    public boolean onCreate() {
        L.i(tag, "onCreate--thread:" + Thread.currentThread().getName());
        return false;
    }


    /**
     * 返回一个Uri请求对应的MIME类型，比如图片、视频等。
     *
     * @param uri
     * @return 如果不关注，可以返回null
     */
    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        L.i(tag, "getType--thread:" + Thread.currentThread().getName());
        return null;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        L.i(tag, "query--thread:" + Thread.currentThread().getName());
        return null;
    }


    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        L.i(tag, "insert--thread:" + Thread.currentThread().getName());
        return null;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        L.i(tag, "delete--thread:" + Thread.currentThread().getName());
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        L.i(tag, "update--thread:" + Thread.currentThread().getName());
        return 0;
    }
}
