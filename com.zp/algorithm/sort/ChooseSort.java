package com.zp.algorithm.sort;

/**
 * @author menmenz
 * @version 1.0
 * @date 2020-05-31 14:34
 */
public class ChooseSort {
    public static void sort(int a[]) {
        for (int i = 0; i < a.length; i++) {
            int temp = a[i];
            int minIndex = i;
            for (int j = i; j < a.length; j++) {
                if (a[j] < a[minIndex]) {
                    minIndex = j;
                }
            }
            a[i] = a[minIndex];
            a[minIndex] = temp;
        }
    }

    public static void main(String[] args) {
        int arr[] = {1, 4, 2, 8, 9, 5, 7, 6};
        sort(arr);
        for (int i : arr) {
            System.out.println(i);

        }
    }
}
