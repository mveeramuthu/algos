package com.mveeramuthu.z.branch;


/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

// https://www.names.org/n/mohanasundaram/about

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindCommonStations {

        static int[] train1 = {360, 580, 970, 220, 1100}; // {220, 360, 580, 970, 1100}
        static int[] train2 = {220, 630, 770, 360, 1250}; // {220, 360, 630, 770, 1250}
//  int[] result = { 360, 220 };

        public static int[] getCommmonStations(int[] train1, int[] train2) throws Exception {

            if(train1 == null || train2 == null || train1.length <=0 || train2.length <=0) {
                throw new Exception("Invalid input");
            }

            Arrays.sort(train1);
            Arrays.sort(train2);

            int train1Len = train1.length;
            int train2Len = train2.length;

            //int maxLen = train1Len > train2Len ? train1Len : train2Len;

            //int[] result = new int[maxLen]; // 200,

            List<Integer> resultList = new ArrayList<>();

            for(int i=0, j=0; i<train1Len && j<train2Len; ) {

                if(train1[i] == train2[j]) { //200 == 200
                    resultList.add(train1[i]);
                    i++;
                    j++;
                } else if(train1[i] < train2[j]) {
                    i++;
                } else if(train1[i] > train2[j]) {
                    j++;
                }
            }


            int len = resultList.size();
            int[] result = new int[len];
            for(int i=0; i<len; i++) {
                result[i] = resultList.get(i);
            }

            return result;
        }

        public static void main(String[] args) {
            try {
                int[] result = getCommmonStations(train1, train2);
                int resultLen = result.length;
                for(int i=0; i<resultLen; i++) {
                    System.out.print(result[i] + ",");
                }
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
    }
}
