package com.mveeramuthu.z.oci;

import java.util.HashMap;
import java.util.Map;

class DLLNode {
    int key;
    int value;
    DLLNode prev;
    DLLNode next;

    public DLLNode(int key, int value){
        this.key=key;
        this.value=value;
    }
}

public class LRUCache {
    DLLNode head;
    DLLNode tail;
    Map<Integer, DLLNode> map = null;
    int cap = 0;

    public LRUCache(int capacity) {
        this.cap = capacity;
        this.map = new HashMap<>();
    }

    public int get(int key) {
        if (map.get(key) == null) {
            return -1;
        }

        //move to tail
        DLLNode t = map.get(key);

        removeNode(t);
        addNode(t);

        return t.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            DLLNode t = map.get(key);
            t.value = value;

            //move to tail
            removeNode(t);
            addNode(t);
        } else {
            if (map.size() >= cap) {
                //delete head
                map.remove(head.key);
                removeNode(head);
            }

            //add to tail
            DLLNode DLLNode = new DLLNode(key, value);
            addNode(DLLNode);
            map.put(key, DLLNode);
        }
    }

    private void removeNode(DLLNode n) {
        if (n.prev != null) {
            n.prev.next = n.next;
        } else {
            head = n.next;
        }

        if (n.next != null) {
            n.next.prev = n.prev;
        } else {
            tail = n.prev;
        }
    }

    private void addNode(DLLNode node) {
        if (tail != null) {
            tail.next = node;
        }

        node.prev = tail;
        node.next = null;
        tail = node;

        if (head == null) {
            head = tail;
        }
    }
}
