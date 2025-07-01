package com.ram.jobAppWithRest.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PerformanceMoniterAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(PerformanceMoniterAspect.class);

    @Around("execution(* com.ram.jobAppWithRest.service.JobService.*(..))")
    public Object monitorTime(ProceedingJoinPoint jp) throws Throwable {
        long start = System.currentTimeMillis();

        Object obj = jp.proceed();

        long end = System.currentTimeMillis();
        LOGGER.info("Time taken: " + (end - start) + "ms");

        return obj;
    }
}
