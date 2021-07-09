package com.zp.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author menmenz
 * @version 1.0
 * @date 5/19/21 1:46 PM
 */
public class Solution1738 {
    public int kthLargestValue(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length;
        int pre[][] = new int[m+1][n+1];
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                pre[i][j] = pre[i-1][j]^pre[i][j-1]^pre[i-1][j-1]^matrix[i-1][j-1];
                res.add(pre[i][j]);
            }
        }
        res.sort(Comparator.comparingInt(num -> -num));
        return res.get(k-1);
    }

    public int findKthLargest(int nums[], int k) {
        List<Integer> list = new ArrayList<Integer>();
        for(int i : nums){
            list.add(i);
        }
        list.sort(Comparator.comparingInt(num -> -num));
        return  list.get(k-1);
    }

    public static void main(String[] args) {
        Solution1738 solution1738 = new Solution1738();
        int[][] matrix = {{5,2},{1,6}};
        System.out.println(solution1738.kthLargestValue(matrix, 2));
        int a[] = {1,2,3};
        System.out.println(solution1738.findKthLargest(a, 2));
    }
}
