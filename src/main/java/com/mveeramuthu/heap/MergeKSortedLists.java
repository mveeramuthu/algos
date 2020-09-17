package com.mveeramuthu.heap;

import com.mveeramuthu.ds.LinkedListNode;

public class MergeKSortedLists {
    private static LinkedListNode merge(LinkedListNode[] lists) {
        LinkedListNode result = new LinkedListNode(-1);
        
        
        return result;
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
