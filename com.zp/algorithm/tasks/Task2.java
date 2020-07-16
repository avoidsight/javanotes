package tasks;

import java.util.ArrayList;

/**
 * 给出一个排序好的数组和一个数，求数组中连续元素的和等于所给数的子数组
 * 1，2，3，4，5，6，7，8，9     15
 * 1，2，3，4，5    4，5，6     7，8
 */
public class Task2{
    public static int sum = 0;
    public static int index = 0;//运算开始的位置
    public static int current = 0;//当前运算的位置
    public static void search(int[] arr,int target){
        current = index;
        while(current<arr.length && arr[current]<target){
            sum += arr[current++];
            if(sum > target){
                nextInvoke(arr, target);
            }
            if(sum == target){
                for(int i = index;i<current;i++){
                    System.out.print(arr[i]+" ");
                }
                System.out.println();
                nextInvoke(arr, target);
            }
        }
    }
    public static void nextInvoke(int[] arr ,int target){
        sum = 0;
        index++;
        search(arr, target);
    }
    
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,7,8,9};
        int target = 15;
        search(arr, target);
    }
}