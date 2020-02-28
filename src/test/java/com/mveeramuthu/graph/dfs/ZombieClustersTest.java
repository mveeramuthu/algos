package com.mveeramuthu.graph.dfs;

import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;

public class ZombieClustersTest { 
    @Test
    public void test1() {   
        var zombieClusters = new ArrayList<String>();
        zombieClusters.add("3");
        zombieClusters.add("1");
        zombieClusters.add("1");
        zombieClusters.add("0");
        zombieClusters.add("1");
        zombieClusters.add("1");
        zombieClusters.add("0");
        zombieClusters.add("0");
        zombieClusters.add("0");
        zombieClusters.add("1");
        assertEquals(-1, ZombieClusters.getZombieClustersCount(zombieClusters));
    }
}
