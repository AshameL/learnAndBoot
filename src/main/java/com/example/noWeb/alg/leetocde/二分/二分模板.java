package com.example.noWeb.alg.leetocde.二分;

public class 二分模板 {
    //当我们将区间[l, r]划分成[l, mid]和[mid + 1, r]时，
    // 其更新操作是r = mid或者l = mid + 1;，计算mid时不需要加1
    public int model1(int l, int r, int target) {
        while (l < r) {
            int mid = (l + r) / 2;
            if (check(mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    // 当我们将区间[l, r]划分成[l, mid - 1]和[mid, r]时，
    // 其更新操作是r = mid - 1或者l = mid;，此时为了防止死循环，计算mid时需要加1。
    public int model2(int l, int r, int target) {
        while (l < r) {
            int mid = (l + r + 1) / 2;
            if (check(mid)) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }

    private boolean check(int mid) {
        return true;
    }
}
