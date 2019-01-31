package com.review.android.thirdframework.eventbus;

import com.qsmaxmin.qsbase.common.log.L;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by fcl on 19.1.31
 * desc:
 */

public class RangerBus {

    /**
     * key为订阅者，value-注解方法的bean类
     */
    Map<Class<?>, Class<?>> mSubscribeMap = new HashMap<>();

    /**
     * key-注解方法的bean类，value-注解方法的方法名
     */
    Map<Class<?>, Method> mEventMethod = new HashMap<>();

    static RangerBus mRangerBus;

    String tag = "RangerBus";

    public static RangerBus getInstance() {
        if (mRangerBus == null) {
            synchronized (RangerBus.class) {
                if (mRangerBus == null) {
                    mRangerBus = new RangerBus();
                }
            }
        }
        return mRangerBus;
    }

    public void register(Object object) {
        if (mSubscribeMap.containsKey(object.getClass())) {
            return;
        }
        //查询是否有指定注解的方法
        Class<?> obj = findAnnoInObject(object);
        if (obj != null) {
            mSubscribeMap.put(object.getClass(), obj);
        }

    }

    private Class<?> findAnnoInObject(Object object) {
        Method[] declaredMethods = object.getClass().getDeclaredMethods();
        for (Method method : declaredMethods) {
            RanSubscribe annotation = method.getAnnotation(RanSubscribe.class);
            if (annotation != null) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length > 0) {
                    Class<?> parameterType = parameterTypes[0];
                    if (!mEventMethod.containsKey(parameterType)) {
                        mEventMethod.put(parameterType, method);
                    }
                    return parameterType;
                } else {
                    L.e(tag, "RanSubscribe 注解的方法缺失参数");
                }
            }
        }
        return null;
    }

    public void unRegister(Object object) {
        if (!mSubscribeMap.containsKey(object.getClass())) {
            return;
        }
        mSubscribeMap.remove(object.getClass());
    }

    /**
     * 发送事件
     *
     * @param object
     */
    public void postEvent(Object object) {
        Set<Class<?>> classes = mSubscribeMap.keySet();
        for (Class clazz : classes) {
            if (object.getClass().equals(mSubscribeMap.get(clazz))) {
                L.i(tag, "订阅者：" + clazz.getSimpleName() + ";注解的实体类：" + object.getClass().getSimpleName());

                if (mEventMethod.containsKey(object.getClass())) {
                    Method method = mEventMethod.get(object.getClass());
                    try {
                        method.invoke(clazz.newInstance(), object);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    } catch (InstantiationException e) {
                        e.printStackTrace();
                    }
                } else {
                    L.e(tag, clazz.getSimpleName() + "无注解方法");
                }

            }
        }
    }

}
