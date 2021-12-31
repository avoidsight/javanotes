package com.zp.leetcode;

/**
 * @author menmenz
 * @version 1.0
 * @date 10/21/21 3:55 PM
 */
public class Solution829 {
    public int consecutiveNumbersSum(int n) {
        int count = 0;
        int sum = 1;
        for(int l = 0, r = 1; r <= n;) {
            if(sum == n) {
                count++;
                r++;
                sum = sum + r -l;
                l++;
            }else if(sum < n){
                r++;
                sum = sum + r;
            }else{
                sum = sum -l;
                l++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution829 solution829 = new Solution829();
        long start = System.currentTimeMillis();
        System.out.println(solution829.consecutiveNumbersSum(333764327));
        System.out.println(System.currentTimeMillis() - start);
    }
}
