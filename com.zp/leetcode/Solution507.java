package com.zp.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author menmenz
 * @version 1.0
 * @date 12/31/21 2:44 PM
 */
public class Solution507 {
    public boolean checkPerfectNumber(int num) {
        Set<Integer> set = new HashSet();
        for(int i = 1; i<num/i; i++){
            if(num % i == 0) {
                set.add(i);
                set.add(num/i);
            }
        }
        int res = 0;
        for(int t: set) {
            if(t != num) {
                res+=t;
            }
        }
        return res== num;
    }

    public static void main(String[] args) {
        Solution507 solution507 = new Solution507();
        System.out.println(solution507.checkPerfectNumber(8128));
    }
}
