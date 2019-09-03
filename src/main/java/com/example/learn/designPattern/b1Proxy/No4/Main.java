package com.example.learn.designPattern.b1Proxy.No4;


public class Main {
    public static void main(String[] args) throws Exception {
        Object obj =  new MyMeipo().getInstance(new XiaoXingXing());
//        System.out.println("main中代理生成的类是:"+obj.getClass());
//        obj.findLove();
        /**
         * 原理：
         * 1. 拿到被代理对象的引用，然后获取它的接口
         * 2. jdk代理重新生成一个类，同时实现我们给的代理对象所实现的接口
         * 3. 把被代理对象的引用也拿到了
         * 4. 重新动态生成一个class字节码
         * 5. 然后编译
         */

        // 反编译class方法。
        // 获取字节码的内容
//        byte[] data = ProxyGenerator.generateProxyClass("$MyProxy0", new Class[]{com.example.learn.designPattern.b1Proxy.No3.Person.class});
//        FileOutputStream os = new FileOutputStream("$MyProxy0.class");
//        os.write(data);
//        os.close();

    }
}
