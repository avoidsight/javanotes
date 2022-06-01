package com.zp.leetcode;

import java.sql.SQLOutput;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution6 {
    public String convert(String s, int numRows) {
        if(numRows == 1) return s;
        int r = 2*numRows - 2;// 4
        int[] y = buildY(s, numRows);
        char[] res = new char[s.length()];
        for(int i = 0; i < s.length(); i ++) {
            // i = 7; p = 1; m = 3
            int p = i / r;
            int m = i % r;
            int x = m - numRows ;
            int a = 0;
            if(x < 0) {
                for(int j = 0; j < m; j++){
                    a += y[j];
                }
                if (m == 0 || m == (numRows - 1)){
                    a += p + 1;
                }else{
                    a += 2*p + 1;
                }
            }else{
                for(int j = 0; j < 2 * numRows - m -2; j++) {
                    a += y[j];
                }
                a += 2*p + 2;
            }
            res[a - 1] = s.charAt(i);
        }
        return new String(res);
    }

    private int[] buildY(String s, int numRows) {
        int[] res = new int[numRows];
        int size = s.length();
        int r = 2*numRows - 2;
        int n = (size-1)/r;
        Arrays.fill(res,2*n);
        res[0] = n + 1;
        res[numRows - 1] = n;
        int m = (size-1) % r;
        int x = m - numRows ;
        if(x < 0) {
            for(int i = 1; i < m + 1; i++) {
                res[i] ++;
            }
        }else{
            for(int i = 1; i < numRows-1; i++) {
                res[i]++;
            }
            for(int i = 0; i < x + 1; i++) {
                res[numRows - 2 -i] ++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution6 solution6 = new Solution6();
//        System.out.println(Arrays.toString(solution6.buildY("PAYPALISHIRING", 3)));
        System.out.println(solution6.convert("A", 1));
    }
}
