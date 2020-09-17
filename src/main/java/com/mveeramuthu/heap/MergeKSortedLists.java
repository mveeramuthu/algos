package com.mveeramuthu.heap;

import com.mveeramuthu.ds.LinkedListNode;

import java.util.PriorityQueue;

public class MergeKSortedLists {
    private static LinkedListNode merge(LinkedListNode[] listHeads) {
        PriorityQueue<LinkedListNode> minHeap = new PriorityQueue<>((n1, n2) -> n1.data - n2.data);
        
        for(LinkedListNode listHead : listHeads) {
            if(listHead != null) {
                minHeap.add(listHead);
            }
        }

        LinkedListNode mergedListHead = null;
        LinkedListNode mergedListTail = null;
        
        while(!minHeap.isEmpty()) {
            LinkedListNode currNode = minHeap.poll();
            
            if(mergedListHead == null) {
                mergedListHead = mergedListTail = currNode;
            } else {
                mergedListTail.next = currNode;
                mergedListTail = mergedListTail.next;
            }
            
            if(currNode.next != null) {
                minHeap.add(currNode.next);
            }
        }
        
        return mergedListHead;
    }
    
    public static void main(String args[]) {
        LinkedListNode l1 = new LinkedListNode(2);
        l1.next = new LinkedListNode(6);
        l1.next.next = new LinkedListNode(8);
        LinkedListNode l2 = new LinkedListNode(3);
        l2.next = new LinkedListNode(6);
        l2.next.next = new LinkedListNode(7);
        LinkedListNode l3 = new LinkedListNode(1);
        l3.next = new LinkedListNode(3);
        l3.next.next = new LinkedListNode(4);
        
        LinkedListNode result = MergeKSortedLists.merge(new LinkedListNode[] { l1, l2, l3 });
        
        System.out.print("Here are the elements form the merged list: ");
        while (result != null) {
            System.out.print(result.data + " ");
            result = result.next;
        }
    }
}
