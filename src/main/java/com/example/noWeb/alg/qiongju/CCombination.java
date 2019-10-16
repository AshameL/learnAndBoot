package com.example.noWeb.alg.qiongju;

/**
 * 0-(n-1) 去m个
 */
public class CCombination {
    int[] elite;
    int total;
    public CCombination(){}

    public CCombination(int[] elite, int total) {
        this.elite = elite;
        this.total = total;
    }

    /**
     *
     * 把当前数组内容 按照字典序  求得下一个数组内容
     * 设计：从右向左，找到第一个不存在自己最终内容的位置。把这个位置上的数值加1，后面的述职递增
     * @return
     */
    public Boolean next(){
        return true;// 这条是临时占位置的

    }
}
