package com.zp.algorithm.dp;

/**
 * @author menmenz
 * @version 1.0
 * @date 8/4/21 6:14 PM
 */
public class Program2 {
    public static int minPathSum(int[][] grid) {
        // write your code here
        int x = grid.length;
        int y = grid[0].length;
        int dp[][] = new int[x+1][y+1];
        for(int i=0;i<x;i++){
            for (int j = 0; j < y; j++) {
                if(i==0){
                    dp[i+1][j+1] = dp[i+1][j]+grid[i][j];
                }else if(j==0){
                    dp[i+1][j+1] = dp[i][j+1]+grid[i][j];
                }else{
                    dp[i+1][j+1] = Math.min(dp[i][j+1],dp[i+1][j])+grid[i][j];
                }
            }
        }
        return dp[x][y];
    }

    public static void change(int arr[]) {
        arr[0] =999;
    }

    public static void main(String[] args) {
//        int[][] grid = {
//                {7,4,8,7,9,3,7,5,0},
//                {1,8,2,2,7,1,4,5,7},
//                {4,6,4,7,7,4,8,2,1},
//                {1,9,6,9,8,2,9,7,2},
//                {5,5,7,5,8,7,9,1,4},
//                {0,7,9,9,1,5,3,9,4}};
//        System.out.println(grid[0][7]);
//        System.out.println("minPathSum(grid) = " + minPathSum(grid));
        int a[] = {1};
        change(a);
        System.out.println(a[0]);
    }
}
