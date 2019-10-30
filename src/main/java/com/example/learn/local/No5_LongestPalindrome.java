package com.example.learn.local;

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
        char[] chars = s.toCharArray();
        boolean[][] dp = new boolean[len][len];
        int start = 0;
        int length = 1;
        // 长度为0
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        // 长度为1
        for (int i = 0; i < len - 1; i++) {
            if (chars[i] == chars[i + 1]) {
                dp[i][i + 1] = true;
                start = i;
                length = 2;
            }
        }
        // 长度为其他
        for (int i = 3; i <= len; i++) {
            for (int j = 0; j + i - 1 < len; j++) {
                if(chars[j]==chars[j+i-1]&& dp[j+1][j+i-2]==true){
                    dp[j][j+i-1] = true;
                    start= j;
                    length = i;
                }
            }
        }
        return s.substring(start,start+length);
    }

}
