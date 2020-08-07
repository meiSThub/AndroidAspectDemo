package com.mei.aspectjdemo.noannotation.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

import android.util.Log;

/**
 * @author mxb
 * @date 2020/8/7
 * @desc 无入侵的方式，实现的切面
 * @desired
 */
@Aspect
public class BehaviorTraceAspect {

    private static final String TAG = "BehaviorTraceAspect";

    @Around("execution(* android.app.Activity.on**(..))")
    public Object aroundBehaviorPointcut(ProceedingJoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String className = signature.getDeclaringType().getSimpleName();
        String methodName = signature.getName();
        long start = System.currentTimeMillis();
        Object proceed = null;
        try {
            proceed = joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        long end = System.currentTimeMillis();

        Log.i(TAG, "aroundBehaviorPointcut，类：" + className + "的方法：" + methodName + "()执行，耗时：" + (end
                - start));
        return proceed;
    }
}
