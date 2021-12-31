package com.zp.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author menmenz
 * @version 1.0
 * @date 10/26/21 9:30 AM
 */
public class Solotion496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer,Integer> hash = new HashMap<>();
        int[] res = new int[nums1.length];
        for(int i = 0, len = nums1.length; i < len; i ++) {
            for(int j = 0, len2 = nums2.length; j < len2; j++){
                if(nums1[i] == nums2[j]) {
                    int target = nums2[j];
                    boolean find = false;
                    for(int k = j; k< nums2.length; k++) {
                        if(nums2[k] > target){
                            res[i] = nums2[k];
                            find = true;
                            break;
                        }
                    }
                    if(!find){
                        res[i] = -1;
                    }
                    break;
                }
            }
        }
        return res;
    }
}
