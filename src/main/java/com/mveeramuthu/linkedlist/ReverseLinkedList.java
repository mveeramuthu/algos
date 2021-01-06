package com.mveeramuthu.linkedlist;

import com.mveeramuthu.ds.LinkedListNode;

public class ReverseLinkedList {
    public static LinkedListNode reverse(LinkedListNode head) {
        LinkedListNode prev = null, next = null;
        LinkedListNode curr = head;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;

            prev = curr;
            curr = next;
        }

        return prev;
    }

    private static void display(LinkedListNode head) {
        System.out.println();
        while (head != null) {
            System.out.print(head.data + " -> ");
            head = head.next;
        }
    }

    public static void main(String args[]) {
        LinkedListNode node1 = new LinkedListNode(1);
        LinkedListNode node2 = new LinkedListNode(2);
        LinkedListNode node3 = new LinkedListNode(3);
        node1.next = node2;
        node2.next = node3;

        display(node1);
        display(reverse(node1));
    }
}
