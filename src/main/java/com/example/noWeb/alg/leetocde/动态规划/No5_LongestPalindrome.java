package com.example.noWeb.alg.leetocde.动态规划;

public class No5_LongestPalindrome {
    /**
     * 对于字符串str，假设dp[i,j]=1表示str[i...j]是回文子串，那个必定存在dp[i+1,j-1]=1。
     * <p>
     * dp[i,j] =  dp[i+1,j-1]  (str[i]==str[j])
     * OR     0,       (str[i] != str[j])
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        if (s.length() == 0) {
            return "";
        }
        if (s.length() == 1) {
            return s;
        }
        int len = s.length();
        char[] sChar = s.toCharArray();
        boolean[][] dp = new boolean[len][len];
        int start = 0;
        int length = 1;
        // 单个字符初始化
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        // 长度为2的子序列的初始化
        for (int i = 0; i < len - 1; i++) {
            if (sChar[i] == sChar[i + 1]) {
                dp[i][i + 1] = true;
                start = i;
                length = 2;
            }
        }
        // 其他长度的情况
        for (int i = 3; i <= len; i++) { // i: 长度
            for (int j = 0; j+i-1 < len; j++) { // j:起始位置
                if (sChar[j] == sChar[j + i - 1] && dp[j + 1][j + i - 2] == true) {
                    dp[j][j + i - 1] = true;
                    start = j;
                    length = i;
                }
            }
        }
        return s.substring(start, start + length);
    }

    public static void main(String[] args) {
        No5_LongestPalindrome cur = new No5_LongestPalindrome();
//        String s = cur.longestPalindrome("babad");
//        String s = cur.longestPalindrome("bb");
        String s = cur.longestPalindrome("bbb");
        System.out.println(s);
    }
}
