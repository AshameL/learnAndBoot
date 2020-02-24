package com.example.noWeb.alg.leetocde.多线程;

import java.util.concurrent.Semaphore;

public class No1115_交替打印_管程 {
    private int n;
    private boolean flag = true;
    private Object lock = new Object();
    public No1115_交替打印_管程(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            synchronized(lock){
                while(!flag){
                    lock.wait();
                }
                printFoo.run();
                flag = false;
                lock.notifyAll();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            synchronized(lock){
                while(flag){
                    lock.wait();
                }
                printBar.run();
                flag = true;
                lock.notifyAll();
            }
        }
    }
}
