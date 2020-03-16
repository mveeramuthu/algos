package com.mveeramuthu.array;

import org.junit.Test;

public class ThreeSumTest { 
    @Test
    public void test1() {
        int sum = 4;
        var triplets = ThreeSum.getThreeSum(new int[]{2, 2, 1, 1, 0, 3, 0}, sum);
        triplets.forEach((triplet) -> System.out.println("{" + triplet.get(0) + ", " + triplet.get(1) + ", " + triplet.get(2) + "}, "));
    }
    
}
