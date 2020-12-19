package com.mveeramuthu.z.oci;

public class BinarySearch {
    public static int search(int[] nums, int target) {
        if(nums == null || nums.length <= 0) {
            return -1;
        }

        int numsLen = nums.length;
        int left = 0;
        int right = numsLen - 1;
        int pivot = 0;

        while(left <= right) {

            pivot = left + (right - left) / 2;

            if(nums[pivot] == target) {
                return pivot;
            }

            if(nums[pivot] < target) {

                left = pivot + 1;

            } else {

                right = pivot - 1;

            }

        }

        return -1;
    }

    public static void main(String args[]) {
        System.out.println(search(new int[]{-1,0,3,5,9,12}, 9));
    }
}
