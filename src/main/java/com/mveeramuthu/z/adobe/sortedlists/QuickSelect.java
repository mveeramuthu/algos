package com.mveeramuthu.z.adobe.sortedlists;

/*
function quickSelect(list, left, right, k)

   if left = right
      return list[left]

   Select a pivotIndex between left and right

   pivotIndex := partition(list, left, right,
                                  pivotIndex)
   if k = pivotIndex
      return list[k]
   else if k < pivotIndex
      right := pivotIndex - 1
   else
      left := pivotIndex + 1

 */

import java.util.Objects;

public class QuickSelect {
    public static int quickSelect(int[] arr, int k) {
        Objects.requireNonNull(arr);
        return quickSelectHelper(arr, k, 0, arr.length-1);
    }

    private static int quickSelectHelper(int[] arr, int k, int left, int right) {
        // termination condition:
        // return when the list contains only one element
        if(left == right) {
            return arr[right];
        }

        int pivotIndex = partition(arr, left, right);

        if(pivotIndex == k) {
            return arr[k];
        } else if (pivotIndex > k) {
            return quickSelectHelper(arr, k, left, pivotIndex - 1);
        } else {
            return quickSelectHelper(arr, k, pivotIndex + 1, right);
        }
    }

    private static int partition(int[] arr, int left, int right) {
        int randomPivotIndex = getRandomPivotIndex(left, right);
        int pivot = arr[randomPivotIndex];
        int newPivotIndex = left;

        for (int i = left; i <= right; i++) {
            if (arr[i] < pivot) {
                swap(arr, i, newPivotIndex);
                newPivotIndex++;
            }
        }

        swap(arr, right, newPivotIndex);

        return newPivotIndex;
    }

    private static int getRandomPivotIndex(int left, int right) {
        return (int) (left + Math.random() * (right - left + 1));
    }

    private static void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    public static void main(String args[]) {
        System.out.println(quickSelect(new int[]{7, 10, 4, 3, 20, 15}, 3));
    }
}
