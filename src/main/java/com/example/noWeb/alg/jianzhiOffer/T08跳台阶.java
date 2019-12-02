package com.example.noWeb.alg.jianzhiOffer;

public class T08跳台阶 {
    // 多几种方法！！！
    public int JumpFloor(int target) {
        if (target <= 0){
            return 1;
        }
        if(target == 1 ){
            return 1;
        }
        if(target ==2){
            return 2;
        }
        return JumpFloor(target-1)+JumpFloor(target-2);
    }
}
