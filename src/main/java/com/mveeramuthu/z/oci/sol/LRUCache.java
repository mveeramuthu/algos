package com.mveeramuthu.z.oci.sol;

import java.util.HashMap;

class LRUCache {
    HashMap<Integer, CacheNode> map = new HashMap<Integer, CacheNode>();
    int capacity;
    int currentCapacity = 0;
    CacheNode head = null;
    CacheNode tail = null;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            CacheNode node = map.get(key);
            remove(node);
            addAtTop(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        CacheNode node;
        if (map.containsKey(key)) {
            node = map.get(key);
            node.value = value;
            remove(node);
        } else {
            node = new CacheNode(key, value);
            map.put(key, node);
            if (map.size() > capacity) // We have reached maxium size so need to make room for new element.
            {
                map.remove(tail.key);
                remove(tail);
            }
        }

        addAtTop(node);
    }

    void remove(CacheNode node) {
        // the node is at the start
        if (node.prev == null) {
            head = node.next;
        } else {
            // attach the previous node to the next node
            node.prev.next = node.next;
        }
// the node is at the end
        if (node.next == null) {
            tail = node.prev;
        } else {
            // attach the next node to the previous node
            node.next.prev = node.prev;
        }
    }

    void addAtTop(CacheNode node) {

        // replace start with new node
        node.prev = null;
// if start is null
        if (head != null) {
            node.next = head;
            head.prev = node;
        }
        head = node;
// only node in the list
        if (tail == null)
            tail = head;
    }
}

class CacheNode {
    int key, value;
    // pointer to the previous node and next node
    CacheNode prev;
    CacheNode next;

    CacheNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
