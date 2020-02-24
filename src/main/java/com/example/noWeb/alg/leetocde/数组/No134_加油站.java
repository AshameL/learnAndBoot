package com.example.noWeb.alg.leetocde.数组;

public class No134_加油站 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int g = 0, res = 0, start = 0;    // 记录车子当前总油量，一路的开销，当前起始的位置
        for (int i = 0; i < gas.length; i++) {
            g += gas[i] - cost[i];        // 加的油扣掉花费的油
            res += gas[i] - cost[i];    // 计算一路的开销
            if (g < 0) {
                g = 0;                    // 不能到达下一个加油站，清零，从下一个开始
                start = i + 1;            // 记录下一个起点
            }
        }
        return res < 0 ? -1 : start;
    }
}
