package com.mveeramuthu.ds;

import org.junit.Test;

public class LRUCacheTest {
    @Test
    public void positiveTest() {
        LRUCache lruCache = new LRUCache(4);
        
        lruCache.getForKey(1);
        lruCache.display();
        
        lruCache.getForKey(2);
        lruCache.display();
        
        lruCache.getForKey(3);
        lruCache.display();

        lruCache.getForKey(1);
        lruCache.display();

        lruCache.getForKey(4);
        lruCache.display();

        lruCache.getForKey(5);
        lruCache.display();
    }
}
