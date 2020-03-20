package com.mveeramuthu.z.box;

import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class Solution {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<String>();
        strings.add("Hello, World!");
        strings.add("Welcome to CoderPad.");
        strings.add("This pad is running Java " + Runtime.version().feature());

        for (String string : strings) {
            System.out.println(string);
        }
    }


    public static int countSetBits(int x) {

        int setBitCount = 0;

        while(x > 0) {
            int remainder = x%2;
            setBitCount += remainder;
            x = x/2;

        }
        return setBitCount;
    }


}


/*

// Multi-threaded web server that serves html files and tracks # of page visits
class MyRequestHandler implements IHandler {

    private long pageVisitCount = 0;

    private synchronized void incrementVisitCount() {
        pageVisitCount++;
    }

    public String handle(String htmlFilePath) {

        incrementVisitCount();

        return retrieveFile(htmlFilePath);
    }
    public long getNumPageVisits() {
        return pageVisitCount;
    }
}
*/