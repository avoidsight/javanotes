package leetcode;

import java.util.Arrays;
import java.util.Queue;

public class Solution542 {
    public int[][] updateMatrix(int[][] mat) {
        int[] dx = {1,0};
        int[] dy = {0,1};
        int x = mat.length;
        int y = mat[0].length;
        int[][] res = new int[x][y];
        for(int i = 0; i< x; i++) {
            for(int j = 0; j< y; j++) {
                res[i][j] = -1;
            }
        }
        for(int i = 0; i< x; i++) {
            for(int j = 0; j< y; j++){
                if(res[i][j] != -1){
                    continue;
                }
                if(mat[i][j] == 0) {
                    res[i][j] = 0;
                    continue;
                }
                int count= 1;
                res[i][j] = findMin2Zero(mat,i,j,x,y,dx,dy,count,res);
            }
        }
        return res;
    }
    public int findMin2Zero(int[][] mat, int i, int j,int x, int y, int[] dx, int[] dy, int count,int[][] res){
        if(res[i][j] != -1){
            return res[i][j];
        }
        for(int k = 0; k < 2; k++) {
            if(i+dx[k]<x && i+dx[k]>-1 && j+dy[k] < y && j+dy[k] > -1) {
                if(mat[i+dx[k]][j+dy[k]] == 0) {
                    return 1;
                }
            }
        }
        int min =10000;
        count++;
        for(int k = 0; k < 2; k++) {
            if(i+dx[k]<x && i+dx[k]>-1 && j+dy[k] < y && j+dy[k] > -1) {
                if (res[i + dx[k]][j + dy[k]] == -1)
                    count = findMin2Zero(mat, i + dx[k], j + dy[k], x, y, dx, dy, count , res)+1;
                else count = res[i + dx[k]][j + dy[k]]+1;
                min =Math.min(count,min);
            }
        }
        res[i][j] = min;
        return min;
    }

    public static void main(String[] args) {
        Solution542 solution542 = new Solution542();
//        int[][] mat = {{0,0,0},{0,1,0},{1,1,1}};
        int[][] mat = {{1,0,1,1,0,0,1,0,0,1},{0,1,1,0,1,0,1,0,1,1},{0,0,1,0,1,0,0,1,0,0},{1,0,1,0,1,1,1,1,1,1},{0,1,0,1,1,0,0,0,0,1},{0,0,1,0,1,1,1,0,1,0},{0,1,0,1,0,1,0,0,1,1},{1,0,0,0,1,1,1,1,0,1},{1,1,1,1,1,1,1,0,1,0},{1,1,1,1,0,1,0,0,1,1}};
        int[][] res = solution542.updateMatrix(mat);
        for (int[] re : res) {
            System.out.println(Arrays.toString(re));
        }
    }
}
