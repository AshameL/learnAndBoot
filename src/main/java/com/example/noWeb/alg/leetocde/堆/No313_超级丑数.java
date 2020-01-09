package com.example.noWeb.alg.leetocde.堆;

public class No313_超级丑数 {
    public static int nthSuperUglyNumber(int n, int[] primes) {
        int[] res = new int[n];
        res[0] = 1;
        int[] point = new int[primes.length];
        //for(int p :primes)p = 0;
        for (int i = 1; i < n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < primes.length; j++) {
                int t = res[point[j]] * primes[j];
                min = Math.min(min, res[point[j]] * primes[j]);
            }
            res[i] = min;
            for (int j = 0; j < primes.length; j++) {
                if (res[point[j]] * primes[j] == min) {
                    point[j]++;
                }
            }
        }
        return res[n - 1];
    }

    public static void main(String[] args) {
        int res = nthSuperUglyNumber(12, new int[]{2, 7, 13, 19});
        System.out.println(res);
    }
}
