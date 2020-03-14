package com.mveeramuthu.z.wealthfront;

import java.util.*;

class SummingPairs {
    static List<Pair<Long, Long>> findSummingPairs(List<Long> numbers, long goal) {

        //Set<Pair<Long,Long>> summingPairsSet = new HashSet<>();

        Map<Long, List<Pair<Long, Long>>> map = new HashMap<>();

        for(Long num : numbers) {

            // check if rem is present as a key in the map
            long rem = goal-num;
            if(map.containsKey(rem)) {
                List<Pair<Long, Long>> pairsList = map.get(rem);
                pairsList.add(new Pair<>(num, rem));
                map.put(num, pairsList);
            }

            ArrayList<Pair<Long, Long>> tempList = new ArrayList<>();
            tempList.add(new Pair<Long, Long>(num, rem));

            map.put(num, tempList);
        }

        List<Pair<Long, Long>> summingPairs = new ArrayList<>();
        map.entrySet().forEach( entry -> {

            summingPairs.addAll(entry.getValue());

        });

        return summingPairs;
    }

    public static void main(String... args) {
        System.out.println(findSummingPairs(Arrays.asList(3L, 1L, 2L, 300L, 1000L, 400L, 200L, 750L, -150L, 300L), 600));

        System.out.println(findSummingPairs(Arrays.asList(3L, 1L, 200L, 300L, 1000L, 400L, 200L, 400L, -150L, 300L), 600));

        //System.out.println(findSummingPairs(Arrays.asList(1L, 2L, 3L, 2L, 2L), 4));
    }

}


class Pair<A, B> {

    public final A left;
    public final B right;

    Pair(A left, B right) {
        this.left = left;
        this.right = right;
    }

    public String toString() {
        return "(" + left + "," + right + ")";
    }

    @Override
    public int hashCode() {
        return left.hashCode() + right.hashCode();
    }

    @Override
    public boolean equals(Object other) {

        if(other instanceof Pair) {

            Pair<A, B> otherPair = (Pair<A, B>) other;

            if(this.left.equals(otherPair.left) && this.right.equals(otherPair.right)) {
                return true;
            } else if (this.left.equals(otherPair.right) && this.right.equals(otherPair.left)) {
                return true;
            }
        }
        return false;
    }

}
