package com.mveeramuthu.graph;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class WorldLadderTest { 
    @Test
    public void wordPresentInDictTest() { 
        String[] observedResult = WordLadder.transformString(new String[]{"cat", "hat", "bad", "had"}, 
                "bat", "had");
        assertEquals (new String[]{"bat", "bad", "had"}, observedResult);
    }
}
