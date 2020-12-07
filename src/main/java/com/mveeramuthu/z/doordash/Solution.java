package com.mveeramuthu.z.doordash;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {

        //sort the engineers by efficency descending
        //use a priority queue to store the slowest (minHeap) engineers
        //let k limit your minHeap, and as we encounter new engineers and our team size grows larger than k, evict the slowest ones, and use the new eng's efficiency to update the maxPerf

        //this is a nicer structure to work with
        List<Engineer> engineers = new ArrayList<>();

        for(int i = 0; i < n; i++)
            engineers.add(new Engineer(speed[i], efficiency[i]));

        //now sort the engineers list by their efficiency descending

        engineers.sort((a, b) -> b.efficiency - a.efficiency);

        //will keep slowest members at the top, fastest ones stay in the team longest
        PriorityQueue<Engineer> currentTeam = new PriorityQueue<>((a, b) -> a.speed - b.speed);

        //now iterate the engineers by most efficient to least, and add them to the currentTeam

        long teamSpeed = 0;
        long maxPerformance = Long.MIN_VALUE;

        for(Engineer newHire : engineers){

            //System.out.println(newHire.efficiency + " " + newHire.speed);

            if(currentTeam.size() == k){

                //we must evict the slowest engineer from out current team

                Engineer slowGuy = currentTeam.poll();

                //System.out.println("slowGuy: " + slowGuy.efficiency + " " + slowGuy.speed);
                //now we must remove the slow guys speed from our total speed

                teamSpeed -= slowGuy.speed;
            }

            //we are hiring a new engineer, either he is replacing someone as in condition above ^ or he's just a newcomer b.c.
            //out team is still small (< k)

            //hire the new guy!! (add him to the team)
            currentTeam.add(newHire);

            //so pickup the new engineers speed and add it to the current teams speed
            teamSpeed += newHire.speed;

            //update max with the new engineers efficiency
            //since eng's are sorted descending, this is will be the least efficient seen yet, which satisfies the condition
            //of The performance of a team is the sum of their engineers' speeds multiplied by the minimum efficiency among their engineers.

            long performanceWithNewGuy = teamSpeed * (long) newHire.efficiency;

            //check wether the performance has been imporved br bringing on the new hire
            maxPerformance = Math.max(maxPerformance, performanceWithNewGuy);
        }

       return (int) (maxPerformance % MOD);
    }

    int MOD = (int) (1e9 + 7);

    class Engineer{

        int speed;
        int efficiency;

        public Engineer(int speed, int efficiency){

            this.speed = speed;
            this.efficiency = efficiency;
        }
    }
}
