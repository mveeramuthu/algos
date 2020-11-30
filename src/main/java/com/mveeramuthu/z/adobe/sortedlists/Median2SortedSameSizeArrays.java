package com.mveeramuthu.z.adobe.sortedlists;

import java.util.Objects;

/*
int i=0, j=0, middleElement1=-1, middleElement2=-1;
        int len = arr1.length;

        for(int count=0; count <= len; count++) {

            // all arr1 elements < rightSmallest
            if(i == len) {
                middleElement1 = middleElement2;
                middleElement2 = arr2[0];
            } else if(j == len) { // all arr2 elements < leftSmallest
                middleElement1 = middleElement2;
                middleElement2 = arr1[0];
            }

            if(arr1[i] <= arr2[j]) {
                middleElement1 = middleElement2;
                middleElement2 = arr1[i++];
            } else {
                middleElement1 = middleElement2;
                middleElement2 = arr2[j++];
            }
        }

        return (middleElement1 + middleElement2)/2;
 */

public class Median2SortedSameSizeArrays {
    public static int median(int[] arr1, int[] arr2) {
        Objects.requireNonNull(arr1);
        Objects.requireNonNull(arr2);

        /*
            There will be even number of elements in the merged array
            if the input arrays are of same size.

            Hence the median = (middle 2 elements after merging) / 2
         */

        /*
            median of arr1 = median1
            median of arr2 = median2

            if(median1 == median2) {
                return median1;
            }

            if(median1 > median2) {


            }

            if(median1 < median2) {


            }

         */

        return -1;
    }

    public static void main(String args[]) {
        System.out.println(median(new int[]{1, 12, 15, 26, 38},
                           new int[]{2, 13, 17, 30, 45}));
    }
}
