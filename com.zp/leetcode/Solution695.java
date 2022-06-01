package com.zp.leetcode;

public class Solution695 {
    public int maxAreaOfIsland(int[][] grid) {
        int dx[] = {-1,0,1,0};
        int dy[] = {0,1,0,-1};
        int x = grid.length;
        int y = grid[0].length;
        int max = 0;
        for(int i = 0;i< x; i++) {
            for(int j = 0;j < y; j++) {
                int count = 0;
                max = Math.max(findIsland(grid,i,j,dx,dy,count),max);
            }
        }
        return max;
    }

    public int findIsland(int[][] grid,int i,int j,int[] dx, int[] dy,int count) {
        if(grid[i][j] == 1){
            count ++;
            // 走过的标记为2
            grid[i][j] =2;
            for(int k = 0; k < 4; k++) {
                // 如果下一个遍历的点还在grid中
                if(i+dx[k]<grid.length && i+dx[k] > -1 && j+dy[k]<grid[0].length && j+dy[k] > -1){
                    count = findIsland(grid, i+dx[k],j+dy[k],dx,dy,count);
                }
            }
        }
        return count;
    }
}
