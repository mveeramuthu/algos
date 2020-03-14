package com.mveeramuthu.z.adobe;

import com.mveeramuthu.ds.LinkedListNode;

public class ReverseLinkedList {

    public static LinkedListNode reverseLinkedList(LinkedListNode head) {
        if(head == null) {
            return null;
        }

        LinkedListNode currNode = head;
        LinkedListNode prevNode = null;
        LinkedListNode nextNode = null;
        
        while(currNode != null) {
            
            nextNode = currNode.next;
            currNode.next = prevNode;
            
            prevNode = currNode;
            currNode = nextNode;
        }
        
        return prevNode;
    }
    
    public static void printList(LinkedListNode head) {
        if(head == null) {
            System.out.print(" null\n");
            return;
        }
        System.out.print(head.data + " -> ");
        printList(head.next);
    }
    
    public static void main(String[] args)
    {
        int arr[] = new int[] {12, 56, 2, 11, 1, 890};

        LinkedListNode head = new LinkedListNode(arr[0]);
        LinkedListNode prevNode = head;
        LinkedListNode currNode = null;
        
        for (int i = 1; i < arr.length; i++) {
            currNode = new LinkedListNode(arr[i]);
            prevNode.next = currNode;
            prevNode = currNode;
        }

        System.out.println("original list: ");
        printList(head);

        head = reverseLinkedList(head);

        System.out.println("\nreversed list: ");
        printList(head);
    }
}
