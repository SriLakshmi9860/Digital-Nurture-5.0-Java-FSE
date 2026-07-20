package com.library.aspect;

import org.aspectj.lang.JoinPoint;

public class LoggingAspect {

    public void beforeMethod(JoinPoint joinPoint) {
        System.out.println("Before executing : " + joinPoint.getSignature().getName());
    }

    public void afterMethod(JoinPoint joinPoint) {
        System.out.println("After executing : " + joinPoint.getSignature().getName());
    }
}