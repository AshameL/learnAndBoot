package com.example.noWeb.alg.jianzhiOffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;


public class T28数组中超过一半的数字 {
    // 这个方法先排序了
    public int MoreThanHalfNum_Solution(int [] array) {
        int len = array.length;
        if(len<1)
            return 0;
        int count = 0;
        Arrays.sort(array);
        int num = array[len/2];
        for(int i = 0;i<len;i++){
            if(num==array[i])
                count++;
        }
        if(count<=(len/2)){
            num = 0;
        }
        return num;
    }
    // 这个方法没排序。
    public int MoreThanHalfNum2(int [] numbers) {
        if(numbers.length==0)return 0;
        // 遍历每个元素，并记录次数；若与前一个元素相同，则次数加1，否则次数减1.
        int result = numbers[0];
        int times =1;//次数
        for(int i =1;i<numbers.length;i++){
            if(times==0){
                // 更新result的值为当前元素，并置次数为1
                result = numbers[i];
                times = 1;
            }else if(numbers[i] == result){
                times++;//相同加1
            }else {
                times--;//不同-1
            }
        }
        // 判断result是否符合条件，即出现次数大于数组长度的一半
        times = 0;
        for(int i = 0;i<numbers.length;i++){
            if(numbers[i] == result)
                times++;
        }
        return (times>numbers.length/2 )?result:0;


    }

}
