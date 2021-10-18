package com.zp.leetcode;

/**
 * @author menmenz
 * @version 1.0
 * @date 10/18/21 3:02 PM
 */
public class Solution476 {
    public int findComplement(int num) {
        int start = 1;
        for(int i =0; i<= 31; i++){
            if((start<<i) - 1 >= num) {
                return (start << i) -1 -num;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Solution476 s = new Solution476();
        System.out.println("s.findComplement(5) = " + s.findComplement(2147483646));
    }
}
