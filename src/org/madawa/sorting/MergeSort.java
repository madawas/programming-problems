package org.madawa.sorting;

import java.util.Arrays;

public class MergeSort {
    public static void mergeSort(int[] arr, int start, int end) {
        if (start < end) {
            int mid = (start+end)/2;
            mergeSort(arr, start, mid);
            mergeSort(arr, mid+1, end);
            merge(arr, start, mid, end);
        }
    }

    public static void merge(int[] arr, int start, int mid, int end) {
        int[] left = new int[mid-start+1];
        int[] right = new int[end-mid];

        for (int i = 0; i < left.length; ++i) {
            left[i] = arr[start+i];
        }
        for (int i = 0; i < right.length; ++i) {
            right[i] = arr[mid+1+i];
        }

        int i = 0,j = 0;

        int k = start;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
            }
            else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }

        while (i < left.length) {
            arr[k] = left[i];
            i++;
            k++;
        }

        while (j < right.length) {
            arr[k] = right[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        int[] arr = {12, 17, 6, 67, 5, 13};
        mergeSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
