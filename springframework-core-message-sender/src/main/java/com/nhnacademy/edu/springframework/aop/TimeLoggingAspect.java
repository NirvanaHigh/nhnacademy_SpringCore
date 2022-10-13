package com.nhnacademy.edu.springframework.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class TimeLoggingAspect {
    @Around("execution(* com.nhnacademy.edu.springframework..doSendMessage(..))")
    public Object doBasicProfiling(ProceedingJoinPoint pjp) throws Throwable{
        StopWatch stopWatch = new StopWatch();
        try {
            stopWatch.start();

            return pjp.proceed();
        } finally {
            stopWatch.stop();

            System.out.println(stopWatch.prettyPrint());
        }

    }
}
