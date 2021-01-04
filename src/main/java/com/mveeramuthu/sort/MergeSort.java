package com.mveeramuthu.sort;

import java.util.Arrays;

public class MergeSort {
    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        int arrLen = arr.length;
        int mid = arrLen / 2;

        int[] leftArr = Arrays.copyOfRange(arr, 0, mid);
        int[] rightArr = Arrays.copyOfRange(arr, mid, arrLen);

        System.out.println("Divided " + Arrays.toString(arr) + " into " + Arrays.toString(leftArr) + " and " + Arrays.toString(rightArr));

        mergeSort(leftArr);
        mergeSort(rightArr);

        merge(arr, leftArr, rightArr);
    }

    private static void merge(int[] arr, int[] leftArr, int[] rightArr) {
        int leftArrLen = leftArr.length;
        int rightArrLen = rightArr.length;

        int left = 0;
        int right = 0;
        int i = 0;

        while (left < leftArrLen && right < rightArrLen) {
            if (leftArr[left] < rightArr[right]) {
                arr[i++] = leftArr[left++];
            } else {
                arr[i++] = rightArr[right++];
            }
        }

        while (left < leftArrLen) {
            arr[i++] = leftArr[left++];
        }

        while (right < rightArrLen) {
            arr[i++] = rightArr[right++];
        }

        System.out.println("Merged " + Arrays.toString(leftArr) + " and " + Arrays.toString(rightArr) + " to get " + Arrays.toString(arr));
    }

    public static void main(String args[]) {
        var inputArr = new int[]{5, 1, 6, 2, 3, 4};
        System.out.println("Input: " + Arrays.toString(inputArr));
        mergeSort(inputArr);
        System.out.println("Output: " + Arrays.toString(inputArr));
    }
}
