package com.example.noWeb.alg.jianzhiOffer;

public class T10矩形覆盖 {
    public int RectCover(int target) {
        if(target == 0)
            return 0;
        if(target == 1)
            return 1;
        else if (target ==2){
            return 2;
        }
        else
            return RectCover(target-1) +RectCover(target-2);

    }
    // 多添加几种方法。
    public int RectCover_dp(int target){
        if(target<=2){
            return target;
        }
        int pre1 = 2;// n最后使用一块，剩下n-1 块的写法
        int pre2 = 1; // n最后使用两块，剩下n-2块的写法。
        for(int i =3;i<=target;i++){
            int cur = pre1+pre2;
            pre2 = pre1;
            pre1 = cur;
        }
        return pre1;// 相对于n+1块来说，第n种的方法。
    }
}
