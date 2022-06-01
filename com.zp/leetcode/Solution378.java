package com.zp.leetcode;

import java.util.Arrays;

/**
 * @author menmenz
 * @version 1.0
 * @date 2020-07-02 13:33
 */
public class Solution378 {
    public int kthSmallest(int[][] matrix, int k) {
        int len = matrix.length;
        int left = matrix[0][0],right = matrix[len-1][len-1],sum = len*len,mid = (left+right)/2;
        while(left <right){
            sum = sum(matrix,mid);
            if(sum>=k){
                right = mid;
                mid = (left+right)/2;
            }else{
                left = mid+1;
                mid = (left+right)/2;
            }
        }
        return left;
    }

    private int sum(int[][] matrix, int mid) {
        int i = matrix.length - 1;
        int j = 0;
        int num = 0;
        while (i >= 0 && j < matrix.length) {
            if (matrix[i][j] <= mid) {
                num += i + 1;
                j++;
            } else {
                i--;
            }
        }
        return num;
    }


    public static void main(String[] args) {
        Solution378 solution378 = new Solution378();
        int[][] res = new int[][]{{1,3,5},{6,7,12},{11,14,14}};
        System.out.println(solution378.kthSmallest(res,4));
    }
}
