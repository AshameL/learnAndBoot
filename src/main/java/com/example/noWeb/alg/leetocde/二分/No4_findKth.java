package com.example.noWeb.alg.leetocde.二分;

public class No4_findKth {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int lengthA = nums1.length;
        int lengthB = nums2.length;
        int len = lengthA + lengthB;

        if (len % 2 == 0) {
            return
                    (findKth(nums1, nums2, 0, 0, len / 2)
                            + findKth(nums1, nums2, 0, 0, len / 2 + 1)
                    ) / 2.0;
        } else {
            return findKth(nums1, nums2, 0, 0, len / 2 + 1);
        }

    }

    public static double findKth(int[] nums1, int[] nums2, int starta, int startb, int k) {
        int len1 = nums1.length;
        int len2 = nums2.length;

        if (starta >= len1) {

            return nums2[startb + k - 1];
        }
        if (startb >= len2)
            return nums1[starta + k - 1];

        if (k == 1) {
            return Math.min(nums1[starta], nums2[startb]);
        }

        int mid = k / 2 - 1;
        int keyPoint1 = starta + mid >= len1 ? Integer.MAX_VALUE : nums1[starta + mid];
        int keyPoint2 = startb + mid >= len2 ? Integer.MAX_VALUE : nums2[startb + mid];
        //
        if (keyPoint1 > keyPoint2) {
            return findKth(nums1, nums2, starta, startb + k / 2, k - k / 2);
        } else
            return findKth(nums1, nums2, starta + k / 2, startb, k - k / 2);

    //https://www.cnblogs.com/lupx/p/lupeixin.html  这个url讲的好
    }

    public static void main(String[] args) {
        int[] num1 = {};
        int[] num2 = {1};
        findMedianSortedArrays(num1,num2);
    }
}
