package com.mveeramuthu.ds;

import java.util.*;

public class LRUCache {

    // use doubly linked list (double ended queue) to store keys
    Deque<Integer> keys;

    // use set to store reference to the keys
    Set<Integer> keyReferences;

    // max cache capacity
    int cacheSize;

    LRUCache(int cacheSize) {
        this.cacheSize = cacheSize;
        keys = new LinkedList<>();
        keyReferences = new HashSet<>();
    }

    // get value of key from cache
    public void getForKey(int key) {
        // if keyReferences contains the requested key
        if(keyReferences.contains(key)) {
            // remove the found key from it's current index and
            // add it to the start of the "keys" queue
            Iterator<Integer> i = keys.iterator();
            int keyCurrIndex = 0;
            int j = 0;

            while (i.hasNext()) {
                if(i.next() == key) {
                    keyCurrIndex = j;
                    break;
                }
                j++;
            }
            keys.remove(keyCurrIndex);
        }
        // keyReferences does not contain the requested key and also if the cache is full
        else if(keys.size() == cacheSize) {
            // remove last key from "keys" queue
            int keyToBeDeleted = keys.removeLast();
            //remove the same key from the key references set
            keyReferences.remove(keyToBeDeleted);
        }

        keys.push(key);
        keyReferences.add(key);
    }

    // display contents of cache
    public void display() {
        Iterator<Integer> keyIterator = keys.iterator();
        while(keyIterator.hasNext()) {
            System.out.print(" | " + keyIterator.next());
        }
        System.out.println();
    }
}
