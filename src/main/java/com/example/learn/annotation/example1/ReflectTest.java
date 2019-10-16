package com.example.learn.annotation.example1;

public class ReflectTest {

    @Reflect
    public static void sayHello(final String name){
        System.out.println("--->> Hi,"+name+"[sayHello]");
    }

    @Reflect(name = "黄晓明")
    public static void sayHelloToSomeOne(final String name){
        System.out.println("--->> Hi,"+name+"[sayHelloToSomeOne]");
    }

    public static void main(String[] args) throws Exception{
        final ReflectProcessor reflectProcessor = new ReflectProcessor();
        reflectProcessor.parseMethod((ReflectTest.class));
    }
}
