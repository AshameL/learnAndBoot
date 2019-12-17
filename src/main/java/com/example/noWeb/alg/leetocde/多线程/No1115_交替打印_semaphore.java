package com.example.noWeb.alg.leetocde.多线程;

import java.util.concurrent.Semaphore;

/**
 * 原文地址：https://zhuanlan.zhihu.com/p/81626432
 *
 */
public class No1115_交替打印_semaphore {
    //在该场景下有点类似红绿灯交替变换的情境，因此信号量成了首选思路：
    private int n;
    public No1115_交替打印_semaphore(int n) {
        this.n = n;
    }

    Semaphore foo = new Semaphore(1);
    Semaphore bar = new Semaphore(0);

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            foo.acquire();
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            bar.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            bar.acquire();
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            foo.release();
        }
    }
}
