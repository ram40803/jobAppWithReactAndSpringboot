package com.ram.jobAppWithRest.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogginAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(LogginAspect.class);

    @Before("execution(* com.ram.jobAppWithRest.service.JobService.*(..))")
    public void logMethodCall(JoinPoint jp){
        LOGGER.info("Method called: " + jp.getSignature().getName());
    }

    @After("execution(* com.ram.jobAppWithRest.service.JobService.getAllJobs(..)) || execution(* com.ram.jobAppWithRest.service.JobService.getJobPost(..))")
    public void logMethodCallAfter(JoinPoint jp){
        LOGGER.info("Method called: " + jp.getSignature().getName());
    }

    @AfterThrowing("execution(* com.ram.jobAppWithRest.service.JobService.getAllJobs(..)) || execution(* com.ram.jobAppWithRest.service.JobService.getJobPost(..))")
    public void logMethodCrash(JoinPoint jp){
        LOGGER.info("Method have some issues: " + jp.getSignature().getName());
    }

    @AfterReturning("execution(* com.ram.jobAppWithRest.service.JobService.getAllJobs(..)) || execution(* com.ram.jobAppWithRest.service.JobService.getJobPost(..))")
    public void logMethodExecutedSuccess(JoinPoint jp){
        LOGGER.info("Method Executed Succesfully : " + jp.getSignature().getName());
    }

}
