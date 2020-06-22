package com.zp.algorithm.sort;

/**
 * @author menmenz
 * @version 1.0
 * @date 2020-05-31 14:14
 */
public class BubbleSort {

    public static int[] sort(int[] arr){
        if(arr.length <= 1){
            return arr;
        }
        int temp;
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length-i-1; j++) {
                if(arr[j] > arr[j+1]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int arr[] = {1,4,2,8,9,5,7,6};
        for (int i : sort(arr)) {
            System.out.print(" "+i);

        }
    }
}
