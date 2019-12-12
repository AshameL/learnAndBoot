package com.example.noWeb;

import java.lang.reflect.Method;

public class Test {
    public static void main(String[] args) throws Exception {
        Class<?> klass = Class.forName("Test");
        Method method = klass.getMethod("target",int.class);
        method.invoke(null,0);
    }

    public static void target(int i ){
        new Exception("#"+i).printStackTrace();
    }
}
