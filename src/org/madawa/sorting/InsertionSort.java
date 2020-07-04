package org.madawa.sorting;

import java.util.Arrays;

public class InsertionSort {

    public static int binarySearch(int[] arr, int start, int end, int key) {
        int mid = (start + end)/2;
        if (start >= end) {
            return -1;
        } else {
            return arr[mid] == key ? mid: key > arr[mid] ? binarySearch(arr, mid + 1, end, key) : binarySearch(arr, start, mid - 1, key);
        }
    }

    public static int[] insertionSort(int[] arr) {
        for (int i = 0; i < arr.length; ++i) {
            int current = arr[i];
            int j = i - 1;
            while(j >= 0 && arr[j] > current) {
                arr[j+1] = arr[j];
                --j;
            }
            arr[j+1] = current;
        }
        return arr;
    }

    public static void main(String[] args) {

        int[] ar = {12, 17, 6, 67, 5, 13, 81, 27, 4};

        int[] result = insertionSort(ar);

        System.out.println(Arrays.toString(result));

        int ind = binarySearch(ar, 0, ar.length, 67);
        System.out.println("Ind: " + ind + " , val: " + ar[ind]);

        ind = binarySearch(ar, 0, ar.length, 65);

        System.out.println("Ind: " + ind );
    }
}
