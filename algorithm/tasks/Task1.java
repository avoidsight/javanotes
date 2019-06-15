/**
 * 输入一个矩阵，从外向里顺时针打印。
 * 1    2   3   4 
 * 5    6   7   8
 * 9    10  11  12
 * 13   14  15  16
 * 
 * 输出1，2，3，4，8，12，16，15，14，13，9，5，6，7，11，10
 */

 public class Task1{
     private static int deep = 0;
     public static void print(int arr[][],int l,int w){
        if(l<=2*deep&&w<=2*deep){
            return;
        }
        for(int i=deep;i<l-1-deep;i++){
            System.out.println(arr[deep][i]);
        }
        for(int i=deep;i<w-1-deep;i++){
            System.out.println(arr[i][l-deep-1]);
        }
        for(int i=l-deep-1;i>deep;i--){
            System.out.println(arr[w-deep-1][i]);
        }
        for(int i=w-1-deep;i>deep;i--){
            System.out.println(arr[i][deep]);
        }
        deep++;
        print(arr, l, w);
     }
     public static void main(String[] args) {
        int a[][] = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        print(a, 4, 4);
     }
 }