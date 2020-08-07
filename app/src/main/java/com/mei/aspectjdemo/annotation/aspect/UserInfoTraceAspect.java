package com.mei.aspectjdemo.annotation.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import android.util.Log;

/**
 * @author mxb
 * @date 2020/8/7
 * @desc
 * @desired
 */
@Aspect
public class UserInfoTraceAspect {

    private static final String TAG = "UserInfoTraceAspect";

    @Pointcut("execution(@com.mei.aspectjdemo.annotation.UserInfoTrace * *(..))")
    public void userInfoMethodPointcut() {
        Log.i(TAG, "userInfoMethodPointcut: ");
    }

    // @Before("userInfoMethodPointcut()")
    // public void beforePointcut(ProceedingJoinPoint joinPoint) {
    //     Log.i(TAG, "beforePointcut: ");
    // }
    //
    // @After("userInfoMethodPointcut()")
    // public void afterPointcut(ProceedingJoinPoint joinPoint) {
    //     Log.i(TAG, "afterPointcut: ");
    // }

    @Around("userInfoMethodPointcut()")
    public Object aroundPointcut(ProceedingJoinPoint joinPoint) {
        Log.i(TAG, "aroundPointcut: ");
        Object proceed = null;
        try {
            proceed = joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        return proceed;
    }
}
