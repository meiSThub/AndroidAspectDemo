package com.mei.aspectjdemo.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author mxb
 * @date 2020/8/7
 * @desc 用户信息统计
 * @desired
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UserInfoTrace {

    String value() default "";
}
