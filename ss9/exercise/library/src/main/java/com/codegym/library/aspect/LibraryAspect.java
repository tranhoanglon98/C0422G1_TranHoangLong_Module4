package com.codegym.library.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LibraryAspect {
    private static int count = 1;

    @AfterReturning(pointcut = "execution(* com.codegym.library.controller.LibraryController.*(Integer,..))")
    public void loggingActionChangeLibraryStatus(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.err.println("Method " + methodName +" successfully.");
    }

    @AfterReturning(pointcut = "execution(* com.codegym.library.controller.LibraryController.*(..))")
    public static void processing(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        count++;
        System.err.println("The number of access :" + count);
    }
}
