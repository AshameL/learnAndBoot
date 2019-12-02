package com.example.noWeb.Thread;

public class Sub01 {
    private long count = 0;
    private void add10K(){
        int idx = 0;
        while (idx++ <10000){
            count += 1;
        }
    }

    public long calc() throws InterruptedException {
        final Sub01 test = new Sub01();
        // 创建两个线程，执行add 操作
        Thread th1 = new Thread(()->{
           test.add10K();
        });
        Thread th2 = new Thread(()->{
           test.add10K();
        });

        // 启动两个线程
        th1.start();
        th2.start();
        // 等待两个线程结束
        th1.join();
        th2.join();
        return count;
    }

    public static void main(String[] args) throws InterruptedException {
        Sub01 sub01 = new Sub01();
        System.out.println(sub01.calc());
    }
}
