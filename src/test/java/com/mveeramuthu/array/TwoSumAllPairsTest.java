package com.mveeramuthu.array;

import org.junit.Test;

public class TwoSumAllPairsTest { 
    @Test
    public void test1() {
        int sum = 9;
        var pairs = TwoSumAllPairs.getAllUniquePairs(new int[]{2, 7, 2, 8, 0, 9}, sum);
        pairs.forEach((pair) -> System.out.println("{" + pair + ", " + (sum - pair) + "}, "));
    }
    
}
