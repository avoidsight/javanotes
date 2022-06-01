package com.zp.leetcode;

/**
 * @author menmenz
 * @version 1.0
 * @date 2020-07-09 11:16
 */
public class Solution509 {
    public int fib(int N) {
        if (N == 0) return 0;
        if (N == 1) return 1;
        int dp[] = new int[3];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= N; i++) {
            dp[2] = dp[0] + dp[1];
            if (dp[2] >= 1000000007) {
                dp[2] = dp[2] % 1000000007;
            }
            dp[0] = dp[1];
            dp[1] = dp[2];
        }
        return dp[2];
    }

    public static void main(String[] args) {
        Solution509 solution509 = new Solution509();
        System.out.println("solution509.fib(48) = " + solution509.fib(48));
    }
}
