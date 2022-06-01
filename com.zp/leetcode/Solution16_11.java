package com.zp.leetcode;

import java.util.Arrays;

/**
 * @author menmenz
 * @version 1.0
 * @date 2020-07-08 09:25
 */
public class Solution16_11 {
    public int[] divingBoard(int shorter, int longer, int k) {
        if(k == 0) return new int[]{};
        if(shorter == longer) return new int[]{k*shorter};
        int res[] = new int[k+1];
        for(int i = 0; i<= k; i++){
            res[i] = longer*i+shorter*(k-i);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution16_11 solution16_11 = new Solution16_11();
        System.out.println(Arrays.toString(solution16_11.divingBoard(1,2,3)));
    }
}
