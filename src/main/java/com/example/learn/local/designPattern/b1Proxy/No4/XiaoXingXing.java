package com.example.learn.local.designPattern.b1Proxy.No4;


public class XiaoXingXing implements Person {
    public String sex = "女";
    public String name = "小星星";

    @Override
    public void findLove() {
        System.out.println("-----find love----");
        System.out.println("我叫" + name + "性别是" + sex);
        System.out.println("我有balabala的择偶标准");
        System.out.println("-----find love----");
    }


}
