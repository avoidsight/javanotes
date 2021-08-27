package com.zp.algorithm.dp;

import java.util.Arrays;

/**
 * @author menmenz
 * @version 1.0
 * @date 8/3/21 8:41 PM
 */
public class Program1 {
    public static int maxSubArray(int[] nums) {
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i-1] > 0) {
                nums[i] += nums[i-1];
            }
            max = Math.max(max, nums[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {-4,5,-4,5,-4,5,-4,5,-4,5,-4,5,-4,5,-4,5,-4,5,-1000};
        System.out.println(maxSubArray(nums));
    }
}
