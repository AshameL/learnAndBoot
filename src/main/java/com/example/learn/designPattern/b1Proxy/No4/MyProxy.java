package com.example.learn.designPattern.b1Proxy.No4;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

// 生成代理类的代码
public class MyProxy {
    private static String ln = "\r\n";

    public static Object newProxyInstance(MyClassLoader classLoader,
                                          Class<?>[] interfaces,
                                          MyInvocationHandler h) {
        // 1. 生成源代码
        String proxySrc = generateSrc(interfaces[0]);
        try {
            //2. 将生成的源代码输出到磁盘，保存为 .java文件。
            String filePath = MyProxy.class.getResource("").getPath();
            File f = new File(filePath + "$Proxy0.java");

            FileWriter fw = new FileWriter(f);
            fw.write(proxySrc);
            fw.flush();
            fw.close();


            //3. 编译源代码，并且生成 .class文件
            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            StandardJavaFileManager manager = compiler.getStandardFileManager(null, null, null);
            Iterable iterable = manager.getJavaFileObjects(f);
            JavaCompiler.CompilationTask task = compiler.getTask(null,manager,null,null,null,iterable);
            task.call();
            manager.close();

            //4. 将class文件的内容，动态加载到jvm中去。

            //5. 返回被代理后的代理对象。
            Class proxyClass = classLoader.findClass("$Proxy0");
            Constructor c= proxyClass.getConstructor(MyInvocationHandler.class);
            f.delete();

            return c.newInstance(h);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String generateSrc(Class<?> interfaces) {
        StringBuffer src = new StringBuffer();
        // 然后就是在字符串中手写代码了…………  我不想写了……
        src.append("package com.example.learn.designPattern.b1Proxy.No4;" + ln);
        src.append("import java.lang.reflect.Method;" + ln);
        src.append("public class $Proxy0 implements " + interfaces.getName() + "{" + ln);

        src.append("MyInvocationHandler h;" + ln);

        src.append("public $Proxy0(MyInvocationHandler h) {" + ln);
        src.append("this.h = h;" + ln);
        src.append("}" + ln);

        for (Method m : interfaces.getMethods()) {
            src.append("public " + m.getReturnType().getName() + " " + m.getName() + "() {" + ln);

            src.append("try{"+ln);

            src.append("Method m = " + interfaces.getName() + ".class.getMethod(\"" + m.getName() + "\",new Class[]{});" + ln);
            src.append("this.h.invoke(this,m,null);" + ln);
            src.append("}catch(Throwable throwable){throwable.printStackTrace();}" + ln);

            src.append("}" + ln);
        }
        src.append("}" + ln);


        return src.toString();
    }
}
