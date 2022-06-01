package com.zp.leetcode;

/**
 * @author menmenz
 * @version 1.0
 * @date 2020-07-17 10:46
 */
public class Solution35 {
    public int searchInsert(int[] nums, int target) {
        return getdir(nums,target,0,nums.length-1);
    }

    // 0 3
    public int getdir(int[] nums, int target,int start, int end){
        while(start<end){
            int mid = start + (end - start)/2;
            if(target<nums[mid]){
                end = mid-1;
            }else if(target>nums[mid]){
                start = mid+1;
            }else{
                return mid;
            }
            return getdir(nums,target,start,end);
        }
        end = (end<0? 0:end);
        return nums[end]>=target? end:end+1;
    }

    public static void main(String[] args) {
        Solution35 solution35 = new Solution35();
        System.out.println(solution35.searchInsert(new int[]{1, 3}, 4));
    }
}
