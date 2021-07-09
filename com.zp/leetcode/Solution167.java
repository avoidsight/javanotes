package com.zp.leetcode;

import java.util.Arrays;

/**
 * @author menmenz
 * @version 1.0
 * @date 2020-07-20 13:36
 */
public class Solution167 {
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[]{0, numbers.length - 1};
        int sum;
        while (res[0] < res[1]) {
            sum = numbers[res[0]] + numbers[res[1]];
            if (sum == target) return new int[]{res[0] + 1, res[1] + 1};
            if (sum > target) {
                res[1]--;
            } else {
                res[0]++;
            }
        }
        return res;

    }

    public static void main(String[] args) {
        Solution167 solution167 = new Solution167();
        System.out.println(Arrays.toString(solution167.twoSum(new int[]{2, 7, 11, 15}, 9)));
    }
}
