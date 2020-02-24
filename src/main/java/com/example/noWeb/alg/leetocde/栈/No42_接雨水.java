package com.example.noWeb.alg.leetocde.栈;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class No42_接雨水 {
    /*
   单调递减栈
    */

    public static int trap(int[] height) {
        int n = height.length;
        // 设一个单调栈，栈内元素是下标，不是数值。
        Stack<Integer> stack = new Stack<>();
        int res = 0; // 结果
        int curIndex = 0; // 当前下标，应当比 数组长度小。
        while (curIndex < n) {
            // 当前index对应的height值要高，比栈顶元素对应的height值要高。
            while (!stack.isEmpty() && height[curIndex] > height[stack.peek()]) {
                int top = stack.pop();
                System.out.println("pop的index是 " + top + " value是" + height[top]);
                // 当左边没有墙了，直接跳出
                if (stack.isEmpty()) {
                    System.out.println("当左边没有墙了，直接跳出");
                    break;
                }
                // 如果有东西，求height
                int h = Math.min(height[stack.peek()], height[curIndex]) - height[top];
                int desc = curIndex - stack.peek() - 1;// 这里注意-1.
                res += desc * h;
                System.out.println("res是"+ res);
            }
            stack.push(curIndex);
            System.out.println("push之后：" + stack);
            curIndex++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int r = trap(height);
        System.out.println(r);
    }
}
