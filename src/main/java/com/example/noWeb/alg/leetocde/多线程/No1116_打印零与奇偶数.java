package com.example.noWeb.alg.leetocde.多线程;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * https://zhuanlan.zhihu.com/p/81626432
 *
 */
public class No1116_打印零与奇偶数 {
    //借助信号量来建立屏障，还是很方便的：
    private int n;

    public No1116_打印零与奇偶数(int n) {
        this.n = n;
    }

    Semaphore z = new Semaphore(1); // 0
    Semaphore e = new Semaphore(0); // 奇数
    Semaphore o = new Semaphore(0); // 偶数


    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for(int i=0;i<n;i++){
            z.acquire();
            printNumber.accept(0);
            if((i &1)==0)            {
                o.release();
            }else {
                e.release();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for(int i=2; i<=n; i+=2) {
            e.acquire();
            printNumber.accept(i);
            z.release();
        }

    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for(int i=1; i<=n; i+=2) {
            o.acquire();
            printNumber.accept(i);
            z.release();
        }
    }
}
