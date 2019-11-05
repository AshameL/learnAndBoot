package com.example.learn.annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.UUID;

/**
 * Created by tanxiaocan on 2016/4/19.
 */

@Component
@Aspect
public class BusinessExceptionAdvice<T> {

    private final static Logger logger = LoggerFactory.getLogger(BusinessExceptionAdvice.class);

    @Around("")
    public Object handleExceptionAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        if(isExclude(proceedingJoinPoint)){
            return proceedingJoinPoint.proceed();
        }
        /*走方法调用，统一日志打印*/
        try{
            Object result = proceedingJoinPoint.proceed();
            return result;
        }catch (Exception e){
            return null;
        }
    }


    private boolean isExclude(ProceedingJoinPoint pjp){
        Signature sig = pjp.getSignature();
        MethodSignature msig = null;
        if (!(sig instanceof MethodSignature)) {
            throw new IllegalArgumentException("该注解只能用于方法");
        }
        msig = (MethodSignature) sig;
        Object target = pjp.getTarget();
        try {
            Method currentMethod = target.getClass().getMethod(msig.getName(), msig.getParameterTypes());
            ErrorHandler errorHandler = currentMethod.getAnnotation(ErrorHandler.class);
            if(errorHandler != null){
                return errorHandler.exclude();
            }else {
                return false;
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            return false;
        }
    }
}
