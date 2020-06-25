package com.zp.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Semaphore;

/**
 * @author menmenz
 * @version 1.0
 * @date 2020-06-24 14:22
 */
public class Solution16 {
    public int threeSumClosest(int[] nums, int target) {
        int res = Integer.MAX_VALUE;
        int temp;
        int ans = Integer.MAX_VALUE;
        for(int i = 0 ;i< nums.length-2; i++){
            for (int j = i+1; j < nums.length-1; j++) {
                for (int k = j+1; k < nums.length; k++) {
                    temp = Math.abs(target - (nums[i] + nums[j] + nums[k]));
                    if(temp < res) {
                        ans = nums[i] + nums[j] + nums[k];
                        res = temp;
                    }
                    if (res == 0) {
                        return ans;
                    }

                }
            }
        }
        return ans;
    }

    public int threeSumClosest1(int[] nums, int target) {
        int res = nums[0] + nums[1] + nums[2];
        int cnt = 0;
        backTracing(nums, target, cnt, 0, 0,res);
        return res;
    }
    private void backTracing(int[] nums, int target, int cnt, int sum, int index, int res){
        //结束条件
        if(cnt == 3){
            if(Math.abs(target - res) > Math.abs(sum - target))
                res = sum;
            return ;
        }
        //回溯
        for(int i = index; i < nums.length; i++){
            //添加选择
            sum += nums[i];
            cnt++;
            //开始回溯
            backTracing(nums,target, cnt, sum, i + 1,res);
            //撤销选择
            cnt--;
            sum -= nums[i];
        }
    }

    public static void main(String[] args) {
        Solution16 solution16 = new Solution16();
        int i = solution16.threeSumClosest1(new int[]{1, 2, 3, 4}, 1);
        System.out.println(i);
    }
}
