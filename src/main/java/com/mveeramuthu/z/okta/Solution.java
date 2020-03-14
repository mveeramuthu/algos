package com.mveeramuthu.z.okta;

import com.mveeramuthu.ds.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {

    // Given a sorted integer array and a int target number
// Q: write a function to find out whether that target int num exists in array or not
// if found, return the index of that matching value from array
// if not, return -1
//
// indexOf()
//
// {0,1,3,6,9} target=10 ()=>-1

    public int indexOf(int[] arr, int num) {
        if(arr == null || arr.length <= 0) {
            return -1;
        }
        return indexOfHelper(arr, 0, arr.length, num);
    }

    private int indexOfHelper(int[] arr, int start, int end, int num) {

        if(start < 0 || end > arr.length || start <= end) {
            return -1;
        }

        int arrLen = arr.length;
        int partitionIndex = (arrLen-(arrLen/2));

        if(arr[partitionIndex] < num) {
            return indexOfHelper(arr, 0, partitionIndex-1, num);
        } else if(arr[partitionIndex] > num) {
            return indexOfHelper(arr, partitionIndex+1, arrLen, num);
        } else {
            return partitionIndex;
        }

    }

// Given an integer array with random order and a target sum number
// Q: find out all pairs from that array, which add up to that sum
// {1,9,0,4,5,7,3}
// sum=9 ()=>{(9,0)(4,5)}
// sum=7 ()=>{(0,7)(4,3)}
// sum=5 ()=>{(1,4)(0,5)}

    /*
     * 8 | 1
     * 0 | 9
     * 9 | 0
     * 5 | 4
     * 4 | 5
     * 2 | 7
     * 6 | 3
     *
     *
     * */

    public static List<Pair<Integer, Integer>> getPairs(int[] arr, int sum) {

        var pairs = new ArrayList<Pair<Integer, Integer>>();
        var map = new HashMap<Integer, Integer>();
        int arrLen = arr.length;

        for(int i=0; i<arrLen; i++) { //9

            int diff = sum-arr[i]; //8

            if(map.containsKey(arr[i])) {
                pairs.add(new Pair<Integer, Integer>(arr[i], diff));
            }

            map.put(diff, arr[i]); //8 |

        }

        return pairs;
    }
    
    public static void main(String args[]) {
        
        getPairs(new int[]{1,9,0,4,5,7,3}, 9).forEach(pair -> {
            System.out.println(pair + ",");
        });
    }
}
