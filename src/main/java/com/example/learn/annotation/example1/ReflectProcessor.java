package com.example.learn.annotation.example1;

import java.lang.reflect.Method;

/**
 * @author dongyuanli217597
 * https://blog.csdn.net/doc_sgl/article/details/50367083
 */
public class ReflectProcessor {
    public void parseMethod(final Class<?> clazz) throws Exception {
        final Object obj = clazz.getConstructor(new Class[]{}).newInstance(new Object[]{});
        final Method[] methods = clazz.getDeclaredMethods();
        for (final Method method : methods) {
            final Reflect my = method.getAnnotation(Reflect.class);
            if (null != my) {
                method.invoke(obj, my.name());
            }
        }
    }
}
