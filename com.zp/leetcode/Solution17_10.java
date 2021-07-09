package com.zp.leetcode;

/**
 * @author menmenz
 * @version 1.0
 * @date 7/9/21 11:15 AM
 */
public class Solution17_10 {
    private int majorityElement(int[] nums) {
        if (nums.length == 0) {
            return -1;
        }
        int count = 1;
        int major = nums[0];
        for (int i=1; i<nums.length; i++) {
            if(count == 0) {
                major = nums[i];
                count = 1;
                continue;
            }
            if(major == nums[i]) {
                count++;
            }else{
                count--;
            }
        }
        if(count == 0) {
            return -1;
        }
        if(count > 1) {
            return major;
        }
        count = 0;
        for(int i:nums) {
            if (major == i){
                count ++;
            }
        }
        return count > nums.length/2? major: -1;
    }

    public static void main(String[] args) {
        System.out.println("new Solution17_10().majorityElement(new int[]{3,2,3}) = " + new Solution17_10().majorityElement(new int[]{3, 2, 3}));
    }
}
