package com.qsmaxmin.qsbase.aop;

import android.os.SystemClock;
import android.util.Log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Created by fcl on 19.1.17
 * desc:计算方法的执行时间
 */

@Aspect
public class CalcMethodTimeAspect {

    @Pointcut("execution(@com.qsmaxmin.qsbase.aop.TestAnnoTrace * *(..))")
    public void pointcut() {

    }

    @Around("pointcut()")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        Log.i("CalcMethodTimeAspect", "around");
        long beginTime = SystemClock.currentThreadTimeMillis();
        joinPoint.proceed();
        long endTime = SystemClock.currentThreadTimeMillis();
        long dx = endTime - beginTime;
        Log.i("CalcMethodTimeAspect", "耗时：" + dx + "ms");
    }

//    @AfterThrowing(value = "pointcut()", throwing = "ex")
//    public void afterThrowing(Throwable ex) {
//        System.out.println("@afterThrowing");
//        System.out.println("ex = " + ex.getMessage());
//    }
//
//    @AfterReturning("pointcut()")
//    public void afterReturning(JoinPoint point, Object returnValue) {
//        System.out.println("@AfterReturning--returnValue:" + returnValue);
//    }
}
