package com.zp.leetcode;

import java.util.HashMap;

/**
 * @author menmenz
 * @version 1.0
 * @date 2020-06-17 13:11
 */
public class Solution27 {
    public static int removeElement(int[] nums, int val) {
        int res = 0;
        int i = 0;
        int j =i;
        while(i<nums.length){
            if(nums[i]!=val){
                nums[j] = nums[i];
                res++;
                j++;
            }
            i++;
        }
        return res;
    }

    public static void main(String[] args) {
//        int a[] = new int[]{0,1,2,2,3,0,4,2};
//        int i = removeElement(a, 2);
//        System.out.println(a.toString());
        int i = 0xDF;
        int j = 0x20;
        char a ;
        while((int)(a='a')>3){
            System.out.println('x');
            break;
        }
        System.out.println("a = " + a);
//        System.out.println("i = " + i);
//        System.out.println("j = " + j);
//        System.out.println((char)('A'|0x20));
//        System.out.println((char)97);

//        for (int k =0; k <= 0xff; k++) {
//            if (isNumOrChar(k)){
//                System.out.println((char)k);
//            }
//        }
    }

    public static boolean isNumOrChar(int index) {
        if (index<58 && index>47 || index<91 && index >64 || index < 123 && index > 96){
            return true;
        }
        return false;
    }
}
