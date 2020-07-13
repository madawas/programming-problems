package org.madawa.sorting;

import java.util.Arrays;

public class QuickSort {
    public static void quickSort(int[] arr, int start, int end) {
        if (start < end) {
            int pivot = partition(arr, start, end);
            quickSort(arr, start, pivot - 1);
            quickSort(arr, pivot + 1, end);
        }
    }

    private static int partition(int[] arr, int start, int end) {
        int pivot = arr[end];
        int i = start;
        int temp;
        for (int j = start; j < end; ++j) {
            if (arr[j] < pivot) {
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                ++i;
            }
        }
        temp = arr[i];
        arr[i] = arr[end];
        arr[end] = temp;
        return i;
    }

    public static void main(String[] args) {
        int[] arr = {12, 17, 6, 67, 5, 13};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
