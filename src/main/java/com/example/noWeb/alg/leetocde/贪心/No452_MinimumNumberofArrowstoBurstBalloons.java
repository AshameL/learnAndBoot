package com.example.noWeb.alg.leetocde.贪心;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 输入:
 * [[10,16], [2,8], [1,6], [7,12]]
 * <p>
 * 输出:
 * 2
 * <p>
 * 解释:
 * 对于该样例，我们可以在x = 6（射爆[2,8],[1,6]两个气球）和 x = 11（射爆另外两个气球）
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-number-of-arrows-to-burst-balloons
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class No452_MinimumNumberofArrowstoBurstBalloons {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]==o2[0]){
                    return o1[1]-o2[1];
                }
                return o1[0]-o2[0];
            }
        });

        int[] pre = {points[0][0],points[0][1]};
        int count = 1;

        for(int i =1;i<points.length;i++){
            if(pre[1] < points[i][0]){
                //没有重复
                count++;
                pre[0] = points[i][0];
                pre[1] = points[i][1];
            }else{
                //有重复
                pre[0] = points[i][0];
                pre[1] = Math.min(pre[1],points[i][1]);
            }
        }
        return count;

    }
    public int findMinArrowShots2(int[][] points) {
        if(points.length < 1) {
            return 0;
        }
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] ==o2[1]){
                    return o1[0]-o2[0];
                }
                return o1[1]-o2[1];
            }
        });
        int count = 1;
        int axis = points[0][1];

        for(int i =1;i<points.length;i++){
            if(axis<points[i][0]){
                count++;
                axis = points[i][1];
            }
        }
        return count;
    }

    public static void main(String[] args) {
        No452_MinimumNumberofArrowstoBurstBalloons current = new No452_MinimumNumberofArrowstoBurstBalloons();
        int[][] point = {{10,16}, {2,8}, {1,6}, {7,12}};
        int r = current.findMinArrowShots(point);
        int s= current.findMinArrowShots2(point);
        System.out.println(r==s);
    }

}
