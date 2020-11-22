package com.mveeramuthu.z.adobe2;

import java.util.Arrays;
import java.util.Objects;

public class Merge2SortedArrays {
    public static int[] merge(int[] arr1, int[] arr2) {
        Objects.requireNonNull(arr1);
        Objects.requireNonNull(arr2);

        int arr1Len = arr1.length;
        int arr2Len = arr2.length;
        int[] mergedArr = new int[arr1Len + arr2Len];

        int i=0, j=0, k=0;
        while (i < arr1Len && j < arr2Len) {
            if (arr1[i] <= arr2[j]) {
                mergedArr[k++] = arr1[i++];
            } else {
                mergedArr[k++] = arr2[j++];
            }
        }

        while (i < arr1Len) {
            mergedArr[k++] = arr1[i++];
        }

        while (j < arr1Len) {
            mergedArr[k++] = arr2[j++];
        }

        return mergedArr;
    }

    public static void main(String args[]) {
        int[] arr1 = new int[]{100, 200, 300};
        int[] arr2 = new int[]{50, 150, 175, 200};
        int[] mergedArr = merge(arr1, arr2);

        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
        System.out.println(Arrays.toString(mergedArr));
    }
}
