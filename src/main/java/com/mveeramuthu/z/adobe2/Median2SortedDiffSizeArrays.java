package com.mveeramuthu.z.adobe2;

import java.util.Objects;

public class Median2SortedDiffSizeArrays {
    public static int median(int[] arr1, int[] arr2) {
        Objects.requireNonNull(arr1);
        Objects.requireNonNull(arr2);


        return -1;
    }

    public static void main(String args[]) {
        System.out.println(median(new int[]{1, 12, 15, 26, 38},
                           new int[]{2, 13, 17, 30, 45}));
    }
}
