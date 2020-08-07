package com.mei.aspectjdemo.annotation.aspect;

import com.mei.aspectjdemo.annotation.BehaviorTrace;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

import android.util.Log;

/**
 * @author mxb
 * @date 2020/8/6
 * @desc 性能检测的切面
 * @desired
 */
// 使用@Aspect注解，表明BehaviorTraceAspect是一个切面
@Aspect
public class BehaviorTraceAspect {

    private static final String TAG = "BehaviorTraceAspect";

    private long start;

    // 定义切面的切入点，此处的规则就是所有被注解：@com.mei.aspectjdemo.annotation.BehaviorTrace 标注的方法
    // 都会在此切入点执行
    @Pointcut("execution(@com.mei.aspectjdemo.annotation.BehaviorTrace * *(..))")
    public void behaviorTraceMethodPointcut() {

    }

    // @Before("behaviorTraceMethodPointcut()")
    // public void beforePointcut(ProceedingJoinPoint joinPoint) {
    //     start = System.currentTimeMillis();
    //     Log.i(TAG, "beforePointcut: 方法被执行");
    // }
    //
    // @After("behaviorTraceMethodPointcut()")
    // public void afterPointcut(ProceedingJoinPoint joinPoint) {
    //     Log.i(TAG, "afterPointcut: 方法被执行 耗时：" + (System.currentTimeMillis() - start));
    // }

    @Around("behaviorTraceMethodPointcut()")
    public Object aroundPointcut(ProceedingJoinPoint joinPoint) {
        Log.i(TAG, "aroundPointcut: 方法被执行");
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String className = signature.getDeclaringType().getSimpleName();
        String methodName = signature.getName();
        String funName = signature.getMethod().getAnnotation(BehaviorTrace.class).value();
        long start = System.currentTimeMillis();
        Object proceed = null;
        try {
            proceed = joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        long end = System.currentTimeMillis();

        long duration = end - start;

        Log.i(TAG, "aroundPointcut: " + String
                .format("功能：%s,%s类的%s方法执行了，用时%d ms", funName, className, methodName,
                        duration));

        return proceed;
    }
}
