package com.example.noWeb.alg.jianzhiOffer;

public class T12数值的整数次方 {
    public double Power(double base, int exponent) {
        double res = 1;

        if(exponent<0 && base==0){
            throw new RuntimeException("分母不为零");
        }
        if(exponent == 0)
            return 1;
        for(int i = 0;i<Math.abs(exponent);i++){
            res *=base;
        }
        return exponent<0? 1/res :res;
    }
}
