package com.mveeramuthu.z.oci;

class MinRotatedSortedArray {

    public int findMin(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return -1;
        }

        int numsLen  = nums.length;
        int left = 0;
        int right = numsLen - 1;

        // check whether only one element
        if (numsLen == 1) {
            return nums[0];
        }

        // check whether no rotation
        if (nums[right] > nums[0]) {
            return nums[0];
        }

        // binary search
        while (left < right) {

            int pivot = left + (right - left) / 2;

            if (nums[pivot] > nums[pivot + 1]) {
                return nums[pivot + 1];
            }

            if (nums[pivot] < nums[pivot - 1]) {
                return nums[pivot];
            }

            if (nums[pivot] > nums[0]) {
                left = pivot + 1;
            }
            else {
                right = pivot - 1;
            }
        }

        return -1;
    }
}
