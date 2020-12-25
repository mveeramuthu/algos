package com.mveeramuthu.z.oci;

import java.util.Arrays;

public class MoveZeroes {
    public static void moveZeroes(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return;
        }

        int numsLen = nums.length;
        int i = 0;

        for (int j = 0; j < numsLen; j++) {

            System.out.println("i=" + i + ", j=" + j + ", nums=" + Arrays.toString(nums));

            if (nums[j] != 0) {
                nums[i] = nums[j];
                i++;
            }
        }

        for (int j = i; j < numsLen; j++) {
            System.out.println("i=" + i + ", j=" + j + ", nums=" + Arrays.toString(nums));
            nums[j] = 0;
        }
    }

    public static void main(String args[]) {
        int[] nums ={0, 1, 0, 3, 12};
        //System.out.println(Arrays.toString(nums));
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
