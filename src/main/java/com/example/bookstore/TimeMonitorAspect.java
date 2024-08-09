package com.example.bookstore;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeMonitorAspect {
    @Around("@annotation(TimeMonitor)")
    public void logTime(ProceedingJoinPoint joinPoint){
        System.out.println("Logging Time");
        long start = System.currentTimeMillis();
        try {
            joinPoint.proceed();
        } catch (Throwable e) {
            System.out.println("Something went wrong during the execution !!");;
        }
        finally {
            long end = System.currentTimeMillis();
            long totalExecutionTime = end-start;
            System.out.println("Total Execution time of method is : "+totalExecutionTime +"ms...");
        }


    }
}
