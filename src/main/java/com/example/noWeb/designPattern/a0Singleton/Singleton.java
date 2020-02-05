package com.example.noWeb.designPattern.a0Singleton;

public class Singleton {
    private static volatile Singleton obj;
    private Singleton(){

    }
    public static Singleton getInstance(){
        if(obj==null){
            synchronized (Singleton.class){
                if(obj==null){
                    return new Singleton();
                }
            }
        }
        return obj;
    }
}
