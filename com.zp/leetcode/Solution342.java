package com.zp.leetcode;

/**
 * @author menmenz
 * @version 1.0
 * @date 5/31/21 1:18 PM
 */
public class Solution342 {
    public boolean isPowerOfFour(int n) {
        if(n < 1 || (n &(n-1)) != 0)  {
            return false;
        }
        return (n % 3) == 1;
    }

    public static void main(String[] args) {
        String amount = "";
        String count = "";
        Solution342 solution342 = new Solution342();
        System.out.println("solution342.isPowerOfFour(256) = " + solution342.isPowerOfFour(256));
    }
}
