package com.example.noWeb.alg.leetocde.多线程;

import java.util.concurrent.Semaphore;

/**
 * 请设计修改程序，以确保 two() 方法在 one() 方法之后被执行，three() 方法在 two() 方法之后被执行。
 * 题解：https://leetcode-cn.com/problems/print-in-order/solution/
 *
 *
 * Semaphore与CountDownLatch相似，不同的地方在于Semaphore的值被获取到后是可以释放的，并不像CountDownLatch那样一直减到底
 * 获得Semaphore的线程处理完它的逻辑之后，你就可以调用它的Release()函数将它的计数器重新加1，这样其它被阻塞的线程就可以得到调用了
 * 链接：https://leetcode-cn.com/problems/print-in-order/solution/javayou-jie-by-no-one-9/
 *
 */
public class No1114_按序打印Semaphore {
    public Semaphore seam_first_two = new Semaphore(0);

    public Semaphore seam_two_second = new Semaphore(0);


    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        //只有等first线程释放Semaphore后使Semaphore值为1,另外一个线程才可以调用（acquire）
        seam_first_two.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        seam_first_two.acquire();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        seam_two_second.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        //只有spb为1才能通过，如果为0就会阻塞
        seam_two_second.acquire();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}
