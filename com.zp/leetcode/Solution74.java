package com.zp.leetcode;

public class Solution74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int x = matrix.length;
        int y = matrix[0].length;
        int l1 = 0, l2 = 0, r1 = x-1,r2 = y-1,mid = -1,row = 0;
        while(l1 <= r1) {
            mid = l1 + (r1-l1)/2;
            if(matrix[mid][0] == target) {
                return true;
            }else if(matrix[mid][0] > target) {
                r1 = mid - 1;
                row = r1;
            }else{
                l1 = mid + 1;
                row = l1 - 1 ;
            }
        }
        if(row == x || row == -1 ) return false;
        while(l2 <= r2) {
            mid = l2 + (r2-l2)/2;
            if(matrix[row][mid] == target) {
                return true;
            }else if(matrix[row][mid] > target) {
                r2 = mid - 1;
            }else{
                l2 = mid + 1;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        Solution74 solution74 = new Solution74();
        int[][] matrix = {{1}};
        System.out.println(solution74.searchMatrix(matrix, 0));
    }
}
