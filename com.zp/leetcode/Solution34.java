package com.zp.leetcode;

import java.util.Arrays;

public class Solution34 {
    public int[] searchRange(int[] nums, int target) {
        int l = 0, r = nums.length -1,mid;
        if(r == -1) return new int[]{-1,-1};
        if(l == r && nums[l] == target) return new int[]{l,l};
        while(l<=r) {
            mid = l + (r-l) / 2;
            if (nums[mid] == target) {
                int lnum = findLeft(nums, l,mid-1,target);
                int rnum = findRight(nums,mid+1, r,target);
                return new int[]{lnum,rnum};
            }else if(nums[mid] > target){
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        return new int[]{-1,-1};
    }
    public int findLeft(int[] nums,int l, int r, int target) {
        int mid;
        if(l == r && nums[l] == target) return l;
        while(l <= r) {
            mid = l + (r-l) / 2;
            if (nums[mid] == target) {
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        return r + 1;
    }

    public int findRight(int[] nums,int l, int r, int target) {
        int mid;
        if(l == r && nums[l] == target) return l;
        while(l <= r) {
            mid = l + (r-l) / 2;
            if (nums[mid] == target) {
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }
        return l - 1;
    }

    public static void main(String[] args) {
        Solution34 solution34 = new Solution34();
        int[] nums = {5,7,7,8,8,10};
        System.out.println(Arrays.toString(solution34.searchRange(nums, 8)));
    }
}
