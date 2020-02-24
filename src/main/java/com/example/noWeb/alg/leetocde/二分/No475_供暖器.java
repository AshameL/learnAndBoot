package com.example.noWeb.alg.leetocde.二分;

import java.util.ArrayList;
import java.util.Arrays;

public class No475_供暖器 {
    /**
     * 1  对于每个房屋，要么用前面的暖气，要么用后面的，二者取近的，得到距离；
     * 2 对于所有的房屋，选择最大的上述距离。
     *
     * @param houses
     * @param heaters
     * @return
     */
    public static int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);

        int res = 0;
        for (int x : houses) {
            int l = 0, r = heaters.length - 1;
            while (l < r) {
                int mid = (l + r) >> 1;
                if (heaters[mid] >= x) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            int minDesc = Math.abs(heaters[r] - x);  // 还是不对！！！
            if (r >0) {
                minDesc = Math.min(x - heaters[r - 1], minDesc);
            }
            res = Math.max(res, minDesc);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] house = {1,5};
        int[] heater = {2};
        Object obj = findRadius(house, heater);
        System.out.println(obj);
    }
}
