package org.madawa.sorting;

import java.util.Arrays;

public class SelectionSort {

    public static int[] selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; ++i) {
            int min = i;
            for (int j = i + 1; j < arr.length; ++j) {
                if (arr[min] > arr[j]) {
                    min = j;
                }
            }
            if (i != min) {
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] ar = {12, 17, 6, 67, 5, 13, 81, 24};
        System.out.println(Arrays.toString(selectionSort(ar)));
    }
}
