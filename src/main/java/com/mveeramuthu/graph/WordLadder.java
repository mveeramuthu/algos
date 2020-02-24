package com.mveeramuthu.graph;

import java.util.*;

public class WordLadder {
    public static String[] transformString(String[] dict, String startStr, String endStr){
        int startStrLen = startStr.length();
        int endStrLen = endStr.length();
        
        if(startStrLen != endStrLen) {
            System.out.println("Error: invalid input");
            return null;
        }
        
        // add the target string to the dictionary
        List<String> dictList = new ArrayList<>(Arrays.asList(dict));
        dictList.add(endStr);
        
        // perform bfs
        Queue<String> wordsQueue = new LinkedList<>();
        Queue<List<String>> pathsQueue = new LinkedList<>();

        wordsQueue.offer(startStr); // add start string 

        while(!wordsQueue.isEmpty()) {
            List<String> visitedList = new ArrayList<>();
            String currStr = wordsQueue.poll();
            List<String> currStrPath = pathsQueue.poll();

            // create all possible words by substituting one character at-a-time in current string
            for (int i = 0; i < currStr.length(); i++) {
                for (char c = 'a'; c <= 'z'; c++) {
                    String nextStr = currStr.substring(0, i) + c +
                            currStr.substring(i + 1);
                    // visited already
                    if (visitedList.contains(nextStr)) {
                        continue;
                    }

                    // found the target word
                    if (nextStr.equals(endStr)) {
                        // add path from start word to end word to result
                        List<String> nextStrPath = new ArrayList<>(currStrPath);
                        nextStrPath.add(nextStr);
                        return nextStrPath.toArray(new String[0]);
                    } else if (dictList.contains(nextStr)) {
                        wordsQueue.offer(nextStr);
                        List<String> nextStrPath = new ArrayList<>(currStrPath);
                        nextStrPath.add(nextStr);
                        pathsQueue.add(nextStrPath);
                        visitedList.add(nextStr);
                    }
                }
            }
        }
        return null;
    }
}
