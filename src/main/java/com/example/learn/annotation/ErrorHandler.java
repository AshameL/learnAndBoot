package com.example.learn.annotation;

import java.lang.annotation.*;

/**
 * Created by tanxiaocan on 2016/8/25.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD,ElementType.TYPE})
@Inherited
@Documented
public @interface ErrorHandler {
    boolean exclude() default false;
}
