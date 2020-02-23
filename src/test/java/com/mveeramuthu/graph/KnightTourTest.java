package com.mveeramuthu.graph;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class KnightTourTest { 
    @Test
    public void findMinMovesFirstQuadrantPositiveTest() { 
        int observedResult = KnightTour.findMinMoves(5, 5, 0, 0, 4, 1);
        assertEquals (3, observedResult);
    }
    @Test
    public void findMinMovesFirstQuadrantNegativeTest() {
        int observedResult = KnightTour.findMinMoves(5, 5, 0, 0, 3, 1);
        assertEquals (-1, observedResult);
    }
}
