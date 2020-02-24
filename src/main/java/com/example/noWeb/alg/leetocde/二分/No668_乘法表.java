package com.example.noWeb.alg.leetocde.二分;

public class No668_乘法表 {
    public int findKthNumber(int m, int n, int k) {
         int low = 1;
         int high = m*n+1;
         while (low<high){
             int mid = (low+high)/2;
             int cnt = smallNumCount(mid,m,n);// 计算乘法表中不大于mid的元素个数
             if(cnt>=k){
                 high = mid;
             }else{
                 low = mid+1;
             }
         }
         return low;
    }

    private int smallNumCount(int num, int m, int n) {
        int count = 0;
        for(int i =1;i<=m;i++){
            count +=Math.min(num/i,n);
        }
        return count;
    }

}
