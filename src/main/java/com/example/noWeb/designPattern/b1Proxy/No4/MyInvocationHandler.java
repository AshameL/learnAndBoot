package com.example.noWeb.designPattern.b1Proxy.No4;

import java.lang.reflect.Method;

public interface MyInvocationHandler {
    public Object invoke(Object proxy, Method method, Object[] args)throws Throwable;
}
