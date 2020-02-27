package com.mveeramuthu.graph.bfs;

import com.mveeramuthu.graph.bfs.WordLadder;
import org.junit.Assert;
import org.junit.Test;

public class WorldLadderTest { 
    @Test
    public void wordPresentInDictTest() { 
        String[] observedResult = WordLadder.transformString(new String[]{"cat", "rat", "bad", "had"}, 
                "bat", "had");
        
        for(String word : observedResult) {
            System.out.print(word + " -> ");
        }
        
        Assert.assertArrayEquals(new String[]{"bat", "bad", "had"}, observedResult);
    }
}
