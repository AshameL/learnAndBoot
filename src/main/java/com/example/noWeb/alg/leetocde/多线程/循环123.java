package com.example.noWeb.alg.leetocde.多线程;

/**
 * 请设计修改程序，以确保 two() 方法在 one() 方法之后被执行，three() 方法在 two() 方法之后被执行。
 * 题解：https://leetcode-cn.com/problems/print-in-order/solution/
 * <p>
 * 方法：管程法
 */
public class 循环123 {
    private Object lock = new Object();
    private Integer flag = 1;

    public void one() throws InterruptedException {
        synchronized (lock) {
            while (flag != 1) {
                lock.wait();
            }
            flag++;
            System.out.print("one ");
            lock.notifyAll();
        }

    }

    public void two() throws InterruptedException {
        synchronized (lock) {
            while (flag != 2) {
                lock.wait();
            }
            flag++;
            System.out.print("two ");
            lock.notifyAll();
        }

    }

    public void three() throws InterruptedException {
        synchronized (lock) {
            while (flag != 3) {
                lock.wait();
            }
            flag = 1;
            System.out.println("three ");
            lock.notifyAll();
        }
    }

    public static void main(String[] args) {

        循环123 object = new 循环123();

        Runnable c = () -> {
            try {
                object.three();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Runnable b = () -> {
            try {
                object.two();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Runnable a = () -> {
            try {
                object.one();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };


        int count = 0;
        while (true) {
            a.run();
            b.run();
            c.run();
            count++;
            if (count > 100) {
                break;
            }
        }


    }

}
