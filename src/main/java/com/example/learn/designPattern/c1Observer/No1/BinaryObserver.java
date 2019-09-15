package com.example.learn.designPattern.c1Observer.No1;

public class BinaryObserver extends  Observer{
    public BinaryObserver(Subject subject){
        this.subject = subject;
        // 这个attach 好神奇
        this.subject.attach(this);
    }
    @Override
    public void update() {
        System.out.println( "Binary String: "
                + Integer.toBinaryString( subject.getState() ) );
    }
}
