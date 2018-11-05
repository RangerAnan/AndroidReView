package com.review.android;

import com.qsmaxmin.qsbase.QsApplication;
import com.qsmaxmin.qsbase.common.http.HttpBuilder;

import okhttp3.Response;

/**
 * Created by fcl on 18.11.5
 * desc:
 */

public class GlobalApplication extends QsApplication {


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
}
