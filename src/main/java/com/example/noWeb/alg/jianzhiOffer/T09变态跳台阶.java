package com.example.noWeb.alg.jianzhiOffer;

public class T09变态跳台阶 {
    public int JumpFloorII(int target) {
        if (target <= 0){
            return 1;
        }
        if(target == 1 ){
            return 1;
        }
        if(target ==2){
            return 2;
        }
        int sum = 1;
        for(int i=1;i<target;i++){
            sum +=JumpFloorII(i);
        }
        return sum;
    }
}
