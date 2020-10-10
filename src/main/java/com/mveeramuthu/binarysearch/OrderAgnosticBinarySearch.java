package com.mveeramuthu.binarysearch;

class OrderAgnosticBinarySearch {
    public static int search(int[] arr, int key) {
        if(arr == null || arr.length <= 0) {
            return -1;
        }
        int start = 0;
        int end = arr.length-1;
        
        // find order
        boolean isAscending = (arr[start] < arr[end]);
        
        while(start <= end) {
            int mid = start + (end - start)/2;
            
            // found the key return the index
            if(key == arr[mid]) {
                return mid;
            }
            
            if(isAscending) {
                if(key < arr[mid]) {
                    end = mid - 1; // decrease end index
                } else {
                    start = mid + 1; // increase start index
                }
            } else {
                if(key < arr[mid]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        
        return -1; // key not found
    }

    public static void main(String[] args) {
        System.out.println(OrderAgnosticBinarySearch.search(new int[]{4, 6, 10}, 10));
        System.out.println(OrderAgnosticBinarySearch.search(new int[]{1, 2, 3, 4, 5, 6, 7}, 5));
        System.out.println(OrderAgnosticBinarySearch.search(new int[]{10, 6, 4}, 10));
        System.out.println(OrderAgnosticBinarySearch.search(new int[]{10, 6, 4}, 4));
    }
}