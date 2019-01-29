package com.qsmaxmin.qsbase.aop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by fcl on 19.1.17
 * desc: 切点添加注解
 */

@Target(ElementType.METHOD)             //该注解只能放在方法上
@Retention(RetentionPolicy.RUNTIME)     //该注解在程序运行时是可见的

public @interface TestAnnoTrace {

}
