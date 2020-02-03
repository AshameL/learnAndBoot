package com.example.noWeb.alg.jianzhiOffer;


public class T47不用加减乘除做加法 {
    public int Add(int num1,int num2) {
        while (num2!=0){
            int temp = num1^num2;
            num2 = (num1&num2)<<1;
            num1= temp;
        }
        return num1;
    }

}