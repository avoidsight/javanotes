package com.zp.leetcode;

/**
 * @author menmenz
 * @version 1.0
 * @date 2020-06-28 12:38
 */
public class Solution209 {
    /**
     * 滑动窗口 双指针实现
     * @param s
     * @param nums
     * @return
     */
    public int minSubArrayLen(int s, int[] nums) {
        if(nums==null || nums.length ==0) return 0;
        int res = Integer.MAX_VALUE, sum =0, j = 0;
        for(int i =0; i<nums.length; i++){
            sum = sum+nums[i];
            while(sum>=s){
                res = Math.min(res,i-j+1);
                sum -= nums[j++];

            }
        }
        return res==Integer.MAX_VALUE? 0:res;
    }

    public static void main(String[] args) {
        Solution209 solution209 = new Solution209();
        System.out.println(solution209.minSubArrayLen(6, new int[]{2, 3, 1, 2, 4, 3}));
    }
}
