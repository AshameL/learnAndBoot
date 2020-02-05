package com.example.noWeb.designPattern.a0Singleton;

public class Singleton2 {
    private static class SingletonHolder{
        private static final Singleton2 INSTANCE = new Singleton2();
    }

    private Singleton2(){

    }
    public static Singleton2 getInstance(){
       return SingletonHolder.INSTANCE;
    }
}
