package com.zp.algorithm.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * @author menmenz
 * @version 1.0
 * @date 2020-06-12 17:38
 */
class Solution {
    int[] flag;
    List<List<Integer>> res = new ArrayList<>();
    final List<Integer> list = new ArrayList<>();


    public List<List<Integer>> threeSum(int[] nums) {
        flag = new int[nums.length];
        iterate(nums);
        return res;
    }

    public void iterate(int[] nums){
        if(list.size()==3 ){
            if(list.get(0)+list.get(1)+list.get(2) == 0){
                List<Integer> list1 = new ArrayList<>();
                list1.addAll(list);
                res.add(list1);
            }
        }
        while (list.size()<3){
            for(int i = 0;i<nums.length;i++){
                if(flag[i] != 0) {
                    continue;
                }
                flag[i] = 1;
                list.add(nums[i]);
                iterate(nums);
                flag[i] = 0;
            }
            return;
        }
        list.remove(list.size()-1);

    }

    public static void main(String[] args) {
        int arr[] = new int[]{-1, 0, 1, 2, -1, -2};
        Solution s = new Solution();
        List<List<Integer>> lists = s.threeSum(arr);
        for (List<Integer> list : lists) {
            System.out.println(list.toArray());
        }
    }

}