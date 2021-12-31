package com.zp.leetcode;

/**
 * @author menmenz
 * @version 1.0
 * @date 12/24/21 11:16 AM
 */
public class Solution1705 {
    public int eatenApples(int[] apples, int[] days) {
        int c = 0;
        for(int i = 0,l = apples.length; i < l; i++) {
            if(i + days[i] >= c) {
                c = c + Math.min(i + days[i] - c, apples[i]);
            }
        }
        return c;
    }

    public static void main(String[] args) {
        Solution1705 solution1705 = new Solution1705();
        int[] apples = {2,1,10};
        int[] days = {2,10,1};
        System.out.println(solution1705.eatenApples(apples,days));
    }
}
