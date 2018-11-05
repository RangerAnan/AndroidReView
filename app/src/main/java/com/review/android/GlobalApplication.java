package com.review.android;

import com.qsmaxmin.qsbase.QsApplication;
import com.qsmaxmin.qsbase.common.http.HttpBuilder;
import com.qsmaxmin.qsbase.common.log.L;

import okhttp3.Response;

/**
 * Created by fcl on 18.11.5
 * desc:
 */

public class GlobalApplication extends QsApplication {

    private String tag = GlobalApplication.class.getSimpleName();

    @Override
    public boolean isLogOpen() {
        return true;
    }

    @Override
    public void initHttpAdapter(HttpBuilder httpBuilder) {
        httpBuilder.addHeader("Content-Type", "application/json");
    }

    /**
     * http请求公共回调，可用来处理自定义异常等逻辑
     */
    @Override
    public void onCommonHttpResponse(Response response) {
        super.onCommonHttpResponse(response);

    }

    @Override
    public void onCreate() {
        super.onCreate();
        L.i(tag, "当前主进程为：" + android.os.Process.myPid());
    }
}
