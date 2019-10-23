package com.example.learn.local;

public class No5_LongestPalindrome {
    /**
     *  对于字符串str，假设dp[i,j]=1表示str[i...j]是回文子串，那个必定存在dp[i+1,j-1]=1。
     *
     *  dp[i,j] =  dp[i+1,j-1]  (str[i]==str[j])
     *          OR     0,       (str[i] != str[j])
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        if(s.length()==0){
            return "";
        }
        if(s.length()==1){
            return s;
        }
        int len = s.length();
        int[][] dp = new int[len][len];
        for(int i =0;i<len;i++){
            dp[i][i] = 1;
            if(i<l)
        }
    }

}
