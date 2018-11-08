package com.review.android.media.fingerprint;

import android.app.KeyguardManager;
import android.content.Context;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.hardware.fingerprint.FingerprintManagerCompat;
import android.support.v4.os.CancellationSignal;
import android.util.Log;
import android.widget.TextView;

import com.qsmaxmin.qsbase.common.log.L;
import com.qsmaxmin.qsbase.common.utils.QsHelper;
import com.qsmaxmin.qsbase.common.viewbind.annotation.Bind;
import com.qsmaxmin.qsbase.mvp.QsActivity;
import com.review.android.R;
import com.review.android.media.fingerprint.util.CryptoObjectCreatorHelper;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;

/**
 * 指纹验证
 */
public class FingerPrintActivity extends QsActivity {

    @Bind(R.id.tv)
    TextView tv;

    private FingerprintManagerCompat mFingerPrint;
    private CancellationSignal cancellationSignal;
    private MyAuthCallback myAuthCallback;

    @Override
    public int layoutId() {
        return R.layout.activity_finger_print;
    }


    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void initData(Bundle bundle) {
        mFingerPrint = FingerprintManagerCompat.from(QsHelper.getInstance().getApplication());
        //校验
        if (!isSupportFingerprint()) {
            L.i(initTag(), "指纹");
            return;
        }

        try {
            getFingerPrintInfo();

            //验证指纹
            cancellationSignal = new CancellationSignal();
            myAuthCallback = new MyAuthCallback();

            new CryptoObjectCreatorHelper(new CryptoObjectCreatorHelper.ICryptoObjectCreateListener() {
                @Override
                public void onDataPrepared(FingerprintManagerCompat.CryptoObject cryptoObject) {
                    mFingerPrint.authenticate(cryptoObject, 0, cancellationSignal, myAuthCallback, null);
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取指纹信息
     * 通过fingerId判断是否更改了指纹
     */
    @RequiresApi(api = Build.VERSION_CODES.M)
    private void getFingerPrintInfo() {
        try {

            Method getFingerprintManagerOrNull = FingerprintManagerCompat.class.getDeclaredMethod("getFingerprintManagerOrNull", new Class[]{Context.class});
            getFingerprintManagerOrNull.setAccessible(true);
            Object invoke = getFingerprintManagerOrNull.invoke(mFingerPrint, FingerPrintActivity.this);
            if (invoke == null) {
                L.i(initTag(), "invoke is null");
                return;
            }
            FingerprintManager fp = (FingerprintManager) invoke;
            Method getEnrolledFingerprints = FingerprintManager.class.getDeclaredMethod("getEnrolledFingerprints");
            Object obj = getEnrolledFingerprints.invoke(fp);
            //List<Fingerprint>
            if (obj != null) {
                //反射获取 指纹id
                Class<?> clazz = Class.forName("android.hardware.fingerprint.Fingerprint");
                Method getName = clazz.getDeclaredMethod("getName");
                Method getFingerId = clazz.getDeclaredMethod("getFingerId");
                Method getGroupId = clazz.getDeclaredMethod("getGroupId");
                Method getDeviceId = clazz.getDeclaredMethod("getDeviceId");

                for (int i = 0; i < ((List) obj).size(); i++) {
                    Object item = ((List) obj).get(i);
                    if (null == item) {
                        continue;
                    }
                    int mFingerId = (int) getFingerId.invoke(item);
                    L.i(initTag(), "mFingerId:" + mFingerId);
                    int groupId = (int) getGroupId.invoke(item);
                    L.i(initTag(), "groupId:" + groupId);
                    long mDeviceId = (long) getDeviceId.invoke(item);
                    L.i(initTag(), "mDeviceId:" + mDeviceId);
                    String name = (String) getName.invoke(item);
                    L.i(initTag(), "name:" + name);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public class MyAuthCallback extends FingerprintManagerCompat.AuthenticationCallback {

        @Override
        public void onAuthenticationError(int errMsgId, CharSequence errString) {
            super.onAuthenticationError(errMsgId, errString);
            L.i(initTag(), "onAuthenticationError--errMsgId:" + errMsgId + ";errString:" + errString);
            tv.setText("验证错误");
        }

        @Override
        public void onAuthenticationFailed() {
            super.onAuthenticationFailed();
            L.i(initTag(), "onAuthenticationFailed");
            tv.setText("验证失败");
        }

        @Override
        public void onAuthenticationHelp(int helpMsgId, CharSequence helpString) {
            super.onAuthenticationHelp(helpMsgId, helpString);
            L.i(initTag(), "onAuthenticationHelp--helpMsgId:" + helpMsgId + ";helpString:" + helpString);
            tv.setText("验证错误2");
        }

        @Override
        public void onAuthenticationSucceeded(FingerprintManagerCompat.AuthenticationResult result) {
            super.onAuthenticationSucceeded(result);
            L.i(initTag(), "onAuthenticationSucceeded--result");
            tv.setText("验证成功");
            try {
                result.getCryptoObject().getCipher().doFinal();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    public boolean isSupportFingerprint() {
        try {
            if (mFingerPrint.isHardwareDetected()//硬件不支持
                    && Build.VERSION.SDK_INT >= Build.VERSION_CODES.M//版本不支持
                    && ((KeyguardManager) FingerPrintActivity.this.getSystemService(Context.KEYGUARD_SERVICE)).isKeyguardSecure()//没有屏幕锁
                    && mFingerPrint.hasEnrolledFingerprints()//系统不存在指纹列表
                    ) {
                return true;
            }
        } catch (Exception e) {
            //防止有些机型没有以上api会抛空指针异常
            L.e(initTag(), e.getLocalizedMessage());
            return false;
        }
        return false;
    }
}
