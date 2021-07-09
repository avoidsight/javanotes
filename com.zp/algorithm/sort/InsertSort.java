package com.zp.algorithm.sort;

/**
 * @author menmenz
 * @version 1.0
 * @date 2020-05-31 14:34
 */
public class InsertSort {
    public static void sort(int a[]) {
        for (int i = 1; i < a.length; i++) {
            if (a[i] < a[i - 1]) {
                int j = i - 1;
                int temp = a[i];
                a[i] = a[i - 1];
                while (temp < a[j]) {
                    a[j + 1] = a[j];
                    j--;
                }
                a[j + 1] = temp;
            }

        }
    }

    public static void main(String[] args) {
        int arr[] = {4, 2, 8, 9, 5, 7, 6};
        sort(arr);
        for (int i : arr) {
            System.out.println(i);

        }
    }
}
