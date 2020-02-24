package com.example.noWeb.alg.leetocde.多线程;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

/**
 * 请设计修改程序，以确保 two() 方法在 one() 方法之后被执行，three() 方法在 two() 方法之后被执行。
 * 题解：https://leetcode-cn.com/problems/print-in-order/solution/
 * <p>
 * 方法：管程法
 */
public class No1114_按序打印_管程 {
    private boolean firstFinished;
    private boolean secondFinished;
    private Object lock = new Object();


    public void first(Runnable printFirst) throws InterruptedException {
        synchronized (lock) {
            printFirst.run();
            firstFinished = true;
            lock.notifyAll();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        synchronized (lock){
            while (!firstFinished){
                lock.wait();
            }
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            secondFinished=true;
            lock.notifyAll();
        }

    }

    public void third(Runnable printThird) throws InterruptedException {
      synchronized (lock){
          while (!secondFinished){
              lock.wait();
          }
          // printThird.run() outputs "third". Do not change or remove this line.
          printThird.run();
      }
    }
}
