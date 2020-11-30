package com.mveeramuthu.twopointer;

class TrappingRainWater {
    public int trap(int[] height) {
        int amount = 0;

        int left = 0; //left pointer
        int right = height.length - 1; //right pointer

        int leftBorder = 0;
        int rightBorder = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                leftBorder = Math.max(height[left], leftBorder); // find the maximum as leftborder
                amount += leftBorder - height[left]; //because height[left]<height[right],
                // according to Cannikin Law, we only care about teh leftborder.
                left++; //move the left pointer
            } else  //same as the left pointer, we move the right pointer here if height[left]<=height[right]
            {
                rightBorder = Math.max(height[right], rightBorder);
                amount += rightBorder - height[right];
                right--;
            }

        }

        return amount;
    }
}
