package com.mveeramuthu.z.adobe2;

import com.mveeramuthu.ds.LinkedListNode;

import java.util.Objects;

public class Merge2SortedLists {
    public static LinkedListNode mergeTwoLists(LinkedListNode list1, LinkedListNode list2) {
        Objects.requireNonNull(list1);
        Objects.requireNonNull(list2);

        var prehead = new LinkedListNode(-1);
        var prev = prehead;

        while(list1 != null && list2 != null) {
            if(list1.data <= list2.data) {
                prev.next = list1;
                list1 = list1.next;
            } else {
                prev.next = list2;
                list2 = list2.next;
            }

            prev = prev.next;
        }

        if(list1 == null) {
            prev.next = list2;
        } else {
            prev.next = list1;
        }

        return prehead.next;
    }

    private static void printList(LinkedListNode node) {
        while(node != null) {
            System.out.print(node.data + " -> ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String args[]) {
        var list1 = new LinkedListNode(100);
        list1.next = new LinkedListNode(200);
        list1.next = new LinkedListNode(300);

        var list2 = new LinkedListNode(50);
        list2.next = new LinkedListNode(150);
        list2.next = new LinkedListNode(175);
        list2.next = new LinkedListNode(200);

        System.out.println("list1: ");
        printList(list1);

        System.out.println("list2: ");
        printList(list2);

        var mergedList = mergeTwoLists(list1, list2);
        System.out.println("mergedList: ");
        printList(mergedList);
    }
}
